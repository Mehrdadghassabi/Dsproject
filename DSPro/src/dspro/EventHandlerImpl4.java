/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspro;



import Node.Call;
import Node.Person;
import Node.PhoneNumber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Dour-Andish
 */

public class EventHandlerImpl4 implements EventHandler<MouseEvent> {
     private HashMap<String, Person> people;
     private TextArea txta;

    public EventHandlerImpl4() {
  
    }
    
     @Override
    public void handle(MouseEvent event) {
            Task<Integer> task;
          task = new Task<Integer>() {
              @Override
              protected Integer call() throws Exception {
                 
                  long now=System.currentTimeMillis();
                      
                phase4();
                 
                  System.out.println("Time Collapsed in fuzz4: "+(System.currentTimeMillis()-now)+"ms");

                    return 1;
 
              }
          };
          
                task.setOnFailed(new EventHandler<WorkerStateEvent>(){
              @Override
              public void handle(WorkerStateEvent event) {
                  System.out.println("taskfailed1");
                  
              }
          });
          
            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    //System.out.println(Suspectedcall(task.getValue()));
                }
            });
            Thread t=new Thread(task);
            t.start();
            
            
        }
    
    public void phase4(){
    String str= Suspected(EventHandlerImpl2.getSuspected(),
                          Suspectedcall(smugglernum())).toString();
                     txta = (TextArea)DSPro.sc.lookup("#Texta");
                     txta.setText(str.substring(1, str.length()-1));
    }
    
    private LinkedList<Person> smuggler(){
             if(EventHandlerImpl.getPeople()==null)
          this.people=(HashMap)CsvReader.CsvNodeReader("E:\\data\\"+"Person"+".csv","Person");
          else
             this.people=EventHandlerImpl.getPeople();
             
     
       LinkedList<Person> re=new LinkedList<>();
       Collection<Person> col=people.values();
       for(Person p:col){
        if((p.workplace.contains("قاچاق"))){
            re.add(p);
        }
       }
 
       return re;
   }  

    private ArrayList<PhoneNumber> smugglernum(){
        ArrayList<PhoneNumber> re=new ArrayList<>();
    
      if(EventHandlerImpl.getPhoneNumber()==null){
          EventHandlerImpl.setPhoneNumber((HashMap)CsvReader.
                  CsvNodeReader("E:\\data\\"+"PhoneNumber"+".csv","PhoneNumber"));
          //this.PhoneNumber=EventHandlerImpl.getPhoneNumber();
             }
          Collection<PhoneNumber> val=EventHandlerImpl.getPhoneNumber().values();
          for(Person person:smuggler()){
           for(PhoneNumber ph:val){
           if(person.nationalcode.equals(ph.ownernationalcode))
           re.add(ph);
           }
          }
    return re;
    }
    
    private ArrayList<Person> Suspectedcall(ArrayList<PhoneNumber> smg){
    ArrayList<Person> re=new ArrayList<>();
    
      if(EventHandlerImpl.getPeople()==null){
          EventHandlerImpl.setPeople((HashMap)CsvReader.
                  CsvNodeReader("E:\\data\\"+"Person"+".csv","Person"));
             }
     HashMap<String, Call> calls=(HashMap)CsvReader.
                  CsvEdgeReader("E:\\data\\"+"calls"+".csv","Call");
    Collection<Call> call=calls.values();

    for(PhoneNumber ph:smg){
     
        for(Call c:call){
        if(c.sfrom.equals(ph.phonenumber)){
        PhoneNumber a=EventHandlerImpl.getPhoneNumber().get(c.sto);
          //  System.out.println("sto: "+c.sto);
        re.add(EventHandlerImpl.getPeople().get(a.ownernationalcode));
        }
            
        }
    
    }
    return re;
    }
    
    ArrayList<Person> Suspected(LinkedList<Person> Suspected,ArrayList<Person> Suspectedcall){
        ArrayList<Person> re=new  ArrayList<>();
        for(Person p:Suspected){
        for(Person p1:Suspectedcall){
            if((p.nationalcode.equals(p1.nationalcode))||(p.firstname.equals(p1.firstname)&&p.lastname.equals(p1.lastname))){
                re.add(p);
         }
        }
        }
        return re;
    }
}
