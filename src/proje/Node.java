/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eray
 */
public class Node {
    
    private List<Sehir> shortestPath = new LinkedList<>();
    private double distance = Double.MAX_VALUE;


    public void setShortestPath(List<Sehir> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Sehir> getShortestPath() {
        return shortestPath;
    }
    public double getDistance() {
        return distance;
    }

    public void setDistance(double dist){
        this.distance = dist;
    }
    
}
