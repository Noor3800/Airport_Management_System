package com.example.airportmanagementsystem;
import java.util.*;
import java.io.*;
public class Airplane implements Serializable{
    private static final long serialVersionUID = 6433858223774886977L;
    private String airplaneId;
    private int seatCapacity ;
    private String airplaneName;
    private String departureDate;
    private String departureTime;
    private String source;
    private String destination;
    private FlightSeatBookings seatBookings;


    public Airplane(String airplaneId , int seatCapacity, String airplaneName , String departureDate , String departureTime , String source , String destination) {
        this.airplaneId = airplaneId;
        this.seatCapacity = seatCapacity;
        this.airplaneName = airplaneName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.source = source;
        this.destination = destination;
        this.seatBookings = new FlightSeatBookings();
    }

    public String getAirplaneName() { return airplaneName; }

    public void setAirplaneName(String airplaneName) { this.airplaneName = airplaneName; }
    public String getAirplaneId() { return airplaneId; }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public String getDepartureTime() { return departureTime; }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }


    public int getSeatCapacity() { return seatCapacity; }

   public void setSeatCapacity(int seatCapacity){ this.seatCapacity = seatCapacity; }

    public String getSource() { return source; }

    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public void setAirplaneId(String airplaneId) { this.airplaneId = airplaneId; }


    //----------------------------------------------------------------------------------------------------------------
// ADD AIRPLANE
    public  static void addAirplne(ObjectOutputStream oos , ArrayList <Airplane> airplane , File airplaneFile , Scanner s)
    {

            try
            {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.print("Enter the Airplane ID: ");
                String airplaneId = s.next();
                System.out.print("Enter the Airplane Name: ");
                String airplaneName = s.next();
                System.out.print("Enter the Seat Capacity: ");
                int seatCapacity = s.nextInt();
                System.out.print("Enter the Departure Date: ");
                String departureDate = s.next();
                System.out.print("Enter the Departure Time: ");
                String departureTime = s.next();
                System.out.print("Enter the Source: ");
                String source = s.next();
                System.out.print("Enter the Destination: ");
                String destination = s.next();
                airplane.add(new Airplane(airplaneId,seatCapacity,airplaneName,departureDate,departureTime,source,destination));
                oos = new ObjectOutputStream(new FileOutputStream(airplaneFile));
                oos.writeObject(airplane);
                oos.close();
                System.out.println();
                System.out.println("Airplane added successfully!");
            }
            catch (InputMismatchException e)
            {
                System.out.println();
                System.out.println("Invalid choice");
                s.next();
            }
            catch (Exception e)
            {
                System.err.println("Exception: " + e);
            }
    }

//----------------------------------------------------------------------------------------------------------------
// SEARCH AIRPLANE
    public static void searchAirplane(String airplaneID , ArrayList<Airplane> airplanes , File airplaneFile , ObjectInputStream oisAirplane, ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        oisAirplane = new ObjectInputStream(new FileInputStream(airplaneFile));
        oisAirplane.readObject();

        if (airplaneFile.isFile()) {
            boolean found = false;

            for (Airplane airplane : airplanes) {
                if (airplane.getAirplaneId().equals(airplaneID)) {
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Airplane found!");
                    System.out.println();
                    System.out.println("Airplane ID: " + airplane.getAirplaneId());
                    System.out.println("Airplane Name: " + airplane.getAirplaneName());
                    System.out.println("Seat Capacity: " + airplane.getSeatCapacity());
                    System.out.println("Departure Date: " + airplane.getDepartureDate());
                    System.out.println("Departure Time: " + airplane.getDepartureTime());
                    System.out.println("Source: " + airplane.getSource());
                    System.out.println("Destination: " + airplane.getDestination());
                    System.out.println();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.println("Airplane not found!");
                System.out.println();
            }
        }
        else{
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("File not exist!");
            System.out.println();
        }
    }

// ---------------------------------------------------------------------------------------------------------------------------------------------------------
// PRINT AIRPLANE
    public static void printAllAirplanes(ArrayList<Airplane> airplanes , File airplaneFile , ObjectInputStream oisAirplane) throws IOException, ClassNotFoundException
    {        
        oisAirplane = new ObjectInputStream(new FileInputStream(airplaneFile));
        airplanes = (ArrayList<Airplane>) oisAirplane.readObject();
        int i = 0;
        for (Airplane airplane : airplanes) 
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Airplane " + ++i + ": ");
            System.out.println("Airplane ID: " + airplane.getAirplaneId());
            System.out.println("Airplane Name: " + airplane.getAirplaneName());
            System.out.println("Seat Capacity: " + airplane.getSeatCapacity());
            System.out.println("Departure Date: " + airplane.getDepartureDate());
            System.out.println("Departure Time: " + airplane.getDepartureTime());
            System.out.println("Source: " + airplane.getSource());
            System.out.println("Destination: " + airplane.getDestination());
            System.out.println();
        }
        oisAirplane.close();
    }
