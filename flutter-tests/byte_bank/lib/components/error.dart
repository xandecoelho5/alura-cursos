import 'package:flutter/material.dart';

class ErrorView extends StatelessWidget {
  const ErrorView(this.message, {Key? key}) : super(key: key);

  final String message;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Error')),
      body: Text(message),
    );
  }
}
