/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Katriina
 */
public class NappaimistonKuuntelija implements ActionListener {
    private JLabel sana1;
    private JTextArea sana2;
    
    public NappaimistonKuuntelija(JLabel sana1, JTextArea sana2) {
        this.sana1 = sana1;
        this.sana2 = sana2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sana1.getText().equals(sana2.getText())) {
            System.out.print("Oikein!");
        } else {
            System.out.print("Väärin!");
        }
    }
    
}
