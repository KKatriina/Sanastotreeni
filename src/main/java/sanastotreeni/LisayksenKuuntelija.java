/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author Katriina
 */
class LisayksenKuuntelija implements ActionListener {
    private JTextArea sana1;
    private JTextArea sana2;
    private Peli peli;

    public LisayksenKuuntelija(JTextArea sana1, JTextArea sana2, Peli peli) {
        this.sana1 = sana1;
        this.sana2 = sana2;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sanapari sp = new Sanapari(sana1.getText(), sana2.getText());
        peli.getPakka().lisaaSanapari(sp);
        sana1.setText("");
        sana2.setText("");
    }
    
}
