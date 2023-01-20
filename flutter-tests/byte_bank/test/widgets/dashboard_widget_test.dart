import 'package:byte_bank/screens/dashboard.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import '../matchers/matchers.dart';
import '../mock/mocks.dart';

void main() {
  group('When Dashboard is opened', () {
    final mockContactDao = MockContactDao();

    testWidgets('Should display the main image', (tester) async {
      await tester.pumpWidget(MaterialApp(home: DashboardView()));
      final mainImage = find.byType(Image);
      expect(mainImage, findsOneWidget);
    });

    testWidgets('Should display the transfer feature', (tester) async {
      await tester.pumpWidget(MaterialApp(home: DashboardView()));
      final transferFeatureItem = find.byWidgetPredicate((widget) =>
          featureItemMatcher(widget, 'Transfer', Icons.monetization_on));
      expect(transferFeatureItem, findsOneWidget);
    });

    testWidgets('Should display the transaction feed feature', (tester) async {
      await tester.pumpWidget(MaterialApp(home: DashboardView()));
      final transactionFeedFeatureItem = find.byWidgetPredicate((widget) =>
          featureItemMatcher(widget, 'Transaction Feed', Icons.description));
      expect(transactionFeedFeatureItem, findsOneWidget);
    });
  });
}
