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

    
    public void aloita() {
        kentta.asetaAloitusKentta();
    }
    
    public void aloitaLisaaminen() {
        kentta.asetaLisaysKentta();
    }
    
    public void pelaa(String palaute) {
        if (pelikierros.pakkaTyhja()) {
            lopetaPeli();
        } else {                 
            Sanapari sp = pelikierros.annaSanapari();
            kentta.asetaPelikentta(sp, palaute);
        }
    }
    
    public void sanaOikein(Sanapari sanapari) {
        pelikierros.sanaOikein(sanapari);
        pelaa("Oikein meni!");
    }
    
    public void sanaVaarin(Sanapari sanapari) {
        pelikierros.sanaVaarin(sanapari);
        pelaa("Oikea vastaus: " + sanapari.getSana1()+ " = " + sanapari.getSana2());
    }
    
    public void lopetaPeli() {
        kentta.asetaLoppuKentta(taysiPakka);
    }
    
    public void lisaaSanapari(Sanapari sanapari) {
        this.taysiPakka.add(sanapari);
        this.pelikierros.lisaaSanapari(sanapari);
    }
    

    
    
    
}
