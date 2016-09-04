/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import domain.Peli;
import domain.Sanapari;

/**
 *
 * @author Katriina
 */
public class PelinAloittamisenKuuntelija implements ActionListener {
    private Peli peli;
    private ArrayList<Sanapari> taysiPakka;

    public PelinAloittamisenKuuntelija(Peli peli, ArrayList<Sanapari> taysiPakka) {
        this.peli = peli;
        this.taysiPakka = taysiPakka;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (taysiPakka == null) {
            peli.pelaa("Aloitetaan pelaaminen!");
        } else {
            peli.aloitaUusiKierros(taysiPakka);
        }
    }
    
}
