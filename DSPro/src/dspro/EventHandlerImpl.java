/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspro;

import Node.BankAccount;
import Node.Car;
import Node.House;
import Node.Node;
import Node.Person;
import Node.PhoneNumber;
import java.util.HashMap;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mehrdad
 */
public class EventHandlerImpl implements EventHandler<MouseEvent> {
      private RadioButton personRb ;
      private RadioButton bankAccountRB;
      private RadioButton homeRB;
      private RadioButton carRB;
      private RadioButton phonNumberRB;
      private Label chooseAlert;
      private TextArea txta;
      private TextField txtf;
      private static HashMap<String, Person> people;
      private HashMap<String, Node> g;
      private String str;
      private Node ps;
      private HashMap<String, House> Homes;
      private static HashMap<String, BankAccount> BankAccount;
      private static HashMap<String, PhoneNumber> PhoneNumber;
      private HashMap<String, Car> car;
  
   public EventHandlerImpl() {
            define(); 
        }

   @Override
   public void handle(MouseEvent event) {
            Task<Integer> task;
          task = new Task<Integer>() {
              @Override
              protected Integer call() throws Exception {
                  
                  long now=System.currentTimeMillis();
                phase1();
                  System.out.println("Time Collapsed in fuzz1: "+(System.currentTimeMillis()-now)+"ms");
                  

               return 1;
              }
          };
          
                task.setOnFailed(new EventHandler<WorkerStateEvent>(){
              @Override
              public void handle(WorkerStateEvent event) {
                  System.out.println("taskfailed0");
                  
              }
          });
          
            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    System.out.println("task succeeded1");
                }
            });
            Thread t=new Thread(task);
            t.start();
            
            
        }
    
   
   private void define(){
   String str="nothing";
   personRb =(RadioButton)DSPro.sc.lookup("#personRB");
   bankAccountRB = (RadioButton)DSPro.sc.lookup("#bankAccountRB");
   homeRB = (RadioButton) DSPro.sc.lookup("#homeRB");
   carRB = (RadioButton) DSPro.sc.lookup("#carRB");
   phonNumberRB = (RadioButton) DSPro.sc.lookup("#phonNumberRB");
   chooseAlert =(Label)DSPro.sc.lookup("#chooseLabel");
   txta = (TextArea)DSPro.sc.lookup("#Texta");
   txtf = (TextField)DSPro.sc.lookup("#searchField");
   }
   
   private  void phase1(){
       try{  
     chooseAlert.setText("");
     
     if(personRb.isSelected()){
         str="Person";
         g=(HashMap)CsvReader.CsvNodeReader(CsvReader.path+str+".csv",str);
         ps=(Person)(g.get(txtf.getText()));
         people=(HashMap<String, Person>)(g.clone());
         //System.out.println("Nodesize: "+people.size());
         txta.appendText(ps.toString());
     }
     else if(bankAccountRB.isSelected()){
         str="BankAccount";
         g=(HashMap)CsvReader.CsvNodeReader(CsvReader.path+str+".csv",str);
         ps=(BankAccount)(g.get(txtf.getText()));
         this.BankAccount=(HashMap<String, BankAccount>)(g.clone());
         txta.appendText(ps.toString());
     }
     else if(homeRB.isSelected()){
         str="House";
         g=(HashMap)CsvReader.CsvNodeReader(CsvReader.path+str+".csv",str);
         ps=(House)(g.get(txtf.getText()));
         this.Homes=(HashMap<String, House>)(g.clone());
         txta.appendText(ps.toString());
     }
     else if(carRB.isSelected()){
         str="Car";
         g=(HashMap)CsvReader.CsvNodeReader(CsvReader.path+str+".csv",str);
         ps=(Car)(g.get(txtf.getText()));
         this.car=(HashMap<String, Car>)(g.clone());
         txta.appendText(ps.toString());
     }
     else if(phonNumberRB.isSelected()){
         str="PhoneNumber";
         g=(HashMap)CsvReader.CsvNodeReader(CsvReader.path+str+".csv",str);
         this.PhoneNumber=(HashMap<String, PhoneNumber>)(g.clone());
         ps=(PhoneNumber)(g.get(txtf.getText()));
         txta.appendText(ps.toString());
     }
   
     
    }
    catch(NullPointerException e){
         chooseAlert.setText("bad input");
         System.err.println("error");
    }
   }

   public static HashMap<String, Person> getPeople() {
        return people;
    }

    public static HashMap<String, PhoneNumber> getPhoneNumber() {
        return PhoneNumber;
    }

    public static void setPhoneNumber(HashMap<String, PhoneNumber> PhoneNumber) {
        EventHandlerImpl.PhoneNumber = PhoneNumber;
    }

    public static void setPeople(HashMap<String, Person> people) {
        EventHandlerImpl.people = people;
    }

    public static HashMap<String, BankAccount> getBankAccount() {
        return BankAccount;
    }

    public static void setBankAccount(HashMap<String, BankAccount> BankAccount) {
        EventHandlerImpl.BankAccount = BankAccount;
    }
  
}
