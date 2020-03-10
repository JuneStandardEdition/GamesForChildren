package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import settings.Settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.1: Stable build, todo: appearance
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class SettingsGUI extends JPanel {

    static Settings Settings;
    JPanel mathsSetting;
    JPanel questionSetting;
    JButton saveSettings;

    public SettingsGUI() {
        // Calls for JPanel()
        super();

        // Global pane for Settings tab
        setLayout(new GridLayout(5, 1));

        // Loads current Settings
        Settings = new Settings();

        mathsSetting = initLevelSelection("Calcul");
        questionSetting = initLevelSelection("Question");
        saveSettings = saveButton();

        // Adds JPanel to SettingsGUI
        add(mathsSetting);
        add(questionSetting);
        add(saveSettings);
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
        // Buttons to select level of difficulty (applied to every game)
        ButtonGroup levelSelectionButtonGrp = new ButtonGroup();
        JRadioButton levelSelection1 = new JRadioButton("Niveau 1");
        JRadioButton levelSelection2 = new JRadioButton("Niveau 2");

        if (gameLabel.equals("Calcul") && Settings.getMathsDifficulty() == 1) {
            levelSelection1.setSelected(true);
        } else if (gameLabel.equals("Calcul") && Settings.getMathsDifficulty() == 2) {
            levelSelection2.setSelected(true);
        }

        if (gameLabel.equals("Question") && Settings.getQuestionsDifficulty() == 1) {
            levelSelection1.setSelected(true);
        } else if (gameLabel.equals("Question") && Settings.getQuestionsDifficulty() == 2) {
            levelSelection2.setSelected(true);
        }

        levelSelection1.addActionListener((ActionEvent ae) -> {
            if (gameLabel.equals("Calcul")) {
                Settings.setMathsDifficulty(1);
            } else {
                Settings.setQuestionsDifficulty(1);
            }
        });
        levelSelection2.addActionListener((ActionEvent ae) -> {
            if (gameLabel.equals("Calcul")) {
                Settings.setMathsDifficulty(2);
            } else {
                Settings.setQuestionsDifficulty(2);
            }
        });

        // Adds JRadioButton to ButtonGroup (manages behavior)
        levelSelectionButtonGrp.add(levelSelection1);
        levelSelectionButtonGrp.add(levelSelection2);
        // Adds components to pane
        levelSelection.add(gameNameLabel);
        levelSelection.add(levelSelection1);
        levelSelection.add(levelSelection2);
        // Returns JPanel
        return levelSelection;
    }

    private static JButton saveButton() {
        JButton jbsave = new JButton();
        jbsave.setPreferredSize(new Dimension(140, 70));
        jbsave.setText("Sauvegarder");
        jbsave.addActionListener((ActionEvent ae) -> {
            Settings.saveSettings();
            System.out.println("Hello");
        });

        return jbsave;
    }

}
