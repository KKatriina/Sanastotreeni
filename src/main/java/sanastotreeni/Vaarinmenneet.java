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
public class Vaarinmenneet {
    private ArrayList<Sanapari> lista;
    
    public Vaarinmenneet() {
        this.lista = new ArrayList<Sanapari>();
    }
    
    public boolean eiTyhja() {
        if (lista.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void lisaaSanapari(Sanapari sp) {
        lista.add(sp);
    }
    
    public void poista(Sanapari sp) {
        if (lista.contains(sp)) {
            lista.remove(sp);
        }
    }
    
    public ArrayList<Sanapari> getLista() {
        return this.lista;
    }
}
