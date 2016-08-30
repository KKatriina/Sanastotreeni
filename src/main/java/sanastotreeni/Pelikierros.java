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
    private Pelipakka pelipakka;
    private Vaarinmenneet vaarinmenneet;
    private Kysyja kysyja;
    
    public Pelikierros(Pelipakka pelipakka) {
        this.valikierroksia = 0;
        this.pelipakka = pelipakka;
        this.vaarinmenneet = new Vaarinmenneet();
        this.kysyja = new Kysyja();
    }
    
    public void pelaa() {
        while (pelipakka.eiTyhja()) {
            naytaSanapari();
        }
        pelipakka.esittele();
    }
    
    public void naytaSanapari() {
        if (this.valikierroksia%4 != 0) {
            this.valikierroksia++;
            this.arvoSanapari();
        } else {
            this.valikierroksia = 0;
            this.naytaVaarinmennyt();
        }
    }
    
    //tän voi varmaan tehdä pelipakassa
    public void arvoSanapari() {
        Random random = new Random();
        int i = random.nextInt(pelipakka.getPakka().size());
        int j = 0;
        Sanapari sp = null;
        for (Object obj : pelipakka.getPakka()) {
            if (i == j) {
                sp = (Sanapari) obj;
            }
            j++;
        }
        kysyArvottua(sp);
    }
    
    
    //tän joko siirtää väärinmennyt-luokalle tai poistaa koko luokan
    public void naytaVaarinmennyt() {
        ArrayList<Sanapari> poistettavat = new ArrayList<Sanapari>();
        if (vaarinmenneet.eiTyhja()) {
            for (int i = 0; i < vaarinmenneet.getLista().size(); i++) {
                kysyVaarinmennytta(vaarinmenneet.getLista().get(i), poistettavat);
            }
        }
        for (int i = 0; i < poistettavat.size(); i++) {
            Sanapari sp = poistettavat.get(i);
            vaarinmenneet.poista(sp);
        }
        
    }
    
    public void kysyArvottua(Sanapari sp) {
        if (kysyja.oikein(sp)) {
            sp.oikein();
            if (sp.poistetaan()){
                pelipakka.poistaSanapari(sp);
            }
        } else {
            sp.vaarin();
            vaarinmenneet.lisaaSanapari(sp);
            pelipakka.poistaSanapari(sp);
        }
    }
    
    public void kysyVaarinmennytta(Sanapari sp, ArrayList<Sanapari> poistettavat) {
        if (kysyja.oikein(sp)) {
            poistettavat.add(sp);
            pelipakka.lisaaSanapari(sp);
        }
    }
    
}
