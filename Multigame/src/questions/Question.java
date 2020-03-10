package questions;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.6
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Question {

    public Integer id;
    public String question;
    public String answer;
    public Integer difficulty;

    public Question() {
        id = 0;
        question = "N/A ?";
        answer = "N/A";
        difficulty = 0;
    }

    public Question(Integer id, String qst, String ans, Integer diff) {
        this.id = id;
        this.question = qst;
        this.answer = ans;
        this.difficulty = diff;
    }

    /* GETTER: ID */
    public Integer getId() {
        return id;
    }

    /* GETTER: QUESTION */
    public String getQuestion() {
        return question;
    }

    /* GETTER: ANSWER */
    public String getAnswer() {
        return answer;
    }

    /* GETTER: DIFFICULTY */
    public Integer getDifficulty() {
        return difficulty;
    }

    /* SETTER: ID */
    public void setId(Integer id) {
        this.id = id;
    }

    /* SETTER: QUESTION */
    public void setQuestion(String question) {
        this.question = question;
    }

    /* SETTER: ANSWER */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /* SETTER: DIFFICULTY */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /* OVERRIDES TOSTRING() */
    @Override
    public String toString() {
        return "Questions {" + "id=" + id + ", question=" + question + ", answer=" + answer + ", difficulty=" + difficulty + '}';
    }

    /* I don't even know if we will need this but, we never know right.
    Ok nvm, it will serve a precise purpose : checks if the answer given by
    the user is the correct one.
    Returns true if correct, false if wrong
     */
    public boolean answerCheck(String rep) {
        return rep.toLowerCase()
                .replaceAll("[â ä à]", "a")
                .replaceAll("[é è ê ë]", "e")
                .replaceAll("[î ï]", "i")
                .replaceAll("[ö ô]", "o")
                .replaceAll("[û ü]", "u")
                .replaceAll("[ÿ]", "y")
                .replaceAll("[ç]", "c")
                .equals(answer);
    }

}
