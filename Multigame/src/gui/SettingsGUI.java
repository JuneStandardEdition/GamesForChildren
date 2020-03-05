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

    JPanel globalSettingsPanel;

    public SettingsGUI() {
        globalSettingsPanel = initSettingsGUI();
    }

    private static JPanel initSettingsGUI() {
        JPanel temp = new JPanel();
        // Global pane for Settings tab
        temp.setLayout(new GridLayout(1, 5));

        temp.add(initLevelSelection("Calcul"));
        temp.add(initLevelSelection("Question"));
        return temp;
    }

    /*
        String gameLabel : Nom du jeu
        Inits RadioButtons & Label
     */
    private static JPanel initLevelSelection(String gameLabel) {
        JPanel levelSelection = new JPanel();
        levelSelection.setLayout(new GridLayout(3, 1));
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
