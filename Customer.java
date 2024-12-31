package com.vehiclerentalsystem;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String customerId;
    private String name;
    private List<RentalTransaction> rentalHistory;
    private String loyaltyPoints;

    public Customer(String customerId, String name, loyaltyPoints loyaltyProgram) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public void addRental(RentalTransaction rental) {
        rentalHistory.add(rental);
    }

    public String getLoyaltyPoints() {
        String loyaltyPoints = new String();
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints  = loyaltyPoints;
    }
}
