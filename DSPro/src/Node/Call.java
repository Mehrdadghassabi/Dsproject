/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;

import java.util.*;

/**
 *
 * @author mohse
 */
public class Call extends Edge<PhoneNumber, PhoneNumber> {
    public Call (String sfrom,String sto,String callNomber, String callDate, String callTime){
        
        this.callNomber=callNomber;
        this.key=callNomber;
        this.callDate=callDate;
        this.callTime=callTime;
        this.sfrom=sfrom;
        this.sto=sto;
        
    }
    
    public String callNomber;
    public String callDate;
    public String callTime;
    public String sfrom;
    public String sto;
    
    @Override
    public String toString (){
        return "شماره تماس: "+callNomber+" تاریخ تماس: "+callDate+" مدت زمان تماس: "+callTime+"\n";
    }
}
