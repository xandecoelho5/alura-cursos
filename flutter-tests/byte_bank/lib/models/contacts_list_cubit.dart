import 'package:byte_bank/database/dao/contact_dao.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'contact.dart';

abstract class ContactsListState {
  const ContactsListState();
}

class InitialContactsListState extends ContactsListState {
  const InitialContactsListState();
}

class LoadingContactsListState extends ContactsListState {
  const LoadingContactsListState();
}

class LoadedContactsListState extends ContactsListState {
  final List<Contact> contacts;

  const LoadedContactsListState(this.contacts);
}

class ErrorContactsListState extends ContactsListState {
  final String message;

  const ErrorContactsListState(this.message);
}

class ContactsListCubit extends Cubit<ContactsListState> {
  ContactsListCubit() : super(const InitialContactsListState());

  reload(ContactDao dao) {
    emit(const LoadingContactsListState());
    dao.findAll()?.then((contacts) {
      emit(LoadedContactsListState(contacts));
    }).catchError((e) {
      emit(ErrorContactsListState(e.message));
    });
  }
}
