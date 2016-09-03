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
public class Pelipakka {
    private ArrayList<Sanapari> pelipakka;
    
    public Pelipakka() {
        this.pelipakka = new ArrayList<Sanapari>();
    }
    
    public void lisaaSanapari(Sanapari sp) {
        this.pelipakka.add(sp);
    }
    
    public boolean eiTyhja() {
        return !pelipakka.isEmpty();
    }
    
    public void poistaSanapari(Sanapari sp) {
        if (this.pelipakka.contains(sp)) {
            this.pelipakka.remove(sp);
        }
    }
    
    public ArrayList<Sanapari> getPakka() {
        return this.pelipakka;
    }
    
    
    //öh - tämä ei voi olla pelipakan tehtävä
    //mutta treenivaiheessa
    public void esittele() {
        
    }
}
