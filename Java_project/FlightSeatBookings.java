package com.example.airportmanagementsystem;

public class FlightSeatBookings {

    
    public void bookSeat(int row, int col) {
        if (isValidSeat(row, col)) {
            bookSeat(row, col);
            System.out.println("Seat booked successfully! Row: " + row + ", Col: " + col);
        } else {
            System.out.println("Invalid seat coordinates! Row: " + row + ", Col: " + col);
        }
    }
    public void cancelSeat(int row, int col) {
        if (isValidSeat(row, col)) {
            cancelSeat(row, col);
            System.out.println("Seat cancelled successfully! Row: " + row + ", Col: " + col);
        } else {
            System.out.println("Invalid seat coordinates! Row: " + row + ", Col: " + col);
        }
    }

    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 6;
    }

}
