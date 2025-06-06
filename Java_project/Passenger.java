package com.example.airportmanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger implements Serializable {
    @Serial
    private static final long serialVersionUID = 6433858223774886977L;
    static Scanner s = new Scanner(System.in);
    private String passengerName;
    private long passengerPassportNumber;
    private long passengerContactNumber;
    private String passengerAddress;
    private String passengerEmail;
    private String passengerPassword;

    public Passenger(String passengerName, long passengerPassportNumber, long passengerContactNumber, String passengerAddress, String passengerEmail, String passengerPassword) {
        this.passengerName = passengerName;
        this.passengerPassportNumber = passengerPassportNumber;
        this.passengerContactNumber = passengerContactNumber;
        this.passengerAddress = passengerAddress;
        this.passengerEmail = passengerEmail;
        this.passengerPassword = passengerPassword;
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public long getPassengerPassportNumber() {
        return passengerPassportNumber;
    }

    public void setPassengerPassportNumber(long passengerPassportNumber) {
        this.passengerPassportNumber = passengerPassportNumber;
    }

    public long getPassengerContactNumber() {
        return passengerContactNumber;
    }

    public void setPassengerContactNumber(long passengerContactNumber) {
        this.passengerContactNumber = passengerContactNumber;
    }

    public String getPassengerAddress() {
        return passengerAddress;
    }

    public void setPassengerAddress(String passengerAddress) {
        this.passengerAddress = passengerAddress;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPassword() {
        return passengerPassword;
    }

    public void setPassengerPassword(String passengerPassword) {
        this.passengerPassword = passengerPassword;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ADD Passenger Accounts
    public static void addPassengerAccount(ObjectOutputStream oos, ArrayList<Passenger> passengers, File passengerFile) throws Exception {
        try {
            int passengerId = passengers.size() + 1;
            System.out.println("Full Name: ");
            String passengerName = s.nextLine();
            System.out.println("Passport Number: ");
            long passengerPassportNumber = s.nextLong();
            System.out.println("Contact Number: ");
            long passengerContactNumber = s.nextLong();
            s.nextLine();
            System.out.println("Address: ");
            String passengerAddress = s.nextLine();
            System.out.println("Enter your Email: ");
            String passengerEmail = s.nextLine();
            System.out.println("Enter new account Password: ");
            String passengerPassword = s.nextLine();
            passengers.add(new Passenger(passengerName, passengerPassportNumber, passengerContactNumber, passengerAddress, passengerEmail, passengerPassword));
            oos = new ObjectOutputStream(new FileOutputStream(passengerFile, true));
            oos.writeObject(passengers);
            oos.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice");
            s.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
// LOGIN Passenger Accounts
    public static boolean loginPassenger(String passengerEmail, String passengerPassword, ArrayList<Passenger> passengers, File passengerFile, ObjectInputStream oisPassenger) throws Exception {
        boolean flag = false;
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerEmail().equals(passengerEmail) && passenger.getPassengerPassword().equals(passengerPassword)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------
// Display Passenger Accounts
    public static void displayPassengerProfile(String passengerEmail, ArrayList<Passenger> passengers, File passengerFile, ObjectInputStream oisPassenger) throws Exception {
        oisPassenger = new ObjectInputStream(new FileInputStream(passengerFile));
        passengers = (ArrayList<Passenger>) oisPassenger.readObject();
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerEmail().equals(passengerEmail)) {
                System.out.println("Passenger Name: " + passenger.getPassengerName());
                System.out.println("Passenger Passport Number: " + passenger.getPassengerPassportNumber());
                System.out.println("Passenger Contact Number: " + passenger.getPassengerContactNumber());
                System.out.println("Passenger Address: " + passenger.getPassengerAddress());
                System.out.println("Passenger Email: " + passenger.getPassengerEmail());
                System.out.println("Passenger Password: " + passenger.getPassengerPassword());
                break;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------
// Update Passenger Accounts
    public static void updatePassengerProfile(String passengerEmail, ArrayList<Passenger> passengers, File passengerFile, Scanner s, ObjectOutputStream oos ,ObjectInputStream oisPassenger) throws Exception {
        oisPassenger = new ObjectInputStream(new FileInputStream(passengerFile));
        passengers = (ArrayList<Passenger>) oisPassenger.readObject();
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerEmail().equals(passengerEmail)) {
                System.out.println("Enter the Passenger Name: ");
                String passengerName = s.next();
                System.out.println("Enter the Passenger Passport Number: ");
                long passengerPassportNumber = s.nextLong();
                System.out.println("Enter the Passenger Contact Number: ");
                long passengerContactNumber = s.nextInt();
                System.out.println("Enter the Passenger Address: ");
                String passengerAddress = s.nextLine();
                System.out.println("Enter the Passenger Email: ");
                String passengerEmail1 = s.next();
                System.out.println("Enter the Passenger Password: ");
                String passengerPassword = s.next();
                passenger.setPassengerName(passengerName);
                passenger.setPassengerPassportNumber(passengerPassportNumber);
                passenger.setPassengerContactNumber(passengerContactNumber);
                passenger.setPassengerAddress(passengerAddress);
                passenger.setPassengerEmail(passengerEmail1);
                passenger.setPassengerPassword(passengerPassword);
                oos = new ObjectOutputStream(new FileOutputStream(passengerFile, true));
                oos.writeObject(passengers);
                oos.close();
                break;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    // Delete Passenger Accounts
    public static void deletePassengerProfile(String passengerEmail, ArrayList<Passenger> passengers, File passengerFile, ObjectInputStream oisPassenger, ObjectOutputStream oos) throws Exception {
        oisPassenger = new ObjectInputStream(new FileInputStream(passengerFile));
        passengers = (ArrayList<Passenger>) oisPassenger.readObject();
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerEmail().equals(passengerEmail)) {
                passengers.remove(passenger);
                oos = new ObjectOutputStream(new FileOutputStream(passengerFile, true));
                oos.writeObject(passengers);
                oos.close();
                break;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    // Search Passenger Accounts
    public static void searchPassengerProfile(String passengerEmail, ArrayList<Passenger> passengers, File passengerFile, ObjectInputStream oisPassenger) throws Exception {
        oisPassenger = new ObjectInputStream(new FileInputStream(passengerFile));
        passengers = (ArrayList<Passenger>) oisPassenger.readObject();
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerEmail().equals(passengerEmail)) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Passenger Name: " + passenger.getPassengerName());
                System.out.println("Passenger Passport Number: " + passenger.getPassengerPassportNumber());
                System.out.println("Passenger Contact Number: " + passenger.getPassengerContactNumber());
                System.out.println("Passenger Address: " + passenger.getPassengerAddress());
                System.out.println("Passenger Email: " + passenger.getPassengerEmail());
                System.out.println("Passenger Password: " + passenger.getPassengerPassword());
                break;
            }
        }
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------
    // Print All Passenger Accounts
    public static void printAllPassengers(ArrayList<Passenger> passengers, File passengerFile, ObjectInputStream oisPassenger) throws Exception {
        oisPassenger = new ObjectInputStream(new FileInputStream(passengerFile));
        passengers = (ArrayList<Passenger>) oisPassenger.readObject();
        for (Passenger passenger : passengers) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
           System.out.println("Passenger Name: " + passenger.getPassengerName());
            System.out.println("Passenger Passport Number: " + passenger.getPassengerPassportNumber());
            System.out.println("Passenger Contact Number: " + passenger.getPassengerContactNumber());
            System.out.println("Passenger Address: " + passenger.getPassengerAddress());
            System.out.println("Passenger Email: " + passenger.getPassengerEmail());
            System.out.println("Passenger Password: " + passenger.getPassengerPassword());
        }
    }
}