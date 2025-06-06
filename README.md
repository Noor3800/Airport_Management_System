# Airport_Management_System

Problem Statement for an Airport Management System
An Airport Management System (AMS) is designed to streamline the operations of an airport, catering to the diverse needs of passengers, airline staff, and ground operations. The primary objective is to provide an efficient, user-friendly interface for managing flights, passengers, cargo, and airport resources. The system must handle tasks such as flight scheduling, passenger check-in, baggage handling, security checks, and overall airport administration. It should also consider factors like real-time flight information, aircraft maintenance, and airport security. Scalability, reliability, and security are paramount to ensure the smooth functioning of the airport's day-to-day activities.

1.	Analysis of the Problem Statement:


Nouns:


•	Airport

•	Flight

•	Passenger

•	Cargo

•	Airport Staff

•	Baggage

•	Security Check

•	Maintenance

•	Check-In

•	Boarding

•	FlightStatus (Enum)

•	SecurityStatus (Enum)

•	BoardingStatus (Enum)

•	Loggable (Interface)

•	Inspectable (Interface)

•	PaymentProcessor (Interface)


Verbs:


•	Schedule

•	Manage

•	Handle

•	Administer

•	Check-In

•	Board

•	Inspect

•	Maintain

•	Secure

•	Update

•	Log

•	Inspect

•	Process


2.	Mapping to Classes, Methods, and Attributes:

Enums:

•	FlightStatus: ON_TIME, DELAYED, CANCELED

•	SecurityStatus: PASSED, FAILED, PENDING

•	BoardingStatus: BOARDING, ON_BOARD, MISSED


Interfaces:

•	Loggable: void logActivity(String activity)

•	Inspectable: inspect()

•	PaymentProcessor: processPayment(double amount)


Classes:


a.	Log (Class implementing Loggable):

Methods: logActivity()

b.	Security Check (Class implementing Inspectable):

Methods: inspect()

c.	PaymentService (Class implementing PaymentProcessor):

Methods: processPayment()

d.	Airport:

Attributes: AirportCode, Location, Flights[], Passengers[], Staff[], Logs[]

Methods: ScheduleFlight(), ManagePassenger(), UpdateSecurityStatus()


e.	Flight:

Attributes: FlightNumber, DepartureTime, ArrivalTime, Aircraft, Status (FlightStatus)

Methods: UpdateStatus(), CheckAvailability(), BoardPassengers()


f.	Passenger:

Attributes: PassengerID, Name, TicketNumber, CheckInStatus, PaymentService

Methods: CheckIn(), ReserveSeat(), UpdateInformation()


g.	Cargo:

Attributes: CargoID, Description, Weight, Destination, Status

Methods: TrackCargo(), UpdateStatus(), ManageCargo()


h.	Airport Staff:

Attributes: StaffID, Name, Role, Schedule

Methods: AssignTask(), UpdateSchedule(), CheckInPassenger()


i.	Baggage:

Attributes: BaggageID, PassengerID, Weight, SecurityStatus (SecurityStatus)

Methods: Scan(), UpdateStatus(), Transfer()


j.	Security Check:

Attributes: CheckpointID, StaffID, PassengerID, Status (SecurityStatus)

Methods: InspectBaggage(), VerifyPassenger(), UpdateStatus()


k.	Maintenance:

Attributes: AircraftID, Description, LastMaintenanceDate, NextMaintenanceDate

Methods: PerformMaintenance(), ScheduleMaintenance(), UpdateStatus()


l.	Check-In:

Attributes: CheckInID, PassengerID, FlightNumber, Status (BoardingStatus)

Methods: ProcessCheckIn(), UpdateStatus(), PrintBoardingPass()


m.	Boarding:

Attributes: BoardingID, FlightNumber, PassengerID, Status (BoardingStatus)

Methods: BoardPassenger(), UpdateStatus(), VerifyBoardingPass()


3.	Relationships:


•	Airport has associations with Flight, Passenger, Cargo, Airport Staff, Baggage, Security Check, Maintenance, Check-In, and Boarding classes.

•	Airport logs activities through the Logs[] attribute.

•	Flight is associated with Airport, Passenger, Baggage, and Boarding.

•	FlightStatus (Enum) is an attribute indicating the status of the flight.

•	Passenger is associated with Airport, Flight, Baggage, Check-In, and Boarding.

•	PaymentService (Interface) is used for payment-related functionality.

•	Cargo is associated with Airport.

•	CargoStatus (Enum) is an attribute indicating the status of the cargo.

•	Airport Staff is associated with Airport and Security Check.

•	Baggage is associated with Airport, Flight, Passenger, and Security Check.

•	Security Check is associated with Airport, Airport Staff, Passenger, and Baggage.

•	SecurityStatus (Enum) is an attribute indicating the security status of the baggage and security check.

•	Maintenance is associated with Airport and Flight.

•	Check-In is associated with Airport, Passenger, and Boarding.

•	Boarding is associated with Airport, Flight, and Passenger.

•	Log is associated with the Airport class.

•	BoardingStatus (Enum) is an attribute indicating the boarding status.


4.UML Class Diagram : 

Creating a UML Class Diagram involves using a specific set of symbols and 
notation to represent the classes and their relationships visually. In a text-based 
medium like this, describing the UML diagram is not practical. Instead, the 
relationships can be summarized as follows: 

 Flights have many-to-many relationship with passengers. 

 Passengers have one-to-many relationship with baggage. 

 Airport has one-to-many relationship with Passengers and staff. 

 Passengers have aggregation relationship with baggage. 

 Maintaince is associated with Flights and Airport.
