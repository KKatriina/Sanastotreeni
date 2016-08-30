/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

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
    
    public Kayttoliittyma() {
        
    }
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2,3);
        container.setLayout(layout);
        
        JLabel viesti = new JLabel();
        JLabel sana1 = new JLabel("Sana1");
        JTextArea sana2 = new JTextArea();
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new NappaimistonKuuntelija(sana1, sana2));
        
        container.add(viesti);
        container.add(sana1);
        container.add(sana2);
        container.add(nappi);
        
    }

    @Override
    public void run() {
        frame = new JFrame("Sanastotreeni");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
}
