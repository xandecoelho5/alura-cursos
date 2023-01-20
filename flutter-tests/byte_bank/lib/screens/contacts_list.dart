import 'package:byte_bank/components/container.dart';
import 'package:byte_bank/components/progress.dart';
import 'package:byte_bank/models/contact.dart';
import 'package:byte_bank/screens/contact_form.dart';
import 'package:byte_bank/screens/transaction_form.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../models/contacts_list_cubit.dart';
import '../widgets/app_dependencies.dart';

class ContactsListContainer extends BlocContainer {
  const ContactsListContainer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (_) {
        final cubit = ContactsListCubit();
        cubit.reload(AppDependencies.of(context).contactDao);
        return cubit;
      },
      child: const ContactsList(),
    );
  }
}

class ContactsList extends StatelessWidget {
  const ContactsList({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Transfer')),
      body: BlocBuilder<ContactsListCubit, ContactsListState>(
        builder: (context, state) {
          if (state is ErrorContactsListState) {
            return Text('Error loading contacts: ${state.message}');
          }

          if (state is LoadedContactsListState) {
            final contacts = state.contacts;
            return ListView.builder(
              itemBuilder: (context, index) {
                final Contact contact = contacts[index];
                return ContactItem(
                  contact,
                  onClick: () =>
                      push(context, TransactionFormContainer(contact)),
                );
              },
              itemCount: contacts.length,
            );
          }

          return Progress();
        },
      ),
      floatingActionButton: buildAddContactButton(context),
    );
  }

  FloatingActionButton buildAddContactButton(BuildContext context) {
    return FloatingActionButton(
      onPressed: () {
        Navigator.of(context)
            .push(MaterialPageRoute(builder: (context) => const ContactForm()))
            .then((value) => update(context));
      },
      child: const Icon(Icons.add),
    );
  }

  update(BuildContext context) {
    context
        .read<ContactsListCubit>()
        .reload(AppDependencies.of(context).contactDao);
  }
}

class ContactItem extends StatelessWidget {
  final Contact contact;
  final Function onClick;

  const ContactItem(
    this.contact, {
    required this.onClick,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        onTap: () => onClick(),
        title: Text(
          contact.name,
          style: const TextStyle(fontSize: 24.0),
        ),
        subtitle: Text(
          contact.accountNumber.toString(),
          style: const TextStyle(fontSize: 16.0),
        ),
      ),
    );
  }
}