//----------------------------------------------------------------------------------------------------------------
// UPDATE AIRPLANE
    public static void updateAirplane(String airplaneIDToUpdate, ArrayList<Airplane> airplanes, File airplaneFile, Scanner s ,
                                      ObjectOutputStream oos , ObjectInputStream oisAirplane ) throws IOException, ClassNotFoundException {
        oisAirplane = new ObjectInputStream(new FileInputStream(airplaneFile));
        airplanes = (ArrayList<Airplane>)oisAirplane.readObject();
       
        if (airplaneFile.isFile()) {
            boolean found = false;
            for (Airplane airplane : airplanes) 
            {
                if (airplane.getAirplaneId().equals(airplaneIDToUpdate)) {
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Airplane found!");
                    System.out.println();
                    System.out.println("Airplane ID: " + airplane.getAirplaneId());
                    System.out.println("Airplane Name: " + airplane.getAirplaneName());
                    System.out.println("Seat Capacity: " + airplane.getSeatCapacity());
                    System.out.println("Departure Date: " + airplane.getDepartureDate());
                    System.out.println("Departure Time: " + airplane.getDepartureTime());
                    System.out.println("Source: " + airplane.getSource());
                    System.out.println("Destination: " + airplane.getDestination());
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println("Enter the new Airplane Name: ");
                    String airplaneName = s.next();
                    System.out.println("Enter the new Seat Capacity: ");
                    int seatCapacity = s.nextInt();
                    System.out.println("Enter the new Departure Date: ");
                    String departureDate = s.next();
                    System.out.println("Enter the new Departure Time: ");
                    String departureTime = s.next();
                    System.out.println("Enter the new Source: ");
                    String source = s.next();
                    System.out.println("Enter the new Destination: ");
                    String destination = s.next();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    airplane.setAirplaneName(airplaneName);
                    airplane.setSeatCapacity(seatCapacity);
                    airplane.setDepartureDate(departureDate);
                    airplane.setDepartureTime(departureTime);
                    airplane.setSource(source);
                    airplane.setDestination(destination);
                    airplanes.add(new Airplane(airplaneIDToUpdate,seatCapacity,airplaneName,departureDate,departureTime,source,destination));
                    System.out.println("Airplane updated successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("Airplane not found!");
                System.out.println();
            }
            oos = new ObjectOutputStream(new FileOutputStream(airplaneFile));
                oos.writeObject(airplanes);
                oos.close();
        } else {
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("File not exist!");
            System.out.println();
        }
    }

    //---------------------------------------------------------------------------------------------------------------
//Delete Airplane
public static void deleteAirplane(String airplaneIDToDelete, ArrayList<Airplane> airplanes, File airplaneFile , ObjectInputStream oisAirplane , ObjectOutputStream oos ) throws IOException, ClassNotFoundException {
        oisAirplane = new ObjectInputStream(new FileInputStream(airplaneFile));
        airplanes = (ArrayList<Airplane>) oisAirplane.readObject();
            boolean found = false;
            for (Airplane airplane : airplanes) {
                if (airplane.getAirplaneId().equals(airplaneIDToDelete)) {
                    airplanes.remove(airplane);
                    System.out.println("------------------------------------------------------------------------------------------------------");
                    System.out.println("Airplane deleted successfully!");
                    System.out.println();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("Airplane not found!");
                System.out.println();
            }
            oos = new ObjectOutputStream(new FileOutputStream(airplaneFile));
            oos.writeObject(airplanes);
            oos.close();
    }

    public FlightSeatBookings getSeatBookings() {
        return seatBookings;
    }
}



