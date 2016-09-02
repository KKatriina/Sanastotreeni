/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanastotreeni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Katriina
 */
public class Kentta extends JPanel {
    private JPanel kentta;
    private Container container;
    private Peli peli;
    
    
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
        JLabel viesti = new JLabel("Tervetuloa vänskään sanapeliin!");
        JLabel viesti2 = new JLabel(palaute);
        
        kentta.add(viesti);
        kentta.add(viesti2);
        
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
    
    public void asetaLisaysKentta() {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(3,2);
        kentta.setLayout(layout);
        
        JLabel viesti1 = new JLabel("Sana:");
        JLabel viesti2 = new JLabel("Käännös:");
        JTextArea sana1 = new JTextArea();
        JTextArea sana2 = new JTextArea();
        JButton nappi1 = new JButton("Lisää sanapari");
        JButton nappi2 = new JButton("Kaikki sanat lisätty!");

        nappi1.addActionListener(new LisayksenKuuntelija(sana1, sana2, peli));
        nappi2.addActionListener(new PelinAloittamisenKuuntelija(peli));        
        
        kentta.add(viesti1);
        kentta.add(viesti2);
        kentta.add(sana1);
        kentta.add(sana2);
        kentta.add(nappi1);
        kentta.add(nappi2);
        
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }
    
    public void asetaPelikentta(Sanapari sp, String palaute) {
        //container.removeAll();
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        GridLayout layout = new GridLayout(4, 2);
        kentta.setLayout(layout);
        
        JLabel palauteviesti = new JLabel(palaute);
        JLabel vali1 = new JLabel();
        JLabel vali2 = new JLabel();
        JLabel vali3 = new JLabel();
        JLabel viesti = new JLabel("Kirjoita annetun sanan käännös:");
        JLabel sana1 = new JLabel(sp.getSana1());
        JTextArea sana2 = new JTextArea();
        JButton nappi = new JButton("OK!");
        nappi.addActionListener(new PelikierroksenKuuntelija(sana2, sp, peli));
        
        kentta.add(palauteviesti);
        kentta.add(vali1);
        kentta.add(viesti);
        kentta.add(vali2);
        kentta.add(sana1);
        kentta.add(sana2);
        kentta.add(vali3);
        kentta.add(nappi);
        container.add(kentta, BorderLayout.NORTH);
        kentta.validate();
        container.validate();
    }

    public void asetaLoppuKentta(ArrayList<Sanapari> taysiPakka) {
        kentta.removeAll();
        kentta.setPreferredSize(new Dimension(500, 200));
        kentta.setLayout(new BoxLayout(kentta, BoxLayout.Y_AXIS));
        JLabel viesti1 = new JLabel("Peli loppu!");
        JLabel viesti2 = new JLabel("Tässä kertauksena kaikki sanat:");
        kentta.add(viesti1);
        kentta.add(viesti2);
        
        for (int i = 0; i < taysiPakka.size(); i++) {
            Sanapari sp = taysiPakka.get(i);
            JLabel viesti = new JLabel(sp.toString());
            System.out.println(sp.toString());
            if (sp.virheellinen()) {
                viesti.setBackground(Color.red);
                System.out.println("Punaista pitäis olla!");
            }
            kentta.add(viesti);
        }
        
        JLabel viesti3 = new JLabel("Kiitos ja kuulemiin!");
        kentta.add(viesti3);
        kentta.validate();
        container.validate();
    }
}
