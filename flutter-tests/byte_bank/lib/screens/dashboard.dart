import 'package:byte_bank/components/container.dart';
import 'package:byte_bank/models/name_cubit.dart';
import 'package:byte_bank/screens/contacts_list.dart';
import 'package:byte_bank/screens/name.dart';
import 'package:byte_bank/screens/transactions_list.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class DashboardContainer extends BlocContainer {
  const DashboardContainer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (_) => NameCubit('Xandzera'),
      child: const DashboardView(),
    );
  }
}

class DashboardView extends StatelessWidget {
  const DashboardView({super.key});

  @override
  Widget build(BuildContext context) {
    final name = context.watch<NameCubit>().state;
    return Scaffold(
      appBar: AppBar(
        title: Text('Welcome $name'),
      ),
      body: LayoutBuilder(
        builder: (context, constraints) => SingleChildScrollView(
          child: ConstrainedBox(
            constraints: BoxConstraints(minHeight: constraints.maxHeight),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Image.asset('images/bytebank_logo.png'),
                ),
                Container(
                  height: 120,
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: <Widget>[
                      FeatureItem(
                        'Transfer',
                        Icons.monetization_on,
                        onClick: () => _showContactsList(context),
                      ),
                      FeatureItem(
                        'Transaction Feed',
                        Icons.description,
                        onClick: () => _showTransactionsList(context),
                      ),
                      FeatureItem(
                        'Change name',
                        Icons.person_outline,
                        onClick: () => _showChangeName(context),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void _showContactsList(BuildContext blocContext) {
    push(blocContext, const ContactsListContainer());
  }

  void _showChangeName(BuildContext blocContext) {
    Navigator.of(blocContext).push(
      MaterialPageRoute(
        builder: (context) => BlocProvider.value(
          value: BlocProvider.of<NameCubit>(blocContext),
          child: const NameContainer(),
        ),
      ),
    );
  }

  void _showTransactionsList(BuildContext context) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => TransactionsList(),
      ),
    );
  }
}

class FeatureItem extends StatelessWidget {
  final String name;
  final IconData icon;
  final Function onClick;

  FeatureItem(
    this.name,
    this.icon, {
    required this.onClick,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Material(
        color: Theme.of(context).primaryColor,
        child: InkWell(
          onTap: () => onClick(),
          child: Container(
            padding: EdgeInsets.all(8.0),
            width: 150,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Icon(
                  icon,
                  color: Colors.white,
                  size: 24.0,
                ),
                Text(
                  name,
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 16.0,
                  ),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
