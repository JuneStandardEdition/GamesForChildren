package gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Will I Am
 */
public final class GlobalGUI extends JFrame {

    JTabbedPane jtp;
    JPanel settings;
    JPanel currentActivity;

    /*
        Global GUI
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

        //settings = new SettingsGUI();
        // Temporaire : Affiche un message dans QnA
        JLabel jlbl = new JLabel("LEEROY");

        jtp = new JTabbedPane();
        //jtp.addTab("Ardoise", new ArdoiseGUI());
        jtp.addTab("Calcul", new MathsQuestionsGUI());
        jtp.addTab("QnA", jlbl);
        jtp.addTab("Parametres", new SettingsGUI());
        jtp.addTab("Admin", new AdminPanelGUI());
        jtp.addChangeListener(changeListener);

        JMenuBar menu = new JMenuBar();
        JMenu dessin = new JMenu("Dessin");
        JMenu calcul = new JMenu("Calcul");
        JMenu questions = new JMenu("Questions");
        JMenu settingsMenu = new JMenu("Paramètres");
        JMenu admin = new JMenu("Administration");

        menu.add(dessin);
        menu.add(calcul);
        menu.add(questions);
        menu.add(settingsMenu);
        menu.add(admin);

        f.add(jtp);
        f.setJMenuBar(menu);
        f.setVisible(true);
    }
}
