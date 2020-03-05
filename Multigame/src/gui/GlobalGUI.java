package gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
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

        JPanel sett = new SettingsGUI();

        jtp = new JTabbedPane();
        jtp.addTab("Ardoise", new ArdoiseGUI());
        jtp.addTab("Calcul", new MathsQuestionsGUI());
        jtp.addTab("QnA", new MathsQuestionsGUI());
        jtp.addTab("Parametres", sett);
        jtp.addTab("Admin", new AdminPanelGUI());
        /*jtp.addChangeListener((ChangeEvent ce) -> {
            if (jtp.getSelectedIndex() == 3) {
                currentActivity = (JPanel) jtp.getComponent(3);
            };
        });*/

        JMenuBar menu = new JMenuBar();
        JMenu dessin = new JMenu("Dessin");
        JMenu calcul = new JMenu("Calcul");
        JMenu questions = new JMenu("Questions");
        JMenu settings = new JMenu("Paramètres");
        JMenu admin = new JMenu("Administration");

        menu.add(dessin);
        menu.add(calcul);
        menu.add(questions);
        menu.add(settings);
        menu.add(admin);

        f.add(jtp);
        f.setJMenuBar(menu);
        f.setVisible(true);
    }
}
