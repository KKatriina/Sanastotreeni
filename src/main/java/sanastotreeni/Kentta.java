/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Katriina
 */
public class Kentta extends JPanel {
    private JPanel kentta;
    private Container container;
    private Peli peli;
    
    
    public Kentta(Container container, Peli peli) {
        this.kentta = new JPanel();
        this.container = container;
        this.peli = peli;
    }
    
    public void asetaAloitusKentta() {
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(3,2);
        kentta.setLayout(layout);
        
        JLabel viesti1 = new JLabel("Sana:");
        JLabel viesti2 = new JLabel("Käännös:");
        JTextArea sana1 = new JTextArea();
        JTextArea sana2 = new JTextArea();
        JButton nappi1 = new JButton("Lisää sanapari");
        JButton nappi2 = new JButton("Kaikki sanat lisätty!");

        nappi1.addActionListener(new LisayksenKuuntelija(sana1, sana2, peli));
        nappi2.addActionListener(new AloituksestaPoistumisenKuuntelija(peli));        
        
        kentta.add(viesti1);
        kentta.add(viesti2);
        kentta.add(sana1);
        kentta.add(sana2);
        kentta.add(nappi1);
        kentta.add(nappi2);
        
        container.add(kentta, BorderLayout.NORTH);
    }
    
    public void asetaPelikentta(Sanapari sp) {
        container.removeAll();
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(2, 2);
        kentta.setLayout(layout);
        
        JLabel viesti = new JLabel("Käännä annettu sana!");
        JLabel sana1 = new JLabel(sp.getSana1());
        JTextArea sana2 = new JTextArea();
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new PelikierroksenKuuntelija(sana2, sp.getSana2(), peli));
        
        kentta.add(viesti);
        kentta.add(nappi);
        kentta.add(sana1);
        kentta.add(sana2);
        
        container.add(kentta, BorderLayout.NORTH);
    }
}
