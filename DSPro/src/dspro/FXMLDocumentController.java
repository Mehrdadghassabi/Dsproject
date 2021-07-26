package dspro;



import Node.BankAccount;
import Node.Person;
import static dspro.EventHandlerImpl3.sumggler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;


public class FXMLDocumentController implements Initializable {
    
   private ToggleGroup toggleGroup=new ToggleGroup();
 
   public static LinkedList<Person> sumggler;
    private LinkedList<BankAccount> smgAccount;
    private HashSet<ArrayList<String>> firstime;
     private HashSet<ArrayList<String>> secontime;
      private HashSet<ArrayList<String>> thirtime;
     private HashSet<ArrayList<String>> fourtime;
    private HashSet<ArrayList<String>> fiftime;
    private  Map<String, ArrayList<String>> m;
     private static LinkedList<Person> Suspected;
   
 
   @Override
   public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     
   @FXML
   private void handleButtonAction(ActionEvent event) {
     /*     firstime=new HashSet<>();
    secontime=new HashSet<>();
    thirtime=new HashSet<>();
    fourtime=new HashSet<>();
    fiftime=new HashSet<>();
    FXMLDocumentController.Suspected=EventHandlerImpl2.getSuspected();
           findtran();
               HashMap<String, BankAccount> ba=getBankac();
                 boolean a=false;
                 for(int i=0;i<Suspected.size();i++){
                BankAccount c= ba.get(Suspected.get(i).nationalcode);
                
                for(ArrayList<String> as:firstime)
                    for(String str:as){
                      
                        if(c!=null){
                            a =a||(c.accountnumber.equals(str));
                         // System.out.println(c.accountnumber.equals(str));
                         a =a||(c.accountnumber.equals(str));
                           System.out.println(a);
                        }
                        
                          for(ArrayList<String> as1:secontime)
                    for(String str1:as1){
                
                        if(c!=null){
                                a =a||(c.accountnumber.equals(str));
                          System.out.println(a);
                        }
                    }
                          
                            for(ArrayList<String> as2:thirtime)
                    for(String str2:as2){
                
                        if(c!=null){
                            a =a||(c.accountnumber.equals(str));
                          System.out.println(a);
                        }
                    }  
                            
                    for(ArrayList<String> as3:fourtime)
                    for(String str3:as3){
                       
                        if(c!=null){
                                a =a||(c.accountnumber.equals(str));
                          System.out.println(a);
                        }
                    }  
                        
                      for(ArrayList<String> as4:fiftime)
                    for(String str4:as4){
                       
                        if(c!=null){
                             a =a||(c.accountnumber.equals(str));
                          System.out.println(a);
                        }
                    } 
                          
                    }
                     System.out.println("END");
                  
                 }*/
    }    
   
    private void findtran(){
        sumggler=smuggler();
                   smgAccount=smgAccount();
  
                m= CsvReader.CsvtranReader(CsvReader.path+"transactions"+".csv","Transaction");
      
              for(BankAccount Ba:smgAccount){
                  if(m.get(Ba.accountnumber)!=null)
              firstime.add(m.get(Ba.accountnumber));
              }

              for(ArrayList<String> ar:firstime){
                  for(String st:ar){
                      
                  if(m.get(st)!=null)
                  {
                  for(String str:m.get(st)){
                      if(m.get(str)!=null)
                  secontime.add(m.get(str));   
              }  
              }
              }
              }
           
                  
                  for(ArrayList<String> ar:secontime){
                  for(String st:ar){
                          if(m.get(st)!=null){
                         thirtime.add(m.get(st));
                              
                  }
                  }
                  }
             
                 
                    for(ArrayList<String> ar:thirtime){
                  for(String st:ar){
                      
                  if(m.get(st)!=null)
                  {
                  fourtime.add(m.get(st));   
              }  
              }
              }
              
                     
                          for(ArrayList<String> ar:fourtime){
                  for(String st:ar){
                      
                  if(m.get(st)!=null)
                  {
      
                  fiftime.add(m.get(st));   
              }  
              }
              }

    }
    
    private LinkedList<Person> smuggler(){
             if(EventHandlerImpl.getPeople()==null)
          EventHandlerImpl.setPeople((HashMap)CsvReader.
                  CsvNodeReader(CsvReader.path+"Person"+".csv","Person"));

             
     
       LinkedList<Person> re=new LinkedList<>();
       Collection<Person> col=EventHandlerImpl.getPeople().values();
       for(Person p:col){
        if((p.workplace.contains("قاچاق"))){
            re.add(p);
        }
       }
 
       return re;
   }  
    
   private LinkedList<BankAccount> smgAccount() {
      LinkedList<BankAccount> re=new LinkedList<>();
      int a=0;
       if(EventHandlerImpl.getBankAccount()==null)
          EventHandlerImpl.setBankAccount((HashMap)CsvReader.
                  CsvNodeReader(CsvReader.path+"BankAccount"+".csv","BankAccount"));
      
      for(Person p:FXMLDocumentController.sumggler){
         // System.out.println(p.nationalcode);
         if(EventHandlerImpl.getBankAccount().get(p.nationalcode)!=null){
      re.add(EventHandlerImpl.getBankAccount().get(p.nationalcode));a++;}
      }
      // System.out.println("a: "+a);
      return re;
   }
   
   private HashMap<String, BankAccount> getBankac(){
  if(EventHandlerImpl.getBankAccount()==null){
          EventHandlerImpl.setBankAccount((HashMap)CsvReader.
                  CsvNodeReader("E:\\data\\"+"BankAccount"+".csv","BankAccount"));
          //this.PhoneNumber=EventHandlerImpl.getPhoneNumber();
             }
  return EventHandlerImpl.getBankAccount();
    }

    public static LinkedList<Person> getSuspected() {
        return Suspected;
    }
}