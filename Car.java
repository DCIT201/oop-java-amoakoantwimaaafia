package com.vehiclerentalsystem;
public class Car extends Vehicle implements Rentable {
    private final boolean hasChildSeat;
    public Car(String vehicleId, String model, double baseRentalRate, boolean childSeat, boolean hasChildSeat) {
        super(vehicleId, model, baseRentalRate);

        this.hasChildSeat = hasChildSeat;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
    public boolean hasChildSeat() {
        return hasChildSeat;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(new RentalTransaction(this, customer, days));
            System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned.");
    }
}

