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
    private JTextArea sana2;
    private String verrattava;
    private Peli peli;
    
    public NappaimistonKuuntelija(JTextArea sana2, String verrattava, Peli peli) {
        this.sana2 = sana2;
        this.verrattava = verrattava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sana2.getText().equals(verrattava)) {
            System.out.print("Oikein!");
        } else {
            System.out.print("Väärin!");
        }
    }
    
}
