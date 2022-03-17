package MonoRailBookingSystem;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Serializable{
    
         ArrayList<Train> arr=new ArrayList<Train>() ;
           

    public Admin() throws Exception {
        arr.add(new Train(123,50));
         arr.add(new Train(551,40));
         arr.add(new Train(600,45));
         arr.add(new Train(225,50));
         arr.add(new Train(451,50));
         
//           FileOutputStream s = new FileOutputStream("Trainss.txt");
//            ObjectOutputStream out = new ObjectOutputStream(s);
//            out.writeObject(arr);
//         s.close();
//          out.close();
        
    }
    
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
     
        
    }
    
 
 
    public void addTrain(int trainNumber, int numberOfSeats) throws IOException{
           try{
               FileInputStream s1 = new FileInputStream("Trainss.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
          arr = (ArrayList<Train>) in.readObject();
           s1.close();
           in.close();
        Train train1 = new Train(trainNumber, numberOfSeats);
        arr.add(train1);
        FileOutputStream s = new FileOutputStream("Trainss.txt");
        ObjectOutputStream out = new ObjectOutputStream(s);
        out.writeObject(arr);
         s.close();
          out.close();
        
        System.out.println("Train has been added successfully with id number" + trainNumber);
        
           }catch(Exception e){
               System.out.println(e);
           }
    }
    
    
    
    public void removeTrain(int trainID) throws Exception{
       try{
          FileInputStream s1 = new FileInputStream("Trainss.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
        Train T = new Train();
           arr = (ArrayList<Train>) in.readObject();
           s1.close();
           in.close();
           
        for(int i = 0;i < arr.size(); i++){
            T = arr.get(i);
            if(T.getTrainID() == trainID){
            arr.remove(i);        
             FileOutputStream s = new FileOutputStream("Trainss.txt");
        ObjectOutputStream out = new ObjectOutputStream(s);
              out.writeObject(arr);
      s.close();
        out.close();
            }
        }
       }catch(IOException E){
           System.out.println(E);
       }
         System.out.println("Train has been Removed successfully with id number" + trainID);
              
       
    }
    
    
    public void updateTrain(int trainID,int newNo_seats) throws Exception{
       try{
        FileInputStream s1 = new FileInputStream("Trainss.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
        Train T = new Train();
           arr = (ArrayList<Train>) in.readObject();
           s1.close();
           in.close();
   
        for(int i = 0; i < arr.size(); i++){
            T = arr.get(i);
            if(T.getTrainID() == trainID) {
                T.setNumberOfSeats(newNo_seats);
                arr.set(i, T);
                   FileOutputStream s = new FileOutputStream("Trainss.txt");
        ObjectOutputStream out = new ObjectOutputStream(s);
              out.writeObject(arr);
      s.close();
        out.close();
            }
        }
        }catch(Exception E){
                System.out.println(E);
                }
              System.out.println("Train has been Updated successfully with id number" + trainID);
    }
     
    
    public void changeAdminUsername(String username) {
        setUsername(username);
    }
    public void changeAdminFirstName(String firstName) {
        setFirstName(firstName);
    }
    public void changeAdminLastName(String lastName) {
        setLastName(lastName);
    }

   
     
}