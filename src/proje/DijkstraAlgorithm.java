/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Eray
 */
public class DijkstraAlgorithm {
    
    public static void calculateShortestPathFromSource(Sehir source) {
    source.setDistance(0);
 
    // ziyaret edilmis yerler
    Set<Sehir> settledNodes = new HashSet<>();
    // ziyaret edilmemis yerler
    Set<Sehir> unsettledNodes = new HashSet<>();
    
    unsettledNodes.add(source);
 
    while (!unsettledNodes.isEmpty()) {
        // ziyaret edilmemislerden en dusuk uzaklikta olani al
        Sehir currentNode = getLowestDistanceNode(unsettledNodes);
        
        // ziyaret edilmemisler dizisinden cikar
        unsettledNodes.remove(currentNode);
        
        for (Sehir komsu: currentNode.getKomsular()) {         
            double edgeWeight = Helpers.ikiSehirArasiUzakligiBul(currentNode, komsu);
            if (!settledNodes.contains(komsu)) {
                calculateMinimumDistance(komsu, edgeWeight, currentNode);
                unsettledNodes.add(komsu);
            }
        }
        settledNodes.add(currentNode);
    }
}
    
    private static Sehir getLowestDistanceNode(Set < Sehir > unsettledNodes) {
        Sehir lowestDistanceNode = null;
        double lowestDistance = Double.MAX_VALUE;
        for (Sehir node: unsettledNodes) {
            double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    
    private static void calculateMinimumDistance(Sehir evaluationNode,Double edgeWeigh, Sehir sourceNode) {
        Double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Sehir> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
