/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Katriina
 */
public class Kentta extends JPanel {
    private Container container;
    
    
    public Kentta(Container container) {
        this.container = container;
    }
    
    
    
    public void asetaPelikentta(String s1, String verrattava) {
        GridLayout layout = new GridLayout(2,3);
        container.setLayout(layout);
        
        JLabel viesti = new JLabel("Käännä annettu sana!");
        JLabel sana1 = new JLabel(s1);
        JTextArea sana2 = new JTextArea();
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new NappaimistonKuuntelija(sana2, verrattava));
        
        container.add(viesti);
        container.add(sana1);
        container.add(sana2);
        container.add(nappi);
    }
}
