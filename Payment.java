package com.vehiclerentalsystem;
import java.util.Objects;

public class Payment {

        private final String transactionId; // Unique identifier for the payment
        private final double amount; // Amount to be paid
        private final String paymentMethod; // Method of payment (e.g., Credit Card, Cash, etc.)
        private final boolean isSuccessful; // Status of the payment

        public Payment(String transactionId, double amount, String paymentMethod, boolean isSuccessful) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.isSuccessful = isSuccessful;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public double getAmount() {
            return amount;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public boolean isSuccessful() {
            return isSuccessful;
        }

        @Override
        public String toString() {
            return "Payment{" +
                    "transactionId='" + transactionId + '\'' +
                    ", amount=" + amount +
                    ", paymentMethod='" + paymentMethod + '\'' +
                    ", isSuccessful=" + isSuccessful +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Payment)) return false;
            Payment payment = (Payment) o;
            return Double.compare(payment.amount, amount) == 0 &&
                    isSuccessful == payment.isSuccessful &&
                    Objects.equals(transactionId, payment.transactionId) &&
                    Objects.equals(paymentMethod, payment.paymentMethod);
        }

        @Override
        public int hashCode() {
            return Objects.hash(transactionId, amount, paymentMethod, isSuccessful);
        }
    }

