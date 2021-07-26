/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspro;

import Node.BankAccount;
import Node.Call;
import Node.Car;
import Node.Edge;
import Node.House;
import Node.Node;
import Node.Ownership;
import Node.Person;
import Node.PhoneNumber;
import Node.Relationship;
import Node.Transaction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dour-Andish
 */
public class CsvReader {
     protected static String path="E:\\data\\";
    
   protected static Map<String,Node> CsvNodeReader(String f,String type){
      Map m = new HashMap();
      String csvFile = f;/*"E:\\data\\cars.csv";*/
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
      boolean count=true;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cloumn = line.split(cvsSplitBy);
                
                 for(int i=0;i<cloumn.length;i++){
                 cloumn[i]=cloumn[i].substring(1, cloumn[i].length()-1);
                 }
                 
                 if(count){
                 count=false;
                 continue;
                 }
           
               if(type.equals("Car"))
                   m.put(cloumn[0],new Car(cloumn[0],cloumn[1],cloumn[2],cloumn[3]));
               
                 if(type.equals("BankAccount"))
                   m.put(cloumn[0],new BankAccount(cloumn[0],cloumn[1],cloumn[2],cloumn[3]));
         

                 
                 if(type.equals("House"))
                   m.put(cloumn[2],new House(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                 
                if(type.equals("Person"))
                   m.put(cloumn[2],new Person(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4],cloumn[5]));
                
                  if(type.equals("PhoneNumber"))
                   m.put(cloumn[1],new PhoneNumber(cloumn[0],cloumn[1],cloumn[2]));
            }
           return m;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
   
   protected static Map<String,Edge> CsvEdgeReader(String f,String type){
      Map m = new HashMap();
      String csvFile = f;/*"E:\\data\\cars.csv";*/
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
      int counter=0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (((line = br.readLine()) != null)&&counter<400000) {

                // use comma as separator
                String[] cloumn = line.split(cvsSplitBy);
                
                 for(int i=0;i<cloumn.length;i++){
                 cloumn[i]=cloumn[i].substring(1, cloumn[i].length()-1);
                 }
                 
                 if(cloumn[0].equals("from"))
                     continue;
           
               if(type.equals("Call"))
                   m.put(cloumn[2],new Call(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
               
                 if(type.equals("Relationship"))
                   m.put(cloumn[0]+cloumn[1],new Relationship(cloumn[0],cloumn[1],cloumn[2],cloumn[3]));
                 
                 if(type.equals("Transaction"))
                   m.put(cloumn[2],new Transaction(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                 
                if(type.equals("Ownership"))
                   m.put(cloumn[1],new Ownership(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                
                counter++;
              
            }
           return m;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
   
   protected static Map<String, ArrayList<Edge>> CsvReader(String f,String type){
      Map m = new HashMap();
      String csvFile = f;/*"E:\\data\\cars.csv";*/
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cloumn = line.split(cvsSplitBy);
                
                 for(int i=0;i<cloumn.length;i++){
                 cloumn[i]=cloumn[i].substring(1, cloumn[i].length()-1);
                 }
           
                   if(cloumn[0].equals("from"))
                     continue;
                 
            
                if(type.equals("Ownership")){
                    
                    
                   if(m.get(cloumn[0])==null){
                   ArrayList<Ownership> arr=new ArrayList<>();
                   arr.add(new Ownership(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                   m.put(cloumn[0],arr);
                   }
                   else{
                   ArrayList<Ownership> n=(ArrayList)(m.get(cloumn[0]));
                   n.add(new Ownership(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                   }
                }
                
                
                if(type.equals("Transaction")){
                    
                    
                   if(m.get(cloumn[0])==null){
                   ArrayList<Transaction> arr=new ArrayList<>();
                   arr.add(new Transaction(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                   m.put(cloumn[0],arr);
                   }
                   else{
                   ArrayList<Transaction> n=(ArrayList)(m.get(cloumn[0]));
                   n.add(new Transaction(cloumn[0],cloumn[1],cloumn[2],cloumn[3],cloumn[4]));
                   }
                }
                
                
               
            }
           return m;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
   
    protected static Map<String, ArrayList<String>> CsvtranReader(String f,String type){
      Map m = new HashMap();
      String csvFile = f;/*"E:\\data\\cars.csv";*/
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cloumn = line.split(cvsSplitBy);
                
                 for(int i=0;i<cloumn.length;i++){
                 cloumn[i]=cloumn[i].substring(1, cloumn[i].length()-1);
                 }
           
                   if(cloumn[0].equals("from"))
                     continue;
               
                
                if(type.equals("Transaction")){
                    
                    
                   if(m.get(cloumn[0])==null){
                   ArrayList<String> arr=new ArrayList<>();
                   arr.add(cloumn[1]);
                   m.put(cloumn[0],arr);
                   }
                   else{
                   ArrayList<String> n=(ArrayList)(m.get(cloumn[0]));
                   n.add(cloumn[1]);
                   }
                }
                
                
               
            }
           return m;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
   
   protected static  boolean isOndate( ArrayList<Ownership> in){
            for(Ownership o:in){
            String year=o.date.substring(0,4 );
             short y=Short.valueOf(year);
             
             if(y>2015)
                 return true;
            }
            return false;
    }
}

