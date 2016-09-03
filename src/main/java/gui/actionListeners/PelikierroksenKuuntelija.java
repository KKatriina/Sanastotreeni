/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import domain.Peli;
import domain.Sanapari;

/**
 *
 * @author Katriina
 */
public class PelikierroksenKuuntelija implements ActionListener {
    private JTextArea sana2;
    private Sanapari sanapari;
    private Peli peli;
    
    public PelikierroksenKuuntelija(JTextArea sana2, Sanapari sanapari, Peli peli) {
        this.sana2 = sana2;
        this.sanapari = sanapari;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sana2.getText().equals(sanapari.getSana2())) {
            peli.sanaOikein(this.sanapari);
        } else {
            peli.sanaVaarin(this.sanapari);
        }
    }
    
}
