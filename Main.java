import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RentalService service = new RentalService();

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("       VEHICLE RENTAL SYSTEM");
        System.out.println("================================");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> showVehicles();
                case 2 -> rentVehicle();
                case 3 -> returnVehicle();
                case 4 -> showRentals();
                case 5 -> {
                    running = false;
                    System.out.println("Thank you for using Vehicle Rental System!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n1. View all vehicles");
        System.out.println("2. Rent a vehicle");
        System.out.println("3. Return a vehicle");
        System.out.println("4. View rental records");
        System.out.println("5. Exit");
    }

    private static void showVehicles() {
        List<Vehicle> vehicles = service.getVehicles();
        System.out.println("\\nID       Type       Brand        Model        Rent/day       Status");
        System.out.println("---------------------------------------------------------------------");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
        }
    }

    private static void rentVehicle() {
        showVehicles();
        System.out.print("\\nEnter vehicle ID: ");
        String vehicleId = scanner.nextLine().trim();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        int days = readInt("Number of rental days: ");

        try {
            Rental rental = service.rentVehicle(vehicleId, name, phone, days);
            System.out.println("\\nVehicle booked successfully!");
            System.out.println("Rental ID: " + rental.getRentalId());
            System.out.println("Customer: " + rental.getCustomer().getName());
            System.out.println("Vehicle: " + rental.getVehicle().getBrand() + " "
                    + rental.getVehicle().getModel());
            System.out.println("Rental days: " + rental.getDays());
            System.out.printf("Total amount: Rs. %.2f%n", rental.getTotalCost());
            System.out.println("Keep your Rental ID for returning the vehicle.");
        } catch (IllegalArgumentException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    private static void returnVehicle() {
        System.out.print("Enter rental ID: ");
        String rentalId = scanner.nextLine().trim();
        try {
            Rental rental = service.returnVehicle(rentalId);
            System.out.println("Vehicle returned successfully!");
            System.out.println("Vehicle " + rental.getVehicle().getVehicleId()
                    + " is now available.");
        } catch (IllegalArgumentException e) {
            System.out.println("Return failed: " + e.getMessage());
        }
    }

    private static void showRentals() {
        List<Rental> rentals = service.getRentals();
        if (rentals.isEmpty()) {
            System.out.println("No rental records found.");
            return;
        }

        System.out.println("\\nRental ID | Customer | Vehicle | Days | Amount | Date | Status");
        System.out.println("----------------------------------------------------------------");
        for (Rental rental : rentals) {
            System.out.printf("%-9s | %-8s | %-7s | %-4d | Rs.%-7.2f | %-10s | %s%n",
                    rental.getRentalId(),
                    rental.getCustomer().getName(),
                    rental.getVehicle().getVehicleId(),
                    rental.getDays(),
                    rental.getTotalCost(),
                    rental.getRentalDate(),
                    rental.isReturned() ? "Returned" : "Active");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
