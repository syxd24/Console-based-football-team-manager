# Console-based Football Team Manager

A simple console-based Java application for managing football players and practicing core Java 8 concepts in a practical way.

## Overview

This project was built as a small hands-on Java application to manage a football team in the console. It focuses on clean object-oriented structure and Java 8 features such as lambdas, functional interfaces, and the Stream API.

The application allows you to create players, store them in a team, and perform operations such as filtering and viewing player data.

## Features

- Add players to a team
- View all players
- Filter players using custom conditions
- Practice Java 8 lambda expressions
- Use a functional interface for flexible filtering
- Process collections with Stream API

## Technologies Used

- Java
- Maven
- Java 8 Stream API
- Lambda expressions
- Functional interfaces

## Project Structure

- `Player`  
  Represents a football player with fields such as id, name, age, position, salary, and jersey number.

- `PlayerFilter`  
  A functional interface used to define custom filtering rules for players.

- `TeamService`  
  Contains the main business logic for managing and filtering players.

- `Main`  
  Entry point of the application where sample players are created and tested.

## Learning Goals

This project was created to practice:

- Creating classes and objects in Java
- Encapsulation with fields, constructors, getters, and setters
- Functional interfaces
- Lambda expressions
- Stream API
- Filtering collections in a clean and reusable way

## Example Use Cases

The application can be extended to support operations such as:

- Filtering players by position
- Filtering players by age
- Filtering players by salary
- Calculating total team salary
- Searching players by id or jersey number
- Displaying unique positions in the team

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA or any Java IDE
3. Build the project using Maven
4. Run the `Main` class

## Future Improvements

Possible next improvements for this project:

- Menu-driven console interaction with `Scanner`
- Search player by id
- Search player by jersey number
- Calculate total salary of the squad
- Show player names in uppercase
- Display unique positions
- Input validation
- Better console formatting

## Purpose

This project is mainly intended as a learning project for improving Java fundamentals and understanding how Java 8 features can be used in a real mini-application.

## Author

Syed
