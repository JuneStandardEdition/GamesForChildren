package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Will I Am
 */
public class ButtonsGUI extends JPanel {

    public ButtonsGUI() {
        //super();
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //add(creerBoutons("calcul"));
    }

    public JPanel creerBoutons() {

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton verif = new JButton("Verification");
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Suivant");
        verif.setPreferredSize(new Dimension(200, 75));
        solution.setPreferredSize(new Dimension(200, 75));
        questionSuivante.setPreferredSize(new Dimension(200, 75));
        

        this.add(verif);
        this.add(solution);
        this.add(questionSuivante);

        return this;
    }
}
