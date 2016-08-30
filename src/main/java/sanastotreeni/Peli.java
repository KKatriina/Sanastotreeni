/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.util.ArrayList;

/**
 *
 * @author Katriina
 */
class Peli implements Runnable {
    private Pelikierros pelikierros;
    private Pelipakka pelipakka;
    private ArrayList<Sanapari> taysiPakka;

    public Peli() {
        this.pelipakka = new Pelipakka();
        this.pelikierros = new Pelikierros(pelipakka);
        this.taysiPakka = new ArrayList<Sanapari>();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
