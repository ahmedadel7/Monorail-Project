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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Passenger extends User {
    
    ArrayList<Ticket> ticketsArr = new ArrayList<>();

   
    Passenger(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
    }

    public Passenger() throws Exception {
        
        Ticket t = new Ticket(10,"a","a","s",10.0);
        ticketsArr.add(t);
        
    }
    /** 
     * @param password
     */
    // Functions for passenger to edit/manage their account

    public void changePassengerPassword(String password) {
        setPassword(password);
    }
    
    /** 
     * @param username
     */
    public void changePassengerUsername(String username) {
        setUsername(username);
    }
    
    /** 
     * @param firstName
     */
    public void changePassFirstName(String firstName) {
        setFirstName(firstName);
    }
    
    /** 
     * @param lastName
     */
    public void changePassLastName(String lastName) {
        setLastName(lastName);
    }

    
    /** 
     * @param seatNumber
     * @param tripInput
     * @param endStation
     * Function books ticket adds it to ticketsArr in passenger returns true if booked successfully, false otherwise
     * @throws FileNotFoundException
     */
    public void bookTicket(int seatNumber, String passengerName, String origin, String end, double departureTime) throws Exception {
            
        try {
            FileInputStream s1 = new FileInputStream("BookedTickets.txt");
            ObjectInputStream in = new ObjectInputStream(s1);
            ticketsArr = (ArrayList<Ticket>) in.readObject();
            s1.close();
            in.close();
             Ticket ticket1 = new Ticket(seatNumber, passengerName, origin, end, departureTime);
            ticketsArr.add(ticket1);
            FileOutputStream outputStream = new FileOutputStream("BookedTickets.txt");
            ObjectOutputStream outputStreamObj = new ObjectOutputStream(outputStream);
            outputStreamObj.writeObject(ticketsArr);
            outputStream.close();
            outputStreamObj.close();
            System.out.println("thank you");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    /** 
     * @param seatNumber
     * Function updates ticket information for an already reserved ticket, updates last element in tickets arraylist
     * @throws FileNotFoundException
     */
    public void updateBooking(int seatNumber, double departureTime, String origin, String end, int newSeatNumber) throws Exception {

         try {
        Ticket temp = new Ticket();
        FileInputStream fileInputObj = new FileInputStream("BookedTickets.txt");
        ObjectInputStream inputObj = new ObjectInputStream(fileInputObj);
        ticketsArr = (ArrayList<Ticket>) inputObj.readObject();
        fileInputObj.close();
        inputObj.close();
   
        for(int i = 0; i < ticketsArr.size(); i++) {
            temp = ticketsArr.get(i);
            if(temp.getSeatNumber() == seatNumber) {
                
               
                    
                    FileOutputStream outputStream = new FileOutputStream("BookedTickets.txt");
                    ObjectOutputStream outputStreamObj = new ObjectOutputStream(outputStream);
                    temp.setSeatNumber(newSeatNumber);
                    temp.setDepartureTime(departureTime);
                    temp.setEnd(end);
                    temp.setPassengerDeparture(origin);
                    ticketsArr.set(i, temp);
                    outputStreamObj.writeObject(ticketsArr);
                    outputStream.close();
                    outputStreamObj.close();
                } 
            }


            }catch(Exception ex) {
                    System.out.println("Error updating ticket");
            }
    }

    

    /**
     * Function cancels ticket, returns true if ticket was removed from tickets collection
     */
    public void cancelBooking(int seatNumber) throws Exception {
        
        try {
        Ticket temp = new Ticket();
        FileInputStream fileInputObj = new FileInputStream("BookedTickets.txt");
        ObjectInputStream inputObj = new ObjectInputStream(fileInputObj);
        ticketsArr = (ArrayList<Ticket>) inputObj.readObject();
        fileInputObj.close();
        inputObj.close();
   
        for(int i = 0; i < ticketsArr.size(); i++) {
            temp = ticketsArr.get(i);
            if(temp.getSeatNumber() == seatNumber) {
                
                
                    
                    ticketsArr.remove(i);
                     FileOutputStream outputStream = new FileOutputStream("BookedTickets.txt");
                    ObjectOutputStream outputStreamObj = new ObjectOutputStream(outputStream);
                    outputStreamObj.writeObject(ticketsArr);
                    outputStream.close();
                    outputStreamObj.close();

            }
        }
            } catch(Exception ex) {
                    System.out.println("Error updating ticket");
                }
        
    }

    
/**
     * Function to print All tickets in passenger accout, prints ticket info for all elements in ticket arraylist
     */

    public void printTicketList() {
        Ticket ticketObj = new Ticket();
        for(int i = 0; i < ticketsArr.size(); i++) {
            ticketObj = ticketsArr.get(i);
            System.out.print(i + ". ");
            //ticketObj.displayTicketInfo();
            System.out.println("");
        }
    }

    
    

}
