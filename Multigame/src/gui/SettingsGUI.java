package gui;

import java.awt.*;
import javax.swing.*;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class SettingsGUI extends JPanel {

    public SettingsGUI() {
        // Calls for JPanel()
        super();
        // Global pane for Settings tab
        setLayout(new GridLayout(5, 1));

        add(initLevelSelection("Calcul"));
        add(initLevelSelection("Question"));
    }

    /*
        String gameLabel : Nom du jeu
        Inits RadioButtons & Label
     */
    private static JPanel initLevelSelection(String gameLabel) {
        JPanel levelSelection = new JPanel();
        levelSelection.setLayout(new GridLayout(1, 3));
        JLabel gameNameLabel = new JLabel(gameLabel);
        // Buttons to select level of diffculty (applied to every game)
        ButtonGroup levelSelectionButtonGrp = new ButtonGroup();
        JRadioButton levelSelection1 = new JRadioButton("Niveau 1");
        JRadioButton levelSelection2 = new JRadioButton("Niveau 2");
        // Adds JRadioButton to ButtonGroup (manages buttons comportement)
        levelSelectionButtonGrp.add(levelSelection1);
        levelSelectionButtonGrp.add(levelSelection2);
        // Adds components to pane
        levelSelection.add(gameNameLabel);
        levelSelection.add(levelSelection1);
        levelSelection.add(levelSelection2);
        // Returns JPanel
        return levelSelection;
    }

}
