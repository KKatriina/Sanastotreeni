/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;
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
        this.pelipakka = new ArrayList<Sanapari>();
        this.vaarinmenneet = new ArrayList<Sanapari>();
        this.kysytaanVaarinmenneita = false;
    }
    
    //onks tämä pelikierroksen tehtävä?
    //public void pelaa() {
    //    while (pelipakka.eiTyhja()) {
    //        annaSanapari();
    //    }
    //    pelipakka.esittele();
    //}
    
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
            return annaVaarinmennyt();
        } else {
            Random random = new Random();
            int i = random.nextInt(pelipakka.size());
            return pelipakka.get(i);
        }
    }
    
    public Sanapari annaVaarinmennyt() {
        //tässä liikaa toistoa
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
        if (this.pelipakka.isEmpty() && this.vaarinmenneet.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    
//    //tän joko siirtää väärinmennyt-luokalle tai poistaa koko luokan
//    public Sanapari naytaVaarinmennyt() {
//        System.out.println("Ollaan väärinmenneissä!");
//        ArrayList<Sanapari> poistettavat = new ArrayList<Sanapari>();
//        if (vaarinmenneet.eiTyhja()) {
//            for (int i = 0; i < vaarinmenneet.getLista().size(); i++) {
//                kysyVaarinmennytta(vaarinmenneet.getLista().get(i), poistettavat);
//            }
//        }
//        for (int i = 0; i < poistettavat.size(); i++) {
//            Sanapari sp = poistettavat.get(i);
//            vaarinmenneet.poista(sp);
//        }
//        
//        //POISTA TÄÄ KUN VOIT
//        return null;
//        
//    }
//    
//    public void kysyArvottua(Sanapari sp) {
//        if (kysyja.oikein(sp)) {
//            sp.oikein();
//            if (sp.poistetaan()){
//                pelipakka.poistaSanapari(sp);
//            }
//        } else {
//            sp.vaarin();
//            vaarinmenneet.lisaaSanapari(sp);
//            pelipakka.poistaSanapari(sp);
//        }
//    }
//    
//    public void kysyVaarinmennytta(Sanapari sp, ArrayList<Sanapari> poistettavat) {
//        if (kysyja.oikein(sp)) {
//            poistettavat.add(sp);
//            pelipakka.lisaaSanapari(sp);
//        }
//    }

    public void lisaaSanapari(Sanapari sanapari) {
        this.pelipakka.add(sanapari);
    }
    
}
