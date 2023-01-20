import 'package:byte_bank/components/container.dart';
import 'package:byte_bank/models/name_cubit.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class NameContainer extends BlocContainer {
  const NameContainer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return NameView();
  }
}

class NameView extends StatelessWidget {
  NameView({Key? key}) : super(key: key);

  final _nameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    _nameController.text = context.read<NameCubit>().state;
    return Scaffold(
      appBar: AppBar(title: const Text('Change Name')),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          TextField(
            controller: _nameController,
            decoration: const InputDecoration(labelText: 'Desired Name'),
            style: const TextStyle(fontSize: 24.0),
          ),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: () {
              context.read<NameCubit>().change(_nameController.text);
              Navigator.pop(context);
            },
            child: const Text('Change'),
          ),
        ],
      ),
    );
  }
}
