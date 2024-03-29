import 'package:byte_bank/database/dao/contact_dao.dart';
import 'package:byte_bank/http/webclients/transaction_webclient.dart';
import 'package:mockito/mockito.dart';

class MockContactDao extends Mock implements ContactDao {}

class MockTransactionWebClient extends Mock implements TransactionWebClient {}
