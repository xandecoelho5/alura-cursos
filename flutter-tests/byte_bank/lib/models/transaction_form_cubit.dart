import 'dart:async';

import 'package:byte_bank/http/webclients/transaction_webclient.dart';
import 'package:byte_bank/models/transaction.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

abstract class TransactionFormState {
  const TransactionFormState();
}

class SendingState extends TransactionFormState {
  const SendingState();
}

class ShowFormState extends TransactionFormState {
  const ShowFormState();
}

class SentState extends TransactionFormState {
  const SentState();
}

class FatalErrorFormState extends TransactionFormState {
  final String message;

  const FatalErrorFormState(this.message);
}

class TransactionFormCubit extends Cubit<TransactionFormState> {
  TransactionFormCubit() : super(const ShowFormState());

  void save(
    TransactionWebClient transactionWebClient,
    Transaction transactionCreated,
    String password,
    BuildContext context,
  ) async {
    emit(const SendingState());
    await _send(transactionWebClient, transactionCreated, password, context);
  }

  Future<void> _send(
    TransactionWebClient webClient,
    Transaction transactionCreated,
    String password,
    BuildContext context,
  ) async {
    await webClient
        .save(transactionCreated, password)
        .then((transaction) => emit(const SentState()))
        .catchError((e) {
      emit(FatalErrorFormState(e.toString()));
    }, test: (e) => e is HttpException).catchError((e) {
      emit(const FatalErrorFormState('timeout submitting the transaction'));
    }, test: (e) => e is TimeoutException).catchError(
      (e) {
        emit(FatalErrorFormState(e.toString()));
      },
    );
  }
}
