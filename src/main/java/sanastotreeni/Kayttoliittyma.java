/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Katriina
 */
public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private Kentta kentta;
    private Peli peli;
    
    public Kayttoliittyma() {
        this.peli = new Peli();
        this.kentta = null;
    }
    
    public void luoKomponentit(Container container) {
        container.add(kentta);
    }

    @Override
    public void run() {
        frame = new JFrame("Sanastotreeni");
        frame.setPreferredSize(new Dimension(600, 250));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.kentta = new Kentta(frame.getContentPane(), peli);
        this.peli.setKentta(kentta);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
        this.peli.aloita("");
    }
    
}
