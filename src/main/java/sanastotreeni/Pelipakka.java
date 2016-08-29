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
public class Pelipakka {
    private HashSet pelipakka;
    
    public Pelipakka() {
        this.pelipakka = new HashSet();
    }
    
    public void lisaaSanapari(Sanapari sp) {
        this.pelipakka.add(sp);
    }
    
    public void poistaSanapari(Sanapari sp) {
        if (this.pelipakka.contains(sp)) {
            this.pelipakka.remove(sp);
        }
    }
}