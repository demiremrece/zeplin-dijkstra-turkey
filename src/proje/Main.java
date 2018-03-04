/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eray
 */
public class Main {
        public static void main(String[] args) throws IOException {
            ArrayList<Sehir> sehirler = Helpers.sehirleriOku("/Users/apple/Desktop/ZeplinProje/src/proje/latlong.txt", "/Users/apple/Desktop/ZeplinProje/src/proje/komsuluklar.txt");
            Zeplin zeplin = new Zeplin();
            zeplin.setYolcuSayisi(30);
            zeplin.haritayiOlustur(sehirler);
            
            Graph zepGraph = zeplin.getZepGraph();
            Sehir adana = zepGraph.getSehirWithPlaka(34);
            
            DijkstraAlgorithm.calculateShortestPathFromSource(adana);
            
            
            Sehir denizli = zepGraph.getSehirWithPlaka(1);
            List<Sehir> shortestToDenizli = zepGraph.getShortestPath(denizli);
            
            
            for (int i = 0; i < shortestToDenizli.size(); i++) {
                System.out.println(shortestToDenizli.get(i).plaka);
            }
            System.out.println();
            
            
            
        }

}
