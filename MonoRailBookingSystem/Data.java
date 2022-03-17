package MonoRailBookingSystem;

import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Data implements Serializable{

    public ArrayList<User> passengerCollection = new ArrayList<User>(); 
    public ArrayList<Ticket> ticketsCollection = new ArrayList<Ticket>(); 
    public ArrayList<Route> routeCollection = new ArrayList<Route>();  
    public ArrayList<String> stationsCollection = new ArrayList<String>();
    public ArrayList<String> stationsCollection2 = new ArrayList<String>();
    public ArrayList<String> stationsCollection3 = new ArrayList<String>();
    public ArrayList<Trip> tripCollection = new ArrayList<Trip>();
    public ArrayList<Train> trainCollection = new ArrayList<Train>();
    
    public Data() throws Exception {
        try {


        stationsCollection.add("Maadi");
        stationsCollection.add("Dar Al Salam");
        stationsCollection.add("Al Sadaat");
        stationsCollection.add("Al Sayeda");
        stationsCollection.add("Al Abasseya");
        
        FileOutputStream stationsCollOutput = new FileOutputStream("Stations1.txt");
        ObjectOutputStream stationObjOutput = new ObjectOutputStream(stationsCollOutput);    
        stationObjOutput.writeObject(stationsCollection);
        stationsCollOutput.close();
        stationObjOutput.close();
        
        stationsCollection2.add("Helwan");
        stationsCollection2.add("Tora Al Balad");
        stationsCollection2.add("7elmeyet el zatoon");
        stationsCollection2.add("Bolak Al Dakroor");
        stationsCollection2.add("Marg");
        
        FileOutputStream stationsColl2Output = new FileOutputStream("Stations2.txt");
        ObjectOutputStream stations2OutputObj = new ObjectOutputStream(stationsColl2Output);    
        stations2OutputObj.writeObject(stationsCollection2);
        stationsColl2Output.close();
        stations2OutputObj.close();

        
        stationsCollection3.add("Nasr City");
        stationsCollection3.add("Sheraton");
        stationsCollection3.add("Cairo Airport");
        stationsCollection3.add("Al Shorouq");
        stationsCollection3.add("New Cairo Settlement");

        
        FileOutputStream stationsColl3Output = new FileOutputStream("Stations3.txt");
        ObjectOutputStream stations3OutputObj = new ObjectOutputStream(stationsColl3Output);    
        stations3OutputObj.writeObject(stationsCollection3);
        stationsColl3Output.close();
        stations3OutputObj.close();

        routeCollection.add(new Route(1, stationsCollection));
        routeCollection.add(new Route(2, stationsCollection2));
        routeCollection.add(new Route(3, stationsCollection3));
        
        FileOutputStream routeOutput = new FileOutputStream("Routes.txt");
        ObjectOutputStream routeObjOutput = new ObjectOutputStream(routeOutput);    
        routeObjOutput.writeObject(routeCollection);
        routeOutput.close();
        routeObjOutput.close();

        passengerCollection.add(new User("aa", "aa", "Amr", "Hassan"));
        passengerCollection.add(new User("mm", "mm", "Mohamed", "Ghareeb"));
        passengerCollection.add(new User("Abdelazeem", "password", "AbdelAzeem", "Hassan"));
        
        FileOutputStream passengerOutput = new FileOutputStream("passengers.txt");
        ObjectOutputStream passengerObjOutput = new ObjectOutputStream(passengerOutput);    
        passengerObjOutput.writeObject(passengerCollection);
        passengerOutput.close();
        passengerObjOutput.close();

//        FileInputStream trainInputStream = new FileInputStream("Trainss.txt");
//        ObjectInput trainInputObj = new ObjectInputStream(trainInputStream);
//        trainCollection = (ArrayList<Train>)trainInputObj.readObject();
//        trainInputStream.close();
//        trainInputObj.close();
//        
//        tripCollection.add(new Trip(1, routeCollection.get(0).getOriginStation(), routeCollection.get(0).getEndStation(),
//                             9, 10, trainCollection.get(0).getTrainID()));
//
//        FileOutputStream tripOutputStream = new FileOutputStream("Trips.txt");
//        ObjectOutputStream tripOutputObj = new ObjectOutputStream(tripOutputStream);    
//        tripOutputObj.writeObject(routeCollection);
//        tripOutputStream.close();
//        tripOutputObj.close();



        } catch(Exception ex) {
            System.out.println(ex);
        }

    }
    
}