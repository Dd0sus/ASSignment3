# Grocery Store Staff Management

Week 6 Assignment. Refactored previous project to implement Interfaces, Abstract Classes, and Exception Handling.

## Features

* **Abstract Classes**: `Staff` is abstract. Child classes (`Manager`, `Cashier`) implement the abstract `work()` method.
* **Interfaces**: Implemented `Menu` interface to separate UI logic.
* **Exception Handling**: Setters throw `IllegalArgumentException` for invalid data. Menu handles input errors via `try-catch`.
* **Clean Architecture**: Application logic moved to `MenuManager`. `Main.java` is under 10 lines.

## Project Structure

* `src/model`: Data classes (`Staff`, `Manager`, `Cashier`)
* `src/menu`: Interface and implementation (`Menu`, `MenuManager`)
* `src/exception`: Custom exception classes
* `src/Main.java`: Application entry point

## Usage

1.  Clone repository.
2.  Open in IntelliJ.
3.  Run `Main.java`.
