package sanastotreeni;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Katriina
 */
import gui.Kayttoliittyma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import sanastotreeni.*;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {   
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
