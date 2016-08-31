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

    public Peli() {
        this.pelipakka = new Pelipakka();
        this.pelikierros = new Pelikierros(pelipakka);
        this.taysiPakka = new ArrayList<Sanapari>();
    }

    
    public void pelaa(Kentta kentta, Container container) {
        
        while (pelipakka.eiTyhja()) {
            Sanapari sp = pelikierros.annaSanapari();
            kentta.asetaPelikentta(sp, container, this);
        }
    }
    
    
    
}
