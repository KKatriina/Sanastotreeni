/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katriina
 */
class TallentamisenKuuntelija implements ActionListener {
    private Peli peli;

    public TallentamisenKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            peli.tallenna();
        } catch (IOException ex) {
            Logger.getLogger(TallentamisenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
