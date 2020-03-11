package gui;

import connections.SQLConnection;
import static connections.SQLConnection.getPassword;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Will I Am & June.QL (ça fait du bien à l'égo, mais j'ai bcp codé ici
 * aussi)
 */
public final class GlobalGUI extends JFrame {

    JTabbedPane jtp;
    JPanel settings;
    JPanel maths;
    JPanel qust;
    JPanel ardoise;
    JPanel admin;

    /*
     * Global GUI
     */
    public GlobalGUI() {

        // Global JFrame
        JFrame f = new JFrame("Multi Game");

        // Sets size
        f.setSize(800, 600);
        // Non-resizable
        f.setResizable(false);
        // Exit on close
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BoxLayout
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Listener temporaire : Permet de voir en console le changement de tab
        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
            }
        };

        // Calls for other GUIs
        settings = new SettingsGUI();
        maths = new CalculGUI("Maths");
        qust = new QuestionGUI("QnA");
        ardoise = new ArdoiseGUI();
        admin = new AdminPanelGUI();

        // Create TabbedPane (Tabs)
        jtp = new JTabbedPane();
        jtp.addTab("Ardoise", (JPanel) ardoise);
        jtp.addTab("Calcul", (JPanel) maths);
        jtp.addTab("QnA", (JPanel) qust);
        jtp.addTab("Parametres", (JPanel) settings);
        
        jtp.addChangeListener(changeListener);

        // Menus top of the JFrame avec ecouteurs pr desactiver des boutons
        JMenuBar menuBar = new JMenuBar();
        JMenu ludo = new JMenu("Ludothèque");
        // MenuItem Draw
        JMenuItem dessin = new JMenuItem("Dessiner");
        dessin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(0);
            }
        });
        // MenuItem Maths
        JMenuItem calcul = new JMenuItem("Calculer");
        calcul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(1);
            }
        });
        // MenuItem QnA
        JMenuItem questions = new JMenuItem("Question / Réponse");
        questions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(2);
            }
        });
        // Adds MenuItem to Menu
        ludo.add(dessin);
        ludo.addSeparator();
        ludo.add(calcul);
        ludo.add(questions);
        // Another Menu
        JMenu settingsMenu = new JMenu("Paramètres");
        JMenuItem settingsMenuItem = new JMenuItem("Panel paramètres");
        settingsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(3);
            }
        });
        settingsMenu.add(settingsMenuItem);
        JMenu admin = new JMenu("Administration");
        JMenuItem adminMenuItem = new JMenuItem("Panel administration");
        admin.addActionListener(new ActionListener() {
            // Celui-ci ne semble pas fonctionner
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(4);
            }
        });
        admin.add(adminMenuItem);
        admin.addSeparator();
        JMenuItem co = new JMenuItem("Se connecter");
        admin.add(co);

        // Listener pour se connecter
        co.addActionListener((ActionEvent ae) -> {
            Connection ct = null;

            String mdp = (String) JOptionPane.showInputDialog(null,
                    "Veuillez saisir le mot de passe : ",
                    "CONNEXION",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null
            );

            if (mdp.equals(getPassword())) {
                ct = SQLConnection.getInstance();
                JOptionPane.showMessageDialog(null,
                        "CONNECTE A LA BASE DE DONNEE",
                        "SUCCESS !",
                        JOptionPane.INFORMATION_MESSAGE);
                jtp.addTab("Admin", new AdminPanelGUI());
                
            } else {
                JOptionPane.showMessageDialog(null,
                        "ERREUR DE CONNECTION",
                        "ERREUR !",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Adds submenus to menuBar
        menuBar.add(ludo);
        menuBar.add(settingsMenu);
        menuBar.add(admin);

        // Adds content to JFrame and sets it visible
        f.add(jtp);
        f.setJMenuBar(menuBar);
        f.setVisible(true);
    }

}
