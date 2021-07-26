/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;

/**
 *
 * @author mohse
 * @param <T1>
 * @param <T2>
 */
abstract public class Edge <T1,T2> {
    T1 from;
    T2 to;
    protected String key;
    public void keySetter(String key){
        this.key=key;
        
    }
    public String keyGetter (){
        return this.key;
    }
    
}
 