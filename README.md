# Vehicle Rental System (Java)

A console-based vehicle rental application built with Java and Object-Oriented Programming.

## Features
- View cars and bikes with daily rental rates and availability.
- Rent an available vehicle and generate a rental ID.
- Calculate rental cost based on the vehicle type and number of days.
- Return a vehicle using its rental ID.
- View rental records and their status.
- Validate invalid IDs, unavailable vehicles, and invalid rental durations.

## OOP concepts demonstrated
- **Encapsulation:** fields are private and accessed through methods.
- **Abstraction:** `Vehicle` is an abstract class.
- **Inheritance:** `Car` and `Bike` extend `Vehicle`.
- **Polymorphism:** both subclasses override `getVehicleType()` and `calculateRent()`.

## Requirements
- Java 17 or later (the menu uses modern switch syntax).
- Any Java IDE, such as IntelliJ IDEA, Eclipse, or VS Code with the Java extensions.

## Run using terminal
From the project folder:

```bash
javac src/*.java
java -cp src Main
```

## Notes
- The project stores data in memory. Rental records reset when the program is closed.
- Sample vehicles are added when the program starts.
- This is a beginner-friendly academic project, not a production booking platform.
