/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspro;


import Node.Ownership;
import Node.Person;
import Node.Relationship;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 *
 * @author Dour-Andish
 */

public class EventHandlerImpl2 implements EventHandler<MouseEvent> {
      private HashMap<String, Person> people;
      private HashMap<String, ArrayList<Ownership>> ownership;
      private HashMap<String,Relationship> relationship;
      private LinkedList<Person> portworker;
      private LinkedList<Person> portworkerfamily;
      private TextArea txta;
      private static LinkedList<Person> Suspected;
      FileChooser fileChooser ;

    public EventHandlerImpl2() {
        this.Suspected = new LinkedList<>();
        fileChooser = new FileChooser();
    }
    
     @Override
    public void handle(MouseEvent event) {
            Task<Integer> task;
          task = new Task<Integer>() {
              @Override
              protected Integer call() throws Exception {
                  
                  ArrayList<ArrayList<Ownership>> re=new ArrayList<>();
                  long now=System.currentTimeMillis();
                  fuzz2(re);
  
                 System.out.println("Time Collapsed in fuzz2: "+(System.currentTimeMillis()-now)+"ms");
      
               return 1;
              }
          };
          
                task.setOnFailed(new EventHandler<WorkerStateEvent>(){
              @Override
              public void handle(WorkerStateEvent event) {
                  System.out.println("taskfailed2");
                  
              }
          });
          
            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    System.out.println("task succeeded2");
                }
            });
            Thread t=new Thread(task);
            t.start();
            
            
        }
    
    
    private LinkedList<Person> findportworker(){
             if(EventHandlerImpl.getPeople()==null){
          EventHandlerImpl.setPeople((HashMap)CsvReader.CsvNodeReader(CsvReader.path+"Person"+".csv","Person"));
             }
             
             
       LinkedList<Person> re=new LinkedList<>();
       Collection<Person> col=EventHandlerImpl.getPeople().values();
       for(Person p:col){
        if((p.workplace.contains("گمرک")||p.workplace.contains("بندر"))&&!p.workplace.contains("پتروشیمی")
                &&!p.workplace.contains("پالایش"))
            re.add(p);
       }
       return re;
   }  
    
    
    private void fuzz2(ArrayList<ArrayList<Ownership>> re){   

         relationship=(HashMap)CsvReader.CsvEdgeReader(CsvReader.path+"relationships.csv","Relationship");
         portworker=findportworker();
          portworkerfamily = new LinkedList<>();
           Collection<Relationship> col=relationship.values();
      
      for(Map.Entry<String,Relationship> e:relationship.entrySet()){
          for(Person person:portworker){
            if(e.getKey().startsWith(person.nationalcode)){
               portworkerfamily.add(EventHandlerImpl.getPeople().get(e.getValue().secoundNationalcode));    
      }
      }
      }
     
               ownership=(HashMap)CsvReader.CsvReader(CsvReader.path+"ownerships.csv","Ownership");
     
   
               for(Person person:portworkerfamily){
               ArrayList<Ownership> a=ownership.get(person.nationalcode);
               
                 if(a!=null)
                     re.add(a);
          
               }
               
               for(Person person:portworker){
               ArrayList<Ownership> a=ownership.get(person.nationalcode);
                        if(a!=null)
                     re.add(a);
                
                
    }
               for(ArrayList<Ownership> obj:re){
                    if(CsvReader.isOndate(obj))
                        Suspected.add(EventHandlerImpl.getPeople().get(obj.get(0).sfrom));
                    }
                   // System.out.println(Suspected);
                    txta = (TextArea)DSPro.sc.lookup("#Texta");
                    txta.setText(Suspected.toString().substring(1, Suspected.toString().length()-1));
    }

    public static LinkedList<Person> getSuspected() {
        return Suspected;
    }
    
}
