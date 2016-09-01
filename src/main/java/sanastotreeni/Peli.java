/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.Container;
import java.util.ArrayList;

/**
 *
 * @author Katriina
 */
class Peli {
    private Pelikierros pelikierros;
    private ArrayList<Sanapari> taysiPakka;
    private Kentta kentta;

    public Peli() {
        this.pelikierros = new Pelikierros();
        this.taysiPakka = new ArrayList<Sanapari>();
        this.kentta = null;
    }
    
    public void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }

    
    public void aloitaPeli() {
        kentta.asetaAloitusKentta();
    }
    
    public void pelaa() {
        if (pelikierros.pakkaTyhja()) {
            lopetaPeli();
        } else {                 
            Sanapari sp = pelikierros.annaSanapari();
            System.out.println("sanapari annettu");
            kentta.asetaPelikentta(sp);
        }
    }
    
    public void sanaOikein(Sanapari sanapari) {
        pelikierros.sanaOikein(sanapari);
        System.out.println("Oikein!");
        pelaa();
    }
    
    public void sanaVaarin(Sanapari sanapari) {
        pelikierros.sanaOikein(sanapari);
        System.out.println("Väärin!");
        pelaa();
    }
    
    public void lopetaPeli() {
        System.out.println("Se on loppu ny!");
    }
    
    public void lisaaSanapari(Sanapari sanapari) {
        this.taysiPakka.add(sanapari);
        this.pelikierros.lisaaSanapari(sanapari);
    }
    

    
    
    
}
