/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import domain.Sanapari;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Katriina
 */
public class Tekstinkasittelija {
    
    public Tekstinkasittelija() {
    }
    
    public void tallenna(ArrayList<Sanapari> pakka) throws IOException {
        FileWriter kirjoittaja = new FileWriter("tiedosto.txt", false);
        for (int i = 0; i < pakka.size(); i++) {
            Sanapari sp = pakka.get(i);
            kirjoittaja.write(sp.getSana1() + "=" + sp.getSana2() + "\n");
        }
        kirjoittaja.close();
    }
    
    public ArrayList<Sanapari> lueSanasto() { 
        File sanasto = new File("tiedosto.txt");
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(sanasto);
        } catch (Exception e) {
            System.out.println("Tiedostoa ei voi lukea");
        }
        
        ArrayList<Sanapari> pakka = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String rivi = scanner.nextLine();
            String[] sanat = rivi.split("=");
            Sanapari sanapari = new Sanapari(sanat[0], sanat[1]);
            pakka.add(sanapari);
        }
        
        return pakka;
    }
    
    public boolean tiedostoTyhja() {
        File sanasto = new File("tiedosto.txt");
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(sanasto);
        } catch (Exception e) {
            System.out.println("Tiedostoa ei voi lukea");
        }
        
        String koe = "";
        while (scanner.hasNextLine()) {
            koe = koe + scanner.nextLine();
        }
        return koe.isEmpty();
    }
}
