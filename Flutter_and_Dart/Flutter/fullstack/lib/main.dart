import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
  home: Home(),
));




class Home extends StatelessWidget{
  const Home({super.key});

  @override
Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: Text("Fullstack Mobile Development"),
          centerTitle: true,
          backgroundColor: Colors.purple
      ),
      body: Container(
        padding: EdgeInsets.symmetric(horizontal: 30, vertical: 10),
        margin: EdgeInsets.all(30),
        color: Colors.grey[400],
        child: Text('Hello'),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        backgroundColor: Colors.blue,
        child: Text("Click!",
          style: TextStyle(
            fontSize: 16.0,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
    );
}
}

