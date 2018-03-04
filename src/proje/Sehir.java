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
public class Sehir extends Node {
    
    double lat_;
    double long_;
    int rakim;
    int plaka;
    ArrayList<Sehir> komsular = new ArrayList();

    public ArrayList<Sehir> getKomsular() {
        return komsular;
    }

    public void setKomsular(ArrayList<Sehir> komsular) {
        this.komsular = komsular;
    }

    public double getLat_() {
        return lat_;
    }

    public void setLat_(double lat_) {
        this.lat_ = lat_;
    }

    public double getLong_() {
        return long_;
    }

    public void setLong_(double long_) {
        this.long_ = long_;
    }

    public int getRakim() {
        return rakim;
    }

    public void setRakim(int rakim) {
        this.rakim = rakim;
    }

    public int getPlaka() {
        return plaka;
    }

    public void setPlaka(int plaka) {
        this.plaka = plaka;
    }
    
}
