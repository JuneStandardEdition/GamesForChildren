package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import static settings.Settings.DIFFICULTE_1;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.1: Stable build, todo: appearance
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

        // Adds JPanel to SettingsGUI
        add(initLevelSelection("Calcul"));
        add(initLevelSelection("Question"));
    }

    /*
     * String gameLabel : Nom du jeu
     * Inits RadioButtons & Label
     * @args String gameLabel: prints label into settings pane
     */
    private static JPanel initLevelSelection(String gameLabel) {
        JPanel levelSelection = new JPanel();
        levelSelection.setLayout(new GridLayout(1, 3));
        JLabel gameNameLabel = new JLabel(gameLabel);
        // Buttons to select level of diffculty (applied to every game)
        ButtonGroup levelSelectionButtonGrp = new ButtonGroup();
        JRadioButton levelSelection1 = new JRadioButton("Niveau 1");
        levelSelection1.setSelected(true);
        JRadioButton levelSelection2 = new JRadioButton("Niveau 2");
        // Ajouts ecouteurs pour les bouttons
        levelSelection2.addActionListener((ActionEvent ae) -> {
            DIFFICULTE_1 = !DIFFICULTE_1;
        });
        levelSelection1.addActionListener((ActionEvent ae) -> {
            DIFFICULTE_1 = true;
        });

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
