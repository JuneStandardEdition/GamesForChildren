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
 *
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

        JFrame f = new JFrame("Multi Game");
        f.setSize(800, 600);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        settings = new SettingsGUI();
        maths = new CalculGUI("Maths");
        qust = new QuestionGUI("QnA");
        ardoise = new ArdoiseGUI();
        admin = new AdminPanelGUI();

        jtp = new JTabbedPane();
        jtp.addTab("Ardoise", (JPanel) ardoise);
        jtp.addTab("Calcul", (JPanel) maths);
        jtp.addTab("QnA", (JPanel) qust);
        jtp.addTab("Parametres", (JPanel) settings);
        jtp.addTab("Admin", new AdminPanelGUI());
        jtp.addChangeListener(changeListener);

        // Menus top of the JFrame
        JMenuBar menuBar = new JMenuBar();
        JMenu ludo = new JMenu("Ludothèque");
        JMenuItem dessin = new JMenuItem("Dessiner");
        dessin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(0);
            }
        });
        JMenuItem calcul = new JMenuItem("Calculer");
        calcul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(1);
            }
        });
        JMenuItem questions = new JMenuItem("Question / Réponse");
        questions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtp.setSelectedIndex(2);
            }
        });
        ludo.add(dessin);
        ludo.addSeparator();
        ludo.add(calcul);
        ludo.add(questions);
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
