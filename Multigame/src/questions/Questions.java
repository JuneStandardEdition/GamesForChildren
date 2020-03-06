package questions;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Questions {

    Integer id;
    String question;
    String answer;
    Integer difficulty;

    public Questions() {
    }

    /* GETTERS */
    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    /* SETTERS */
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    // I don't even know if we will need this but, we never know right.
    void func() {

    }

}
