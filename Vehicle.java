package com.vehiclerentalsystem;

public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Abstract method for rental cost (specific for each vehicle type)
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    public void rent(Customer customer, int days) {
    }

    public RentalTransaction[] getRentalHistory() {
        return new RentalTransaction[0];
    }
}
