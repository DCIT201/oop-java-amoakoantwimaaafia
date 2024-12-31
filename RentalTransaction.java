package com.vehiclerentalsystem;

public class RentalTransaction {
    private final Vehicle vehicle;
    private final Customer customer;
    private final  int rentalDays;
    private final  double totalCost;

    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDays) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateRentalCost(rentalDays);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getPayment() {
        return null;
    }

    public void processPayment(String txn001, double rentalCost, String creditCard) {
    }
}
