package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import settings.Settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.2: Stable build, fixed appearance
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class SettingsGUI extends JPanel {

    static Settings Settings;
    JPanel mathsSetting;
    JPanel questionSetting;
    JPanel saveSettings;

    public SettingsGUI() {
        // Calls for JPanel()
        super();
        setBorder(BorderFactory.createTitledBorder("Paramètres"));

        // Global pane for Settings tab
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

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
        levelSelection.setLayout(new GridLayout(1, 5));
        JLabel gameNameLabel = new JLabel(gameLabel);
        // Buttons to select level of difficulty (applied to every game)
        ButtonGroup levelSelectionButtonGrp = new ButtonGroup();
        JRadioButton levelSelection1 = new JRadioButton("Niveau 1");
        JRadioButton levelSelection2 = new JRadioButton("Niveau 2");
        // Selects JRadioButton that refers to the current setting level of Maths
        if (gameLabel.equals("Calcul") && Settings.getMathsDifficulty() == 1) {
            levelSelection1.setSelected(true);
        } else if (gameLabel.equals("Calcul") && Settings.getMathsDifficulty() == 2) {
            levelSelection2.setSelected(true);
        }
        // Selects JRadioButton that refers to the current setting level of QnA
        if (gameLabel.equals("Question") && Settings.getQuestionsDifficulty() == 1) {
            levelSelection1.setSelected(true);
        } else if (gameLabel.equals("Question") && Settings.getQuestionsDifficulty() == 2) {
            levelSelection2.setSelected(true);
        }
        // Sets levels
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

    // Button Save
    private static JPanel saveButton() {
        JPanel saveBPane = new JPanel();
        saveBPane.setLayout(new BorderLayout());
        saveBPane.setMaximumSize(new Dimension(200, 75));
        JButton jbsave = new JButton();
        jbsave.setText("Sauvegarder");
        jbsave.addActionListener((ActionEvent ae) -> {
            Settings.saveSettings();
            System.out.println("Settings saved.");
        });
        saveBPane.add(jbsave);
        return saveBPane;
    }

}
