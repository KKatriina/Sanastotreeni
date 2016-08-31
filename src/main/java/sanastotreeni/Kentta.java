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
    
    
    public Kentta() {
        this.kentta = new JPanel();
    }
    
    
    
    public void asetaPelikentta(Sanapari sp, Container container, Peli peli) {
        //container.remove(kentta);
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(2, 2);
        kentta.setLayout(layout);
        
        JLabel viesti = new JLabel("Käännä annettu sana!");
        JLabel sana1 = new JLabel(sp.getSana1());
        JTextArea sana2 = new JTextArea();
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new NappaimistonKuuntelija(sana2, sp.getSana2(), peli));
        
        kentta.add(viesti);
        kentta.add(nappi);
        kentta.add(sana1);
        kentta.add(sana2);
        
        container.add(kentta, BorderLayout.NORTH);
    }
}
