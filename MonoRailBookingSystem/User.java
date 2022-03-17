/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonoRailBookingSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
     ArrayList<Passenger> users; 
  
    ArrayList<Admin> admins=new ArrayList<Admin> ();
    public User(String username, String password, String fname, String lname) {
        this.username = username;
        this.password = password;
        firstName = fname;
        lastName = lname;
        
        
    }
    public User() throws Exception {
        username = "";
        password = "";
        firstName = "";
        lastName = "";
         admins.add(new Admin("ahmed","1234","Ahmed","Adel"));
         admins.add(new Admin("Mostafa","12345","Mostafa","Gado"));
         admins.add(new Admin("Sana","3333","Sana","Darweesh"));
         admins.add(new Admin("Menna","4444","Menna","Magdy"));
         admins.add(new Admin("Eyad","123457","Eyad","Mostafa"));

       
       
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String fname) {
        firstName = fname;
    }
    public void setLastName(String lname) {
        lastName = lname;
    }    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

   
 public void createAccount(String username, String password, String fname, String lname) throws Exception {
        try{    
            FileInputStream s1 = new FileInputStream("passengers.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
        users = (ArrayList<Passenger>) in.readObject();
        s1.close();
        in.close();
        Passenger passengerUser = new Passenger(username, password, fname, lname);
            //passengerUser.setType("Passenger");
            users.add(passengerUser);
            System.out.println("Passenger user has been created successfully");
        FileOutputStream fos = new FileOutputStream("passengers.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
        }
        catch(Exception EX){
            System.out.println(EX);
        }
    }
  public User userLogin(String username, String password) throws Exception {
        User index = new User();
        //Creating user object
        try{
        FileInputStream fis = new FileInputStream("passengers.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (ArrayList<Passenger>)ois.readObject();
        fis.close();
        ois.close();
        for(int i = 0; i < users.size(); i++) {
            index = users.get(i);
            // Check username
            if (index.getUsername().equals(username)&& index.getPassword().equals(password)) {
                //Check password
                return index;
            }
        }
        
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
  
   public boolean UpdateAdminAccount(String name,String newpass){
        try{
        FileInputStream s1 = new FileInputStream("Admins.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
           admins = (ArrayList<Admin>) in.readObject();
    s1.close();
           in.close();
           Admin A ;
        for(int i = 0; i < admins.size(); i++){
            A= admins.get(i);
            if(A.getUsername().equals(name)) {
                
                A.setPassword(newpass);
               admins.set(i, A);
                
                FileOutputStream s; 
                s = new FileOutputStream("Admins.txt");
              ObjectOutputStream out1 = new ObjectOutputStream(s);
              out1.writeObject(admins);
      s.close();
        out1.close();
        System.out.println("Admin has been Updated successfully with username "+name);
           return true;
            }
              
      
        }
        }catch(Exception E){
                System.out.println(E);
                }
        return false;
             
   }
    public Admin adminLogin (String name, String pass) throws Exception
    {
        
        try{
        User a=new User();
         Admin admin = new Admin();
         FileInputStream s1 = new FileInputStream("Admins.txt");
        ObjectInputStream in = new ObjectInputStream(s1);
        admins = (ArrayList<Admin>) in.readObject();
        s1.close();
        in.close();

        for(int i = 0; i < admins.size(); i++) {
            admin = admins.get(i);
           
            if (admin.getUsername().equals(name)&& admin.getPassword().equals(pass)) {
               
                return admin;
            }
        }
      
}catch(Exception e){
            System.out.println(e);
}
          return null;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

 
}