package questions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 06-03-2020.8:45
 *
 *************************************************
 */
public class QuestionsDAO implements DAO<Questions> {

    ArrayList<Questions> qdao = new ArrayList<>();

    public List<Questions> getAll() {
        String sqlQuery = "SELECT * FROM questions";
        try (Statement stmt = CONNEXION.createStatement()) {
            ResultSet resSetAvion = stmt.executeQuery(sqlQuery);
            while (resSetAvion.next()) {
                qdao.add(new Questions());
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qdao;
    }

    @Override
    public Questions find(Integer id) {
        Questions qst = null;
        try {
            String req = "SELECT * FROM questions WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                qst = new Questions();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qst;
    }

    @Override
    public void create(Questions q) {
        try {
            String req = "INSERT INTO questions (question, answer, difficulty) VALUES (?,?,?)";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, q.getQuestion());
            pstmt.setString(2, q.getAnswer());
            pstmt.setInt(3, q.getDifficulty());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM questions WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Questions q) {
        try {
            String req = "UPDATE questions SET question = ?, reponse = ?, difficulty = ? WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, q.getQuestion());
            pstmt.setString(2, q.getAnswer());
            pstmt.setInt(3, q.getDifficulty());
            pstmt.setInt(4, q.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
