/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Will I Am
 */
public class ButtonsGUI extends JPanel {
    
    public ButtonsGUI(){
        //super();
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        //add(creerBoutons("calcul"));
    }

    public JPanel creerBoutons(String button3) {
        
        this.setLayout(new GridLayout(0, 3));
        JButton verif = new JButton("Verification");
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Autre " + button3);
        
        this.add(verif);
        this.add(solution);
        this.add(questionSuivante);
        
        
        return this;
    }

}