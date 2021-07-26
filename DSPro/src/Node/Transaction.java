/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Node;


/**
 *
 * @author mohse
 */
public class Transaction extends Edge<BankAccount, BankAccount> {
    
    public Transaction(String sfrom,String sto, String transactionNumber,String transactionTime, String amountOfTransaction){
        this.transactionTime=transactionTime;
        this.transactionNumber=transactionNumber;
        this.key=sfrom;
        this.amountOfTransaction=amountOfTransaction;
        this.sfrom=sfrom;
        this.sto=sto;
    }
    
    public String transactionTime;
    public String transactionNumber;
    public String amountOfTransaction;
    public String sfrom;
    public String sto;
    
    
    @Override
    public String toString (){
         return "از:"+sfrom+" به : "+sto+" زمان تراکنش: "+transactionTime+" شماره تراکنش: "+
                 transactionNumber+"مقدار تراکنش: "+amountOfTransaction+"\n"; 
    }
}
