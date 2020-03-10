package questions;

import connections.SQLConnection;
import java.sql.Connection;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 28-02-2020.12:52
 *
 *************************************************
 */
public interface DAO<T> {

    // Const connexion
    Connection CONNEXION = SQLConnection.getInstance();

    T find(Integer id);

    void create(T T);

    void delete(Integer id);

    void update(T T);

}
