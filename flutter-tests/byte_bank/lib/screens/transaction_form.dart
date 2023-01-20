import 'package:byte_bank/components/container.dart';
import 'package:byte_bank/components/error.dart';
import 'package:byte_bank/components/progress.dart';
import 'package:byte_bank/components/transaction_auth_dialog.dart';
import 'package:byte_bank/models/contact.dart';
import 'package:byte_bank/models/transaction.dart';
import 'package:byte_bank/models/transaction_form_cubit.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:uuid/uuid.dart';

import '../widgets/app_dependencies.dart';

class TransactionFormContainer extends BlocContainer {
  const TransactionFormContainer(this.contact, {Key? key}) : super(key: key);

  final Contact contact;

  @override
  Widget build(BuildContext context) {
    return BlocProvider<TransactionFormCubit>(
      create: (_) => TransactionFormCubit(),
      child: BlocListener<TransactionFormCubit, TransactionFormState>(
        listener: (context, state) {
          if (state is SentState) {
            Navigator.pop(context);
          }
        },
        child: TransactionForm(contact),
      ),
    );
  }
}

class TransactionForm extends StatelessWidget {
  TransactionForm(this.contact);

  final Contact contact;

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<TransactionFormCubit, TransactionFormState>(
      builder: (context, state) {
        if (state is ShowFormState) {
          return _BasicForm(contact);
        }
        if (state is SendingState || state is SentState) {
          return ProgressView();
        }
        if (state is FatalErrorFormState) {
          return ErrorView(state.message);
        }
        return ErrorView('Unknown error');
      },
    );
  }
}

class _BasicForm extends StatelessWidget {
  _BasicForm(this.contact, {Key? key}) : super(key: key);

  final Contact contact;
  final TextEditingController _valueController = TextEditingController();
  final String transactionId = const Uuid().v4();

  @override
  Widget build(BuildContext context) {
    final dependencies = AppDependencies.of(context);
    return Scaffold(
      appBar: AppBar(title: const Text('New transaction')),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                contact.name,
                style: const TextStyle(fontSize: 24.0),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 16.0),
                child: Text(
                  contact.accountNumber.toString(),
                  style: const TextStyle(
                    fontSize: 32.0,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 16.0),
                child: TextField(
                  controller: _valueController,
                  style: TextStyle(fontSize: 24.0),
                  decoration: InputDecoration(labelText: 'Value'),
                  keyboardType: TextInputType.numberWithOptions(decimal: true),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 16.0),
                child: SizedBox(
                  width: double.maxFinite,
                  child: ElevatedButton(
                    child: Text('Transfer'),
                    onPressed: () {
                      final double? value =
                          double.tryParse(_valueController.text);
                      final transactionCreated = Transaction(
                        transactionId,
                        value!,
                        contact,
                      );
                      showDialog(
                        context: context,
                        builder: (contextDialog) {
                          return TransactionAuthDialog(
                            onConfirm: (String password) {
                              BlocProvider.of<TransactionFormCubit>(context)
                                  .save(
                                dependencies.transactionWebClient,
                                transactionCreated,
                                password,
                                context,
                              );
                            },
                          );
                        },
                      );
                    },
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
