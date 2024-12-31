package com.vehiclerentalsystem;
public class Truck extends Vehicle implements Rentable {
    public final double loadCapacity;
    public Truck(String vehicleId, String model, double rentalRate, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.2; // 20% surcharge for trucks
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    public double LoadCapacity() {
        return 0;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(new RentalTransaction(this, customer, days));
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned.");
    }
}
