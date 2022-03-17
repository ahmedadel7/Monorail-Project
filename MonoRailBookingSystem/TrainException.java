/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author agh
 */
public class TrainException extends Exception{
    

    String msg;

    public TrainException(String m2 ) {
        msg=m2;
    }
    
    public String  Exception() {
       return  ("FILE ERROR"+msg);
    }
    
}
