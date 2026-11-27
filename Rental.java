import java.time.LocalDate;

public class Rental {
    private final String rentalId;
    private final Vehicle vehicle;
    private final Customer customer;
    private final int days;
    private final double totalCost;
    private final LocalDate rentalDate;
    private boolean returned;

    public Rental(String rentalId, Vehicle vehicle, Customer customer, int days) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.totalCost = vehicle.calculateRent(days);
        this.rentalDate = LocalDate.now();
        this.returned = false;
    }

    public String getRentalId() { return rentalId; }
    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getDays() { return days; }
    public double getTotalCost() { return totalCost; }
    public LocalDate getRentalDate() { return rentalDate; }
    public boolean isReturned() { return returned; }
    public void markReturned() { returned = true; }
}
