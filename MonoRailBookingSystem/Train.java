/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonoRailBookingSystem;

import java.io.Serializable;

/**
 *
 * @author Mostafa Gado
 */
public class Train implements Serializable{
    private int numberOfSeats;
    private int trainID;
    public Train(int id, int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        trainID = id;
    }
    public Train() {
        numberOfSeats = 0;
        trainID = 0;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    public void setTrainID(int id) {
        trainID = id;
    }

    public int getTrainID() {
        return trainID;
    }

    @Override
    public String toString() {
        return "Train{" + "numberOfSeats=" + numberOfSeats + ", trainID=" + trainID + '}';
    }
    
    
    
}

