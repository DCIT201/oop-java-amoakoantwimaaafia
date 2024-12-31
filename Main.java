package com.vehiclerentalsystem;

public class Main {
    public static <RentalException extends Throwable> void main(String[] args) throws RentalException {

        RentalAgency agency = new RentalAgency();


        loyaltyPoints loyaltyProgram = new loyaltyPoints() {
            @Override
            public void addPoints(Customer customer, int points) {

            }

            @Override
            public int getPoints(Customer customer) {
                return 0;
            }
        };


        Customer customer1 = new Customer("x001", "John Owusu", loyaltyProgram);
        Customer customer2 = new Customer("x002", "Jane Darko", loyaltyProgram);


        Vehicle car = new Car("V001", "Toyota Camry", 50.0, true, false);
        Vehicle motorcycle = new Motorcycle("V002", "Harley Davidson", 30.0, false, true);
        Vehicle truck = new Truck("V003", "Ford F-150", 80.0, 1000.0, 5000.0);


        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        System.out.println("Available Vehicles:");
        for (Vehicle v : agency.getAvailableVehicles()) {
            System.out.println(v);
        }


        {
            car.rent(customer1, 3);
            System.out.println("Loyalty Points for " + customer1.getName() + ": " + customer1.getLoyaltyPoints());


            RentalTransaction transaction = new RentalTransaction(car, customer1, 3);
            double rentalCost = transaction.getVehicle().calculateRentalCost(3);
            transaction.processPayment("TXN001", rentalCost, "Credit Card");
            System.out.println("Payment processed: " + transaction.getPayment());
        }


        {
            motorcycle.rent(customer2, 2);
            System.out.println("Loyalty Points for " + customer2.getName() + ": " + customer2.getLoyaltyPoints());


            RentalTransaction transaction = new RentalTransaction(motorcycle, customer2, 2);
            double rentalCost = transaction.getVehicle().calculateRentalCost(2);
            transaction.processPayment("TXN002", rentalCost, "Cash");
            System.out.println("Payment processed: " + transaction.getPayment());
        }


        truck.rent(customer1, 5);
        RentalTransaction transaction = new RentalTransaction(truck, customer1, 5);
        double rentalCost = transaction.getVehicle().calculateRentalCost(5);
        transaction.processPayment("TXN003", rentalCost, "Debit Card");
        System.out.println("Payment processed: " + transaction.getPayment());


        ((Car) car).returnVehicle();
        System.out.println("Car returned.");


        System.out.println("\nGenerating Rental Report:");
        agency.generateReport();
    }
}
