/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import domain.Peli;
import domain.Sanapari;
import javax.swing.JLabel;

/**
 *
 * @author Katriina
 */
public class LisayksenKuuntelija implements ActionListener {
    private JTextArea sana1;
    private JTextArea sana2;
    private JLabel palautekentta;
    private Peli peli;

    public LisayksenKuuntelija(JTextArea sana1, JTextArea sana2, JLabel palautekentta, Peli peli) {
        this.sana1 = sana1;
        this.sana2 = sana2;
        this.palautekentta = palautekentta;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sana1.getText().isEmpty() || sana2.getText().isEmpty()) {
            palautekentta.setText("Virhe: tyhjä kenttä");
        } else if (peli.SanaOnJoSanastossa(sana1.getText())) {
            palautekentta.setText("Sanalle on jo käännös");
        } else {
            Sanapari sp = new Sanapari(sana1.getText(), sana2.getText());
            peli.lisaaSanapari(sp);
            palautekentta.setText("Lisäys onnistui!");
        }
        sana1.setText("");
        sana2.setText("");
    }
    
}
