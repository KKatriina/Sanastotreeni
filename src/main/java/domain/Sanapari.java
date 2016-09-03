/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Katriina
 */
public class Sanapari {
    private String sana1;
    private String sana2;
    private int painokerroin;
    private boolean virheellinen;
    
    public Sanapari(String s1, String s2) {
        this.sana1 = s1;
        this.sana2 = s2;
        this.painokerroin = 2;
        this.virheellinen = false;
    }
    
    public String getSana1() {
        return this.sana1;
    }
    
    public String getSana2() {
        return this.sana2;
    }
    
    public void vaarin() {
        painokerroin++;
        virheellinen = true;
    }
    
    public void oikein() {
        this.painokerroin--;
    }
    
    public boolean poistetaan() {
        return this.painokerroin < 1;
    }
    
    public boolean virheellinen() {
        return virheellinen;
    }
    
    @Override
    public String toString() {
        return sana1 + " = " + sana2;
    }
}
