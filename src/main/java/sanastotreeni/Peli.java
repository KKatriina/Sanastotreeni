/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Katriina
 */
class Peli {
    private Pelikierros pelikierros;
    private ArrayList<Sanapari> taysiPakka;
    private Kentta kentta;
    private Tekstinkasittelija tk;

    public Peli() {
        this.pelikierros = new Pelikierros();
        this.taysiPakka = new ArrayList<Sanapari>();
        this.kentta = null;
        this.tk = new Tekstinkasittelija();
    }
    
    public void setKentta(Kentta kentta) {
        this.kentta = kentta;
    }
    
    public void aloita(String palaute) {
        kentta.asetaAloitusKentta(palaute);
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
        taysiPakka.add(sanapari);
        pelikierros.lisaaSanapari(sanapari);
    }

    public void valitaanTallennettu() {
        if (tk.tiedostoTyhja()) {
            aloita("Sanastoa ei ole tallennettu");
        } else {
            System.out.println("valitaan tallennettu");
            taysiPakka = tk.lueSanasto();
            for (int i = 0; i < taysiPakka.size(); i++) {
                pelikierros.lisaaSanapari(taysiPakka.get(i));
                System.out.println(taysiPakka.get(i).toString());
            }
            pelaa("Aloitetaan peli!");
        }
    }

    public void kysyTallentamista() {
        kentta.kysyTallentamista();
    }

    public void tallenna() throws IOException {
        tk.tallenna(taysiPakka);
        pelaa("Sanasto tallennettu!");
    }
    

    
    
    
}
