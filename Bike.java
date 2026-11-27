public class Bike extends Vehicle {
    private final boolean hasHelmet;

    public Bike(String id, String brand, String model, double rentPerDay, boolean hasHelmet) {
        super(id, brand, model, rentPerDay);
        this.hasHelmet = hasHelmet;
    }

    public boolean hasHelmet() { return hasHelmet; }

    @Override
    public String getVehicleType() { return "Bike"; }

    @Override
    public double calculateRent(int days) {
        // Bikes receive a small discount for rentals of 5 days or more.
        double total = super.calculateRent(days);
        return days >= 5 ? total * 0.95 : total;
    }
}
