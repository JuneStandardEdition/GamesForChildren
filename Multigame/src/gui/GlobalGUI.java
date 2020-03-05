/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Will I Am
 */
public class GlobalGUI extends JFrame {

    JTabbedPane jtp;
    JPanel adminPanel;
    JPanel ardoise;
    JPanel mathsQuestions;

    public GlobalGUI() {

        JFrame f = new JFrame("Multi Game");
        f.setSize(800,600);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.jtp = new JTabbedPane();
        jtp.setSize(800, 600);
        
        
        
        /*
        this.adminPanel = new AdminPanelGUI();
        this.ardoise = new ArdoiseGUI();
        this.mathsQuestions = new MathsQuestionsGUI();
         */
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JMenuBar menu = new JMenuBar();
        JMenu dessin = new JMenu("Dessin");
        JMenu calcul = new JMenu("Calcul");
        JMenu questions = new JMenu("Questions");
        JMenu admin = new JMenu("Administration");

        menu.add(dessin);
        menu.add(calcul);
        menu.add(questions);
        menu.add(admin);

        f.add(jtp);
        f.setJMenuBar(menu);
        f.setVisible(true);
    }

}
