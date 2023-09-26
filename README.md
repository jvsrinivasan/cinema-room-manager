# Cinema Room Manager

## Overview
The Cinema Room Manager is a Java-based program that simulates a cinema's ticket booking operations. This system allows users to view the seating layout, purchase tickets, display statistics, and manage bookings. It is a command-line application designed for educational purposes and can serve as a foundation for more complex cinema management systems.

## Table of Contents
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Features](#features)
- [Code Structure](#code-structure)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Getting Started
To run the Cinema Room Manager, follow these steps:

1. Ensure you have Java installed on your system.
2. Clone this repository to your local machine.
3. Compile the Java code using your preferred IDE or the command line.
4. Run the program by executing the `Cinema.java` file.

## Usage
- Upon running the program, you will be prompted to enter the number of rows and seats in each row in the cinema.
- You can then choose from the following options:
  1. Show the seats: Display the current seating layout.
  2. Buy a ticket: Purchase a ticket by specifying a row and seat number.
  3. Statistics: View statistics about ticket sales, revenue, and occupancy.
  0. Exit: Terminate the program.

## Features
- View the cinema's seating layout.
- Purchase tickets and calculate ticket prices based on the pricing strategy.
- Display statistics, including the number of purchased tickets, revenue, and occupancy.
- Easy-to-understand command-line interface.

## Code Structure
- The code is organized into several methods, each serving a specific purpose.
- Key methods include `generateSeatLayout`, `displaySeatLayout`, `buyTicket`, `getStatistics`, `calculateTicketPrice`, and `totalIncome`.
- The main method orchestrates user interactions and menu choices.

## Dependencies
The Cinema Ticket Booking System has no external dependencies. It relies solely on Java standard libraries.

## Contributing
Contributions to this project are welcome! If you have ideas for improvements, bug fixes, or new features, please create a pull request. You can also report issues or request features through the GitHub issue tracker.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- The project was created as an educational exercise as part of Hyperskill's Intro to Java Track and serves as a foundation for understanding basic Java programming concepts.
