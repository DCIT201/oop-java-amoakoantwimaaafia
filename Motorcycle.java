package com.vehiclerentalsystem;
public class Motorcycle extends Vehicle implements Rentable {
    private final boolean hasSideCar;
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean sideCar, boolean hasSideCar) {
        super(vehicleId, model, baseRentalRate);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.9; // 10% discount for motorcycles
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
    public boolean hasSideCar(){
        return hasSideCar;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(new RentalTransaction(this, customer, days));
            System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Motorcycle is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle returned.");
    }
}


