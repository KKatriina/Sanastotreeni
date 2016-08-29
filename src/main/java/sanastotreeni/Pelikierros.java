/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

/**
 *
 * @author Katriina
 */
public class Pelikierros {
    private int valikierroksia;
    private Pelipakka pelipakka;
    private Vaarinmenneet vaarinmenneet;
    
    public Pelikierros(Pelipakka pelipakka) {
        this.valikierroksia = 0;
        this.pelipakka = pelipakka;
        this.vaarinmenneet = new Vaarinmenneet();
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
    
    public void arvoSanapari() {
        
    }
    
    public void naytaVaarinmennyt() {
        
    }
    
}
