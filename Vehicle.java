public abstract class Vehicle {
    private final String vehicleId;
    private final String brand;
    private final String model;
    private final double rentPerDay;
    private boolean available;

    public Vehicle(String vehicleId, String brand, String model, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getVehicleType();

    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    public void displayDetails() {
        System.out.printf("%-8s %-10s %-12s %-10s Rs.%-8.2f %-10s%n",
                vehicleId, getVehicleType(), brand, model, rentPerDay,
                available ? "Available" : "Rented");
    }
}
