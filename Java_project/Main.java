package com.example.airportmanagementsystem;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class represents the entry point of the Airport Management System.
 * It provides options for both administrators and passengers to interact with the system.
 */
public class Main
{
    static Scanner s = new Scanner(System.in);
    static File airplaneFile = new File("airplane.txt");
    static File passengerFile = new File("passengers.txt");
    static File bookAirplaneSeatFile = new File("bookAirplaneSeat.txt");
    static ObjectOutputStream oos = null;
    static ObjectInputStream oisAirplane = null;
    static ObjectInputStream oisPassenger = null;
    static ArrayList<Airplane> airplanesArray = new ArrayList<>();
    static ArrayList<Passenger> passengersArray = new ArrayList<>();

    /**
     * The main method is the entry point of the Airport Management System application.
     * It displays a menu for the user to select an option: Admin, Passenger, or Exit.
     * Based on the user's choice, it further displays sub-menus and performs corresponding actions.
     *
     * @param args the command line arguments
     * @throws Exception if an error occurs during the execution of the program
     */
    public static void main(String[] args) throws Exception
    {

        int choice = 0;
        try
        {
            do {
                System.out.println("------------------------Welcome to the Airport Management System--------------------------------");
                System.out.println("Please select an option from the menu below");
                System.out.println("1. Admin");
                System.out.println("2. Passenger");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = s.nextInt();

                switch (choice) {
                    case 1:

                        int choice1 = -1;
                        do {
                            System.out.println("-----Welcome Admin! Please select an option from the menu below-----");
                            System.out.println("1. Add Airplane");
                            System.out.println("2. Search Airplane");
                            System.out.println("3. Print All Airplanes");
                            System.out.println("4.Update Airplane Information");
                            System.out.println("5. Delete Airplane");
                            System.out.println("6. Exit");
                            System.out.println("Enter your choice: ");
                            choice1 = s.nextInt();
                            switch (choice1) {
                                case 1:
                                    Airplane.addAirplne(oos, airplanesArray, airplaneFile, s);
                                    break;
                                case 2:
                                    System.out.println("Enter the Airplane ID: ");
                                    String airplaneID = s.next();
                                    Airplane.searchAirplane(airplaneID, airplanesArray, airplaneFile, oisAirplane, oos);
                                    break;
                                case 3:
                                    Airplane.printAllAirplanes(airplanesArray, airplaneFile, oisAirplane);
                                    break;
                                case 4:
                                    System.out.println("Enter the Airplane ID: ");
                                    String airplaneIDToUpdate = s.next();
                                    Airplane.updateAirplane(airplaneIDToUpdate, airplanesArray, airplaneFile, s, oos, oisAirplane);
                                    break;
                                case 5:
                                    System.out.println("Enter the Airplane ID: ");
                                    String airplaneIDToDelete = s.next();
                                    Airplane.deleteAirplane(airplaneIDToDelete, airplanesArray, airplaneFile, oisAirplane, oos);
                                    break;
                                case 6:
                                    System.out.println("Exiting...");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        }while (choice1 != 6);
                        break;

                        case 2:
                            int x = -1;
                            do {
                            System.out.println("-------------Welcome Passenger! Please select an option from the menu below----------------");
                            System.out.println("1. Create your account");
                            System.out.println("2. Log in to your account");
                            System.out.println("3. Exit");
                            System.out.print("Enter your choice: ");
                            x = s.nextInt();
                            switch (x) {
                                case 1:
                                        System.out.println("--------------------Create your Account--------------------");
                                        System.out.println();
                                        Passenger.addPassengerAccount(oos, passengersArray, passengerFile);
                                        break;
                                    case 2:
                                        System.out.println("--------------------Log in to your Account---------------------");
                                        System.out.println();
                                        boolean loginSucess = false;
                                        System.out.println("Enter your Email: ");
                                        String passengerEmail = s.next();
                                        System.out.println("Enter your Password: ");
                                        String passengerPassword = s.next();
                                        loginSucess = Passenger.loginPassenger(passengerEmail, passengerPassword, passengersArray, passengerFile, oisPassenger);
                                        if (loginSucess)
                                        {
                                            int y = -1;
                                            do {
                                            System.out.println("--------------Welcome Passenger! Please select an option from the menu below-----------------");
                                            System.out.println("1. Search Airplane");
                                            System.out.println("2. Display all Airplanes Schedule");
                                            System.out.println("3. Book a Flight seat");
                                            System.out.println("4. Cancel a Flight seat");
                                            System.out.println("5. Display your profile");
                                            System.out.println("6. Update your profile");
                                            System.out.println("7. Exit");
                                            System.out.print("Enter your choice: ");
                                            y = s.nextInt();
                                            switch (y) {
                                                case 1:
                                                    System.out.println("------------------------------------------------------------------------------------");
                                                    System.out.print("Enter the Airplane ID: ");
                                                    String airplaneID = s.next();
                                                    Airplane.searchAirplane(airplaneID, airplanesArray, airplaneFile, oisAirplane, oos);
                                                    break;
                                                case 2:
                                                    System.out.println("------------------------------------------------------------------------------------");
                                                    Airplane.printAllAirplanes(airplanesArray, airplaneFile, oisAirplane);
                                                    break;
                                                case 3:
                                                    System.out.print("Enter the Airplane ID to book/cancel a seat: ");
                                                    String airplaneIDForBooking = s.next();
                                                    int rowForBooking = 0, colForBooking = 0;
                                                    do {
                                                        System.out.println("------------------------------------------------------------------------------------");
                                                    System.out.println("1. Book a seat");
                                                    System.out.println("2. Cancel a seat");
                                                    System.out.println("3. Exit");
                                                    System.out.print("Enter your choice: ");
                                                    int seatOption = s.nextInt();

                                                    switch (seatOption) {
                                                        case 1:
                                                            airplanesArray.stream()
                                                                    .filter(plane -> plane.getAirplaneId().equals(airplaneIDForBooking))
                                                                    .findFirst()
                                                                    .ifPresent(plane -> plane.getSeatBookings().bookSeat(rowForBooking, colForBooking));
                                                            break;
                                                        case 2:
                                                            airplanesArray.stream()
                                                                    .filter(plane -> plane.getAirplaneId().equals(airplaneIDForBooking))
                                                                    .findFirst()
                                                                    .ifPresent(plane -> plane.getSeatBookings().cancelSeat( rowForBooking, colForBooking));
                                                            break;
                                                        default:
                                                            System.out.println("Invalid choice");
                                                            break;
                                                    }
                                                    } while (rowForBooking != 3);
                                                    break;
                                                case 4:
                                                    Passenger.displayPassengerProfile(passengerEmail, passengersArray, passengerFile, oisPassenger);
                                                    break;
                                                case 5:
                                                    Passenger.updatePassengerProfile(passengerEmail, passengersArray, passengerFile, s, oos, oisPassenger);
                                                    break;
                                            }
                                        } while (y != 6);
                                        } else {
                                            System.out.println("Login Failed");
                                        }
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (x != 3);
                }
            } while (choice != 3);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input.");
            s.next();

        } catch(Exception e){
                System.err.println("Exception: " + e);
        }
    }
}




