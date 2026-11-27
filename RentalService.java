import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Rental> rentals = new ArrayList<>();
    private int nextRentalNumber = 1;

    public RentalService() {
        // Sample vehicles; add more using addVehicle().
        vehicles.add(new Car("C101", "Toyota", "Glanza", 1800, 5));
        vehicles.add(new Car("C102", "Hyundai", "i20", 1600, 5));
        vehicles.add(new Bike("B101", "Honda", "Activa", 500, true));
        vehicles.add(new Bike("B102", "Royal Enfield", "Classic", 900, true));
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Rental rentVehicle(String vehicleId, String name, String phone, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than zero.");
        }

        Vehicle selected = findVehicle(vehicleId);
        if (selected == null) {
            throw new IllegalArgumentException("Vehicle ID not found.");
        }
        if (!selected.isAvailable()) {
            throw new IllegalArgumentException("This vehicle is already rented.");
        }

        String customerId = "U" + (rentals.size() + 1);
        Customer customer = new Customer(customerId, name, phone);
        String rentalId = "R" + nextRentalNumber++;
        Rental rental = new Rental(rentalId, selected, customer, days);

        selected.setAvailable(false);
        rentals.add(rental);
        return rental;
    }

    public Rental returnVehicle(String rentalId) {
        for (Rental rental : rentals) {
            if (rental.getRentalId().equalsIgnoreCase(rentalId)) {
                if (rental.isReturned()) {
                    throw new IllegalArgumentException("This rental has already been returned.");
                }
                rental.markReturned();
                rental.getVehicle().setAvailable(true);
                return rental;
            }
        }
        throw new IllegalArgumentException("Rental ID not found.");
    }

    private Vehicle findVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}
