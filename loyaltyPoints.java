package com.vehiclerentalsystem;

public interface loyaltyPoints {
    void addPoints(Customer customer, int points);
    int getPoints(Customer customer);
}
