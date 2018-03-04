/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Eray
 */
public class Graph {
    
    private Set<Sehir> nodes = new HashSet<>();

    public Set<Sehir> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Sehir> nodes) {
        this.nodes = nodes;
    }
     
    public void addNode(Sehir nodeA) {
        nodes.add(nodeA);
    }
    
    public List<Sehir> getShortestPath(Sehir target){
        Iterator itr = getNodes().iterator();
        
        while(itr.hasNext()){
            Sehir shr = (Sehir) itr.next();
            if(shr.plaka == target.plaka)
                return shr.getShortestPath();
        }
        
        return null;
    }
    
    public Sehir getSehirWithPlaka(int plaka){
        Iterator itr = getNodes().iterator();
        while(itr.hasNext()){
            Sehir shr = (Sehir) itr.next();
            if(shr.getPlaka() == plaka){
                return shr;
            }
        }
        
        return null;
    }
}
