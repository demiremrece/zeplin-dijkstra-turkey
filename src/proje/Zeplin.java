/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.util.ArrayList;

/**
 *
 * @author Eray
 */
public class Zeplin {
    
    private int yolcuSayisi,maxYolcu = 50, minYolcu = 5, maxYukseklik = 50;
    private double maxEgim;
    
    private Graph zepGraph;

    public int getMaxYukseklik() {
        return maxYukseklik;
    }

    public void setMaxYukseklik(int maxYukseklik) {
        this.maxYukseklik = maxYukseklik;
    }

    public Graph getZepGraph() {
        return zepGraph;
    }

    public void setZepGraph(Graph zepGraph) {
        this.zepGraph = zepGraph;
    }
    
    public void haritayiOlustur(ArrayList<Sehir> sehirler){
        Graph graph = new Graph();

        for(Sehir sehir : sehirler){
            for(Sehir komsu : sehir.getKomsular()){
                if(!gidilebilirMi(sehir,komsu))
                {
                    sehir.komsular.remove(komsu);
                }
            }
            graph.addNode(sehir);   
        }
        
        setZepGraph(graph);
    }

    
    public boolean gidilebilirMi(Sehir s1, Sehir s2){
        double uzaklik = Helpers.ikiSehirArasiUzakligiBul(s1, s2);
        int rakimFarki = Math.abs(s1.getRakim() - s2.getRakim());
        double egim = Math.atan( (rakimFarki + maxYukseklik ) / uzaklik);
        
        return egim <= getMaxEgim();
    }
    
    public int getYolcuSayisi() {
        return yolcuSayisi;
    }

    public void setYolcuSayisi(int yolcuSayisi) {
        this.yolcuSayisi = yolcuSayisi;
    }

    public int getMaxYolcu() {
        return maxYolcu;
    }

    public void setMaxYolcu(int maxYolcu) {
        this.maxYolcu = maxYolcu;
    }

    public int getMinYolcu() {
        return minYolcu;
    }

    public void setMinYolcu(int minYolcu) {
        this.minYolcu = minYolcu;
    }

    public double getMaxEgim() {
        
        return 80 - getYolcuSayisi();
    }
    
}
