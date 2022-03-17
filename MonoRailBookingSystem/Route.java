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
import java.util.Random;
import java.util.Scanner;
public class Route implements Serializable {
    //assuming speed of every train is constant equals 60 km/h
    private int routeID;
    private ArrayList <String> stoppingStations = new ArrayList<>();
    private ArrayList <Integer> runningTime = new ArrayList<>();
    private ArrayList <Integer> distance = new ArrayList<>();
    private final int trainSpeed = 60; // 60 km/h
    private String originStation;
    private String endStation;
    
    public Route(int routeID, ArrayList<String> stations) {
        this.routeID = routeID;
        int time;
        for(int i = 0; i < (stations. size()- 1); i++) {
            stoppingStations.add(stations.get(i));
        }
        for(int i = 1; i < (stations.size() - 1); i++) {
            int randDist = new Random().nextInt(15);
            randDist += 2;
            distance.add(randDist);
        }
        for(int i = 1; i < (stations.size() - 1); i++) {
            time = distance.get(i - 1) / trainSpeed;
            runningTime.add(time);
        }
        originStation = stoppingStations.get(0);
        endStation = stoppingStations.get(stoppingStations.size() - 1);
    }
    public int getTimeBet2Stations(String origin, String end) {
        Scanner input = new Scanner(System.in);
        int endIndex;
        int startIndex;
        int time2Stations = 0;
        endIndex = stoppingStations.indexOf(end);
        startIndex = stoppingStations.indexOf(origin);
        for(int i = startIndex; i < endIndex; i++) {
            time2Stations += runningTime.get(i);
        }
        input.close();
        return time2Stations;
    }
    public void setRouteID(int id) {
        routeID = id;
    }
    public void setStoppingStations(ArrayList<String> stations) {
        stoppingStations = stations;
    }
    public void setDistances(String[] stations) {

    for(int i = 1; i < stoppingStations.size() - 1; i++) {
            int randDist = new Random().nextInt(15);
            distance.add(randDist);
        }
    }
    public void setRunningTimes() {
        int time;
        for(int i = 1; i < stoppingStations.size() - 1; i++) {
            time = distance.get(i) / trainSpeed;
            runningTime.add(time);
        }
    }
    public void setOriginStation() {
        originStation = stoppingStations.get(0);
    }
    public void setEndStation() {
        endStation = stoppingStations.get(stoppingStations.size() - 1);
    }
    public int getRouteID() {
        return routeID;
    }
    public ArrayList<String> getStoppingStations() {
        return stoppingStations;
    }
    public ArrayList<Integer> getDistances() {
        return distance;
    }
    public ArrayList<Integer> getRunningTimes() {
        return runningTime;
    }
    public String getOriginStation() {
        return originStation;
    }
    public String getEndStation() {
        return endStation;
    }
}
