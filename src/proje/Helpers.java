/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Emre
 */
public class Helpers {
    
    public static ArrayList<Sehir> sehirleriOku(String kordinatUrl, String komsulukUrl) throws FileNotFoundException, IOException{
        ArrayList<Sehir> sehirler = new ArrayList();
        
             //Lat long bilgisi okuma başlama
            FileReader fileReader = new FileReader(kordinatUrl);
            String line;
            BufferedReader br = new BufferedReader(fileReader);

            while ((line = br.readLine()) != null) 
            {
                Sehir shr = new Sehir();
                String[] dizi = line.split(",");
                shr.lat_=Float.parseFloat(dizi[0]);
                shr.long_=Float.parseFloat(dizi[1]);
                shr.plaka=Integer.parseInt(dizi[2]);
                shr.rakim=Integer.parseInt(dizi[3]);
                
                sehirler.add(shr);
            }
            br.close();
            
             //Komşuluklar okuma
            FileReader fileReader2 = new FileReader(komsulukUrl);
            BufferedReader br2 = new BufferedReader(fileReader2);
            int i = 0;
            while ((line = br2.readLine()) != null) 
            {   
                String[] dizi = line.split(",");
                for (int j = 1; j < dizi.length; j++) {
                    sehirler.get(Integer.parseInt(dizi[0])-1).komsular.add(sehirler.get(Integer.parseInt(dizi[j])-1));                    
                }
                i++;
            }
            br.close();
        
        return sehirler;
        
    }
    
    public static double ikiSehirArasiUzakligiBul(Sehir s1, Sehir s2){
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(s2.getLat_() - s1.getLat_());
        double lonDistance = Math.toRadians(s2.getLong_() - s1.getLong_());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)+ Math.cos(Math.toRadians(s1.getLat_())) * 
            Math.cos(Math.toRadians(s2.getLat_()))* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R*c; 
        return distance;
    }
}
