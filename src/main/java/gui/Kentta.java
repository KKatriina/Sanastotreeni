/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.actionListeners.TallentamisenKuuntelija;
import gui.actionListeners.TallennetunValitsemisenKuuntelija;
import gui.actionListeners.PelinAloittamisenKuuntelija;
import gui.actionListeners.PelikierroksenKuuntelija;
import gui.actionListeners.LisayksenLopettamisenKuuntelija;
import gui.actionListeners.LisayksenKuuntelija;
import gui.actionListeners.LisayksenAloittamisenKuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import domain.Peli;
import domain.Sanapari;

/**
 *
 * @author Katriina
 */
public class Kentta extends JPanel {
    private JPanel kentta;
    private Container container;
    private Peli peli;
    
    
    //tän luokan copypastelle tee joskus jotain
    
    public Kentta(Container container, Peli peli) {
        this.kentta = new JPanel();
        this.container = container;
        this.peli = peli;
    }
    
    public void asetaAloitusKentta(String palaute) {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500,200));
        GridLayout layout = new GridLayout(3,1);
        kentta.setLayout(layout);
        
        kentta.add(new JLabel("Tervetuloa vänskään sanapeliin!"));
        kentta.add(new JLabel(palaute));       
        JPanel paneeli = new JPanel(new GridLayout(1,2));
        JButton nappi1 = new JButton("Tee uusi sanalista");
        JButton nappi2 = new JButton("Kysy tallennetulta listalta");
        nappi1.addActionListener(new LisayksenAloittamisenKuuntelija(peli));
        nappi2.addActionListener(new TallennetunValitsemisenKuuntelija(peli));
        paneeli.add(nappi1);
        paneeli.add(nappi2);
    
        kentta.add(paneeli);
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }
    
    public void asetaLisaysKentta(String palaute) {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(4,2);
        kentta.setLayout(layout);
        
        JLabel palautekentta = new JLabel(palaute);
        kentta.add(palautekentta);
        kentta.add(new JLabel());
        kentta.add(new JLabel("Sana:"));
        kentta.add(new JLabel("Käännös:"));
        JTextArea sana1= new JTextArea();
        JTextArea sana2 = new JTextArea();
        kentta.add(sana1);
        kentta.add(sana2);
        JButton nappi1 = new JButton("Lisää sanapari");
        JButton nappi2 = new JButton("Lopeta lisääminen");
        nappi1.addActionListener(new LisayksenKuuntelija(sana1, sana2, palautekentta, peli));
        nappi2.addActionListener(new LisayksenLopettamisenKuuntelija(peli));        
        kentta.add(nappi1);
        kentta.add(nappi2);
        
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }
    
    public void asetaPelikentta(Sanapari sp, String palaute) {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(4, 2);
        kentta.setLayout(layout);
        
        kentta.add(new JLabel(palaute));
        kentta.add(new JLabel());
        kentta.add(new JLabel("Kirjoita annetun sanan käännös:"));
        kentta.add(new JLabel());
        kentta.add(new JLabel(sp.getSana1()));
        JTextArea sana2 = new JTextArea();
        kentta.add(sana2);
        kentta.add(new JLabel());
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new PelikierroksenKuuntelija(sana2, sp, peli));        
        kentta.add(nappi);
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }

    public void asetaLoppuKentta(ArrayList<Sanapari> taysiPakka) {
        container.removeAll();
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        int riveja = 0;
        if (taysiPakka.size()%3 == 0) {
            riveja = (taysiPakka.size()/3) + 2;
        } else {
            riveja = (taysiPakka.size()/3) + 3;
        }
        System.out.println("rivejä: " + riveja);
        int indeksi = 0;
        GridLayout layout = new GridLayout(riveja, 3);
        kentta.setLayout(layout);
        
        kentta.add(new JLabel("Peli loppu!"));
        kentta.add(new JLabel("Punaisissa virheitä:"));
        kentta.add(new JLabel());
        
        for (int i = 0; i < taysiPakka.size(); i++) {
            Sanapari sp = taysiPakka.get(i);
            JLabel viesti = new JLabel(sp.toString());
            if (sp.virheellinen()) {
                viesti.setForeground(Color.red);
            }
            kentta.add(viesti);
            indeksi++;
        }
        if (taysiPakka.size()%riveja == 2) {
            kentta.add(new JLabel());
        } else if (taysiPakka.size()%riveja == 1) {
            kentta.add(new JLabel());
            kentta.add(new JLabel());
        }
        
        JButton nappi1 = new JButton("Lisää uusi sanasto");
        JButton nappi2 = new JButton("Pelaa uusi kierros");
        nappi1.addActionListener(new LisayksenAloittamisenKuuntelija(peli));
        nappi2.addActionListener(new PelinAloittamisenKuuntelija(peli, taysiPakka));
        kentta.add(new JLabel("Kiitos ja kuulemiin!"));
        kentta.add(nappi1);
        kentta.add(nappi2);
        
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }

    public void kysyTallentamista() {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(2, 2);
        kentta.setLayout(layout);
        
        kentta.add(new JLabel("Tallennetaanko sanalista muistiin?"));
        kentta.add(new JLabel());
        JButton nappi1 = new JButton("Ei, pelataan vain!");
        JButton nappi2 = new JButton("Tallennetaan!");
        nappi1.addActionListener(new PelinAloittamisenKuuntelija(peli, null));
        nappi2.addActionListener(new TallentamisenKuuntelija(peli));        
        kentta.add(nappi1);
        kentta.add(nappi2);
        kentta.validate();
        container.validate();
    }
}
