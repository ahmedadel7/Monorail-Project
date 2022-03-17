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
public class Trip implements Serializable{

    int trainId;
    int tripID;
    enum states{empty,reserved};
    private static ArrayList<states> seats = new ArrayList<>();
    Train trainObj;
    String tripOriginStation,tripEndStation;
    int tripStartTime,tripEndTime;
    
    
    public Trip(int id, String origin, String endStation, int depTime, int endTime, int trainId) {
        this.tripID = id;
        for(int i = 0; i < trainObj.getNumberOfSeats(); i++) {
            seats.add(states.empty);
        }
        tripOriginStation = origin;
        tripEndStation = endStation;
        tripStartTime = depTime;
        tripEndTime = endTime;
        this.trainId = trainId;

        
    }
    public void SetTripID(int id) {
        tripID = id;
    }
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
    public void reserveSeat(int seatNumber) {
        seats.add(seatNumber - 1, states.reserved);
    }
    public void emptySeat(int seatNumber) {
        seats.add(seatNumber - 1, states.empty);
    }
    public void setTrain(Train trainInput) {
        trainObj = trainInput;
    }
    public void setTripOrigin(String origin) {
        tripOriginStation = origin;
    }
    
    public void setTripEnd(String end) {
        tripEndStation = end;
        
    }
    public void setTripBegin(int startTime) {
        tripStartTime = startTime;
    }
    public void setTripEndTime(int end) {
        tripEndTime = end;
    }
    public int getTripID() {
        return tripID;
    }
    public int getTrainId() {
        return trainId;
    }
    public ArrayList getEmptySeats() {

        ArrayList<Integer> emptySeats = new ArrayList<Integer>(); 
        for(int i = 0; i < trainObj.getNumberOfSeats(); i++) {
            if(seats.get(i) == states.empty) {
                emptySeats.add(i + 1);
            }
        }
        return emptySeats;
    }
    public Train getTrain() {
        return trainObj;
    }
    public String getTripOrigin() {
        return tripOriginStation;
    }
    
    public String getTripArrivalStation() {
        return tripEndStation;
        
    }
    public int getTripBegin() {
        return tripStartTime;
    }
    public int getTripEnd() {
        return tripEndTime;
    }
}