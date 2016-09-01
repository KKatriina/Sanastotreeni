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
    private Pelipakka pelipakka;
    private ArrayList<Sanapari> taysiPakka;
    private Kentta kentta;

    public Peli() {
        this.pelipakka = new Pelipakka();
        this.pelikierros = new Pelikierros(pelipakka);
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
        Sanapari sp = pelikierros.annaSanapari();
        kentta.asetaPelikentta(sp);
    }
    
    public Pelipakka getPakka() {
        return this.pelipakka;
    }
    
    
    
}
