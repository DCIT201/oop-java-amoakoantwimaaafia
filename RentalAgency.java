package com.vehiclerentalsystem;
import java.util.ArrayList;
import java.util.List;
public class RentalAgency {
    private List<Vehicle> vehicles;

    public RentalAgency() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public void processRental(Customer customer, Vehicle vehicle, int days) {
        if (vehicle.isAvailableForRental()) {
            vehicle.rent(customer, days);
        } else {
            System.out.println("Vehicle is not available for rental.");
        }
    }

    public void generateReport() {
        System.out.println("Rental Report:");
        System.out.println("--------------------------------------------------");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle Model: " + vehicle.getModel());
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("Rental History:");
            boolean hasRentals = false;

            for (Customer customer : getCustomersWithRentals()) {
                for (RentalTransaction transaction : customer.getRentalHistory()) {
                    if (transaction.getVehicle().equals(vehicle)) {
                        hasRentals = true;
                        System.out.println("  Customer: " + customer.getName() +
                                ", Days Rented: " + transaction.getRentalDays() +
                                ", Total Cost: $" + transaction.getTotalCost());
                    }
                }
            }

            if (!hasRentals) {
                System.out.println("  No rentals for this vehicle.");
            }
            System.out.println("--------------------------------------------------");
        }
    }

    private List<Customer> getCustomersWithRentals() {
        List<Customer> customersWithRentals = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            for (RentalTransaction transaction : vehicle.getRentalHistory()) {
                if (!customersWithRentals.contains(transaction.getCustomer())) {
                    customersWithRentals.add(transaction.getCustomer());
                }
            }
        }
        return customersWithRentals;
    }
}
