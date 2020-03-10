package settings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.3
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Settings {

    Properties prop;
    // Defines difficulty for Maths game: false is level 1, true is level 2
    int mathsDifficulty;
    // Defines difficulty for QnA game: false is level 1, true is level 2
    int questionsDifficulty;
    // Defines if whether or not user is admin
    boolean adminMode;

    public Settings() {
        prop = new Properties();
        loadSettings();
    }

    /* Loads all settings from properties file */
    public void loadSettings() {
        try (InputStream is = new FileInputStream("src/settings/Settings.properties")) {
            prop.load(is);
            setMathsDifficulty(Integer.parseInt(prop.getProperty("mathsDifficulty")));
            setQuestionsDifficulty(Integer.parseInt(prop.getProperty("questionDifficulty")));
            setAdminMode(Boolean.parseBoolean(prop.getProperty("mathsDifficulty")));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /* Saves all settings from object to properties file */
    public void saveSettings() {
        try (OutputStream os = new FileOutputStream("src/settings/Settings.properties")) {
            prop.setProperty("mathsDifficulty", mathsDifficulty + "");
            prop.setProperty("questionDifficulty", questionsDifficulty + "");
            prop.setProperty("adminMode", adminMode + "");
            prop.store(os, null);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /* SETTER: MATH DIFFICULTY */
    public void setMathsDifficulty(int mathsDifficulty) {
        this.mathsDifficulty = mathsDifficulty;
    }

    /* SETTER: QUESTION DIFFICULTY */
    public void setQuestionsDifficulty(int questionsDifficulty) {
        this.questionsDifficulty = questionsDifficulty;
    }

    /* SETTER: ADMIN MODE */
    public void setAdminMode(boolean adminMode) {
        this.adminMode = adminMode;
    }

    /* GETTER: MATH DIFFICULTY */
    public int getMathsDifficulty() {
        return mathsDifficulty;
    }

    /* GETTER: QUESTION DIFFICULTY */
    public int getQuestionsDifficulty() {
        return questionsDifficulty;
    }

    /* GETTER: ADMIN MODE */
    public boolean isAdminMode() {
        return adminMode;
    }

}
