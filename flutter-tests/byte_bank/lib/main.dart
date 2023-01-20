import 'package:byte_bank/database/dao/contact_dao.dart';
import 'package:byte_bank/http/webclients/transaction_webclient.dart';
import 'package:byte_bank/screens/dashboard.dart';
import 'package:byte_bank/widgets/app_dependencies.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(BytebankApp(
    contactDao: ContactDao(),
    transactionWebClient: TransactionWebClient(),
  ));
}

class BytebankApp extends StatelessWidget {
  const BytebankApp({
    super.key,
    required this.contactDao,
    required this.transactionWebClient,
  });

  final ContactDao contactDao;
  final TransactionWebClient transactionWebClient;

  @override
  Widget build(BuildContext context) {
    return AppDependencies(
      contactDao: contactDao,
      transactionWebClient: transactionWebClient,
      child: MaterialApp(
        theme: ThemeData(
          primaryColor: Colors.green[900],
          accentColor: Colors.blueAccent[700],
          buttonTheme: ButtonThemeData(
            buttonColor: Colors.blueAccent[700],
            textTheme: ButtonTextTheme.primary,
          ),
        ),
        home: const DashboardContainer(),
        debugShowCheckedModeBanner: false,
      ),
    );
  }
}
