/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domain.Peli;

/**
 *
 * @author Katriina
 */
class LisayksenLopettamisenKuuntelija implements ActionListener {
    private Peli peli;

    public LisayksenLopettamisenKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.kysyTallentamista();
    }
    
}
