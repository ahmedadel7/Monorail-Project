/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonoRailBookingSystem;
import MonoRailBookingSystem.Train;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mostafa Gado
 */
public class Main {
    
    
    public static void main(String[] args) throws Exception {
         
//       User u=new User();
     Data d = new Data();
        Admin a = new Admin();
        Passenger p = new Passenger();
     ArrayList<Admin> arr=new ArrayList<Admin>() ;
     ArrayList<User> passengers = new ArrayList<User>();
      ArrayList<Ticket> ticketCollection = new ArrayList<Ticket>();
       ArrayList<Route> routeCollection = new ArrayList<Route>();
        ArrayList<Train> trainCollection = new ArrayList<Train>();
       try {

//             FileInputStream s1 = new FileInputStream("Admins.txt");
//             ObjectInputStream out1 = new ObjectInputStream(s1);
//        
//            
//              arr = (ArrayList<Admin>) out1.readObject();
//                System.out.println(arr);
//                 s1.close();
//             out1.close();     



             FileInputStream s1 = new FileInputStream("BookedTickets.txt");
             ObjectInputStream out1 = new ObjectInputStream(s1);
              ticketCollection = (ArrayList<Ticket>) out1.readObject();
                System.out.println(ticketCollection);
                 s1.close();
                out1.close();
                
                
//             FileInputStream s1 = new FileInputStream("passengers.txt");
//             ObjectInputStream out1 = new ObjectInputStream(s1);
//              passengers = (ArrayList<User>) out1.readObject();
//                System.out.println(passengers);
//                 s1.close();
//                out1.close();


                    
        
    }catch (Exception  ex) {
             System.out.println(ex);
    }
    }
}
