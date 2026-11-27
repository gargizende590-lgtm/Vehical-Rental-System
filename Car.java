public class Car extends Vehicle {
    private final int seatingCapacity;

    public Car(String id, String brand, String model, double rentPerDay, int seatingCapacity) {
        super(id, brand, model, rentPerDay);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() { return seatingCapacity; }

    @Override
    public String getVehicleType() { return "Car"; }

    @Override
    public double calculateRent(int days) {
        // Cars include a fixed cleaning fee in the rental total.
        return super.calculateRent(days) + 100;
    }
}
