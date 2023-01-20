import 'package:estilizacao_componentes/components/box_card.dart';
import 'package:estilizacao_componentes/data/bank_http.mocks.dart';
import 'package:estilizacao_componentes/data/bank_inherited.dart';
import 'package:estilizacao_componentes/screens/home.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';

void main() {
  final httpMock = MockBankHttp();

  group('Home widget tests', () {
    when(httpMock.dolarToReal()).thenAnswer((_) async => ('5'));

    testWidgets('My widget has a text "Spent"', (tester) async {
      await tester.pumpWidget(
        MaterialApp(
          home: BankInherited(child: Home(api: httpMock.dolarToReal())),
        ),
      );

      final spentFinder = find.text('Spent');
      expect(spentFinder, findsOneWidget);
    });

    testWidgets('Finds a LinearProgressIndicator', (tester) async {
      await tester.pumpWidget(
        MaterialApp(
          home: BankInherited(child: Home(api: httpMock.dolarToReal())),
        ),
      );

      expect(find.byType(LinearProgressIndicator), findsOneWidget);
    });

    testWidgets('Finds the AccountStatus', (tester) async {
      await tester.pumpWidget(
        MaterialApp(
          home: BankInherited(child: Home(api: httpMock.dolarToReal())),
        ),
      );

      expect(find.byKey(Key('testKey')), findsOneWidget);
    });

    testWidgets('Finds 5 BoxCards', (tester) async {
      await tester.pumpWidget(
        MaterialApp(
          home: BankInherited(child: Home(api: httpMock.dolarToReal())),
        ),
      );

      expect(
        find.byWidgetPredicate((widget) => widget is BoxCard),
        findsNWidgets(5),
      );
    });

    testWidgets('When tap Deposit should upload earned in 10', (tester) async {
      await tester.pumpWidget(
        MaterialApp(
          home: BankInherited(child: Home(api: httpMock.dolarToReal())),
        ),
      );

      await tester.tap(find.text('Deposit'));
      await tester.tap(find.text('Earned'));
      await tester.pumpAndSettle();

      expect(find.text('\$10.0'), findsOneWidget);
    });
  });

  testWidgets('Testing MockHttp dolarToReal', (tester) async {
    final httpMock = MockBankHttp();

    when(httpMock.dolarToReal()).thenAnswer((_) async => ('5'));

    await tester.pumpWidget(
      MaterialApp(
        home: BankInherited(child: Home(api: httpMock.dolarToReal())),
      ),
    );

    verify(httpMock.dolarToReal()).called(1);
  });
}
