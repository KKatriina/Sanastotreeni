/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Katriina
 */
class TallennetunValitsemisenKuuntelija implements ActionListener {
    private Peli peli;

    public TallennetunValitsemisenKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.valitaanTallennettu();
    }
    
}
