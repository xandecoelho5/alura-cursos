import 'package:byte_bank/database/dao/contact_dao.dart';
import 'package:byte_bank/http/webclients/transaction_webclient.dart';
import 'package:flutter/material.dart';

class AppDependencies extends InheritedWidget {
  final ContactDao contactDao;
  final TransactionWebClient transactionWebClient;
  final Widget child;

  const AppDependencies({
    required this.contactDao,
    required this.transactionWebClient,
    required this.child,
  }) : super(child: child);

  static AppDependencies of(BuildContext context) =>
      context.dependOnInheritedWidgetOfExactType<AppDependencies>()!;

  @override
  bool updateShouldNotify(covariant AppDependencies oldWidget) =>
      contactDao != oldWidget.contactDao ||
      transactionWebClient != oldWidget.transactionWebClient;
}
