package settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.3
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Settings {

    public static boolean DIFFICULTE_1 = true;

    // Defines difficulty for Maths game: false is level 1, true is level 2
    boolean mathsDifficulty;
    // Defines difficulty for QnA game: false is level 1, true is level 2
    boolean questionsDifficulty;
    // Defines if whether or not user is admin
    boolean adminMode;

    /* CONSTRUCTOR: private so it cannot be instantiated, also, default value false */
    private Settings() {
        mathsDifficulty = false;
        questionsDifficulty = false;
        adminMode = false;
    }

    /* SETTER: MATH DIFFICULTY */
    public void setMathsDifficulty(boolean mathsDifficulty) {
        this.mathsDifficulty = mathsDifficulty;
    }

    /* SETTER: QUESTION DIFFICULTY */
    public void setQuestionsDifficulty(boolean questionsDifficulty) {
        this.questionsDifficulty = questionsDifficulty;
    }

    /* SETTER: ADMIN MODE */
    public void setAdminMode(boolean adminMode) {
        this.adminMode = adminMode;
    }

    /* GETTER: MATH DIFFICULTY */
    public boolean isMathsDifficulty() {
        return mathsDifficulty;
    }

    /* GETTER: QUESTION DIFFICULTY */
    public boolean isQuestionsDifficulty() {
        return questionsDifficulty;
    }

    /* GETTER: ADMIN MODE */
    public boolean isAdminMode() {
        return adminMode;
    }

}
