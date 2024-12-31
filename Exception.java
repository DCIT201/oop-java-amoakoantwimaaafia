package com.vehiclerentalsystem;

public class Exception {
    public Exception(String message) {

    }

    public class VehicleNotAvailableException extends Exception {
        public VehicleNotAvailableException(String message) {
            super(message);
        }
    }

    public class InvalidRentalPeriodException extends Exception {
        public InvalidRentalPeriodException(String message) {
            super(message);
        }
    }
}
