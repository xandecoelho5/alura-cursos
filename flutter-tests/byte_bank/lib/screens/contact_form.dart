import 'package:byte_bank/database/dao/contact_dao.dart';
import 'package:byte_bank/models/contact.dart';
import 'package:flutter/material.dart';

import '../widgets/app_dependencies.dart';

class ContactForm extends StatefulWidget {
  const ContactForm({super.key});

  @override
  _ContactFormState createState() => _ContactFormState();
}

class _ContactFormState extends State<ContactForm> {
  final _nameController = TextEditingController();
  final _accountNumberController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    final dependencies = AppDependencies.of(context);
    return Scaffold(
      appBar: AppBar(title: const Text('New contact')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            TextField(
              controller: _nameController,
              decoration: InputDecoration(labelText: 'Full name'),
              style: TextStyle(
                fontSize: 24.0,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 8.0),
              child: TextField(
                controller: _accountNumberController,
                decoration: InputDecoration(
                  labelText: 'Account number',
                ),
                style: TextStyle(
                  fontSize: 24.0,
                ),
                keyboardType: TextInputType.number,
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 16.0),
              child: SizedBox(
                width: double.maxFinite,
                child: ElevatedButton(
                  child: Text('Create'),
                  onPressed: () {
                    final String name = _nameController.text;
                    final int? accountNumber =
                        int.tryParse(_accountNumberController.text);
                    final Contact newContact = Contact(0, name, accountNumber!);
                    _save(dependencies.contactDao, newContact, context);
                  },
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  Future<void> _save(
      ContactDao contactDao, Contact newContact, BuildContext context) async {
    await contactDao.save(newContact);
    Navigator.pop(context);
  }
}
