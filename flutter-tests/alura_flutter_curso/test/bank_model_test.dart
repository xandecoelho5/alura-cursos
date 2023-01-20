import 'package:estilizacao_componentes/models/bank.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  group('Bank model deposit tests', () {
    test(
      'Bank model deposit should turn points, available and earned to 10',
      () {
        final bank = BankModel();
        bank.deposit(10);
        expect(bank.available, 10);
        expect(bank.points, 10);
        expect(bank.earned, 10);
      },
    );
  });

  group('Bank model transfer tests', () {
    test(
      'Bank model tranfer should turn points and spent to 10 and available to -10',
      () {
        final bank = BankModel();
        bank.transfer(10);
        expect(bank.available, -10);
        expect(bank.points, 10);
        expect(bank.spent, 10);
      },
    );
  });
}
