

package Node;

import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author mohse
 */
abstract public class Node {

    /**
     *
     */
    protected String key;
    protected Map<String, Edge> from_Edges = new HashMap<>();    
    protected Map<String, Edge> to_Edges = new HashMap<>();    
    public void keySetter(String key){
        this.key=key;
        
    }
    public String keyGetter (){
        return this.key;
    }
    public void setFrom_Edges (Map<String, Edge> from_Edges){
        this.from_Edges=from_Edges;
        
    }
    public Map<String, Edge> getFrom_Edges (){
        return this.from_Edges;
    }    
    public void setTo_Edges (Map<String, Edge> to_Edges){
        this.to_Edges=to_Edges;
        
    }
    public Map<String, Edge> getTo_Edges (){
        return this.to_Edges;
    }    
    
}
