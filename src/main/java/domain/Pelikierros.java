/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.*;

/**
 *
 * @author Katriina
 */
public class Pelikierros {
    private int valikierroksia;
    private int indeksi;
    private ArrayList<Sanapari> pelipakka;
    private ArrayList<Sanapari> vaarinmenneet;
    private boolean kysytaanVaarinmenneita;
    
    public Pelikierros() {
        this.valikierroksia = 0;
        this.indeksi = 0;
        this.pelipakka = new ArrayList<>();
        this.vaarinmenneet = new ArrayList<>();
        this.kysytaanVaarinmenneita = false;
    }
    
    public Sanapari annaSanapari() {
        if (this.valikierroksia == 0 || this.valikierroksia%3 != 0) {
            this.valikierroksia++;
            return this.arvoSanapari();
        } else {
            this.valikierroksia = 0;
            this.kysytaanVaarinmenneita = true;
            return this.annaVaarinmennyt();
        }
    }
    
    public Sanapari arvoSanapari() {
        if (this.pelipakka.isEmpty()) {
            this.indeksi = 0;
            return annaVaarinmennyt();
        } else {
            this.kysytaanVaarinmenneita = false;
            Random random = new Random();
            int i = random.nextInt(pelipakka.size());
            System.out.println("Annetaan pelipakasta:");
            System.out.println("vaarinmennyt: " + kysytaanVaarinmenneita);
            System.out.println("sanapari: " + this.pelipakka.get(i).toString());
            return pelipakka.get(i);
        }
    }
    
    public Sanapari annaVaarinmennyt() {
        if (this.vaarinmenneet.isEmpty()) {
            this.valikierroksia++;
            this.kysytaanVaarinmenneita = false;
            return arvoSanapari();
        } else if (this.indeksi >= this.vaarinmenneet.size()) {
            this.indeksi = 0;
            this.valikierroksia++;
            this.kysytaanVaarinmenneita = false;
            return arvoSanapari();
        } else {
            System.out.println("annetaan väärinmennyt indeksista " + indeksi);
            System.out.println("vaarinmennyt: " + kysytaanVaarinmenneita);
            System.out.println("sanapari :" + this.vaarinmenneet.get(indeksi).toString());
            return this.vaarinmenneet.get(indeksi);
        }
    }
    
    public void sanaOikein(Sanapari sanapari) {
        if (kysytaanVaarinmenneita) {
            this.vaarinmenneet.remove(indeksi);
        } else {
            sanapari.oikein();
            if (sanapari.poistetaan()) {
                pelipakka.remove(sanapari);
            }
            valikierroksia++;
        }
    }
    
    public void sanaVaarin(Sanapari sanapari) {
        if (kysytaanVaarinmenneita) {
            indeksi++;
        } else {
            sanapari.vaarin();
            pelipakka.remove(sanapari);
            vaarinmenneet.add(sanapari);
            valikierroksia++;
        }
    }
    
    public boolean pakkaTyhja() {
        return this.pelipakka.isEmpty() && this.vaarinmenneet.isEmpty();
    }

    public void lisaaSanapari(Sanapari sanapari) {
        this.pelipakka.add(sanapari);
    }
    
}
