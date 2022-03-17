 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package MonoRailBookingSystem;
 
 /**
 *
 * @author Mostafa Gado
 */
import java.io.Serializable;
 import java.util.ArrayList;
 import java.time.LocalDate;
 public class Ticket implements Serializable{
    
    private int seatNumber;
    private double departureTime;
    private String passengerDeparture; //originStation
    private String passengerName;  //endStation
    private String end;
    private final double fare = 15;
    private static int count = 0;
    private int ticketId;
    private LocalDate creationDate;
    private Route routeObj;
    private int trainId;

    
    public Ticket(int seatNumber, String passengerName,String origin, String end, double departureTime) {
        
        
        this.departureTime = departureTime;
        this.passengerName =passengerName ;
        this.seatNumber = seatNumber;
        this.end=end;
        passengerDeparture = origin;
       

       
     
        
    }
    public Ticket() {
        seatNumber = 0;
        departureTime = 0.0;
        passengerDeparture = "";
        passengerName ="";
        end="";
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public String getPassengerDeparture() {
        return passengerDeparture;
    }

    public void setPassengerDeparture(String passengerDeparture) {
        this.passengerDeparture = passengerDeparture;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
 
    
//    public void displayTicketInfo() {
//        System.out.println("Seat Number: " + seatNumber);
//        System.out.println("Departure station: " + passengerDeparture);
//        //System.out.println("Arrival station" + passengerArrival);
//        System.out.println("Departure time: " + departureTime);
//        //System.out.println("Arrival time: " + arrivalTime);
//        System.out.println("Ticket fare: " + fare);
//    }

    @Override
    public String toString() {
        return "Ticket{" + "seatNumber=" + seatNumber + ", departureTime=" + departureTime + ", passengerDeparture=" + passengerDeparture + ", passengerName=" + passengerName + ", end=" + end + '}';
    }

    

    
    
    
}