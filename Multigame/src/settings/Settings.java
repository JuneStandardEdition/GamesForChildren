package settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.2
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Settings {
    
    public static final  boolean DIFFICULTE_1 = true;

    // Defines difficulty for Maths game: false is level 1, true is level 2
    boolean mathsDifficulty;
    // Defines difficulty for QnA game: false is level 1, true is level 2
    boolean questionsDifficulty;
    // Defines if whether or not user is admin
    boolean adminMode;

    private Settings() {
        mathsDifficulty = false;
        questionsDifficulty = false;
        adminMode = false;
    }

    /* SETTERS */
    public void setMathsDifficulty(boolean mathsDifficulty) {
        this.mathsDifficulty = mathsDifficulty;
    }

    public void setQuestionsDifficulty(boolean questionsDifficulty) {
        this.questionsDifficulty = questionsDifficulty;
    }

    public void setAdminMode(boolean adminMode) {
        this.adminMode = adminMode;
    }

    /* GETTERS */
    public boolean isMathsDifficulty() {
        return mathsDifficulty;
    }

    public boolean isQuestionsDifficulty() {
        return questionsDifficulty;
    }

    public boolean isAdminMode() {
        return adminMode;
    }

}
