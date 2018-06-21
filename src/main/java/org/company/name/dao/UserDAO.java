package org.company.name.dao;

import org.company.name.dao.interfaceCRUD.UserCRUD;
import org.company.name.entity.User;
import org.company.name.manager.ConfigurationManager;

import java.sql.SQLException;

public class UserDAO extends BasicCRUD implements UserCRUD {
    final private static String ADD_USER = "insert into user(Name,pass,mail) values (?,?,?)";
    final private static String FIND_USER = "SELECT * FROM user WHERE name=?";
    private static UserDAO instance = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return instance;
    }

    public User findUser(String name) {
        User user = new User();
        try {
            preparedStatement = makeConnection().prepareStatement(FIND_USER);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                user.setName(name);
                user.setPass(resultSet.getNString("pass"));
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
            ConfigurationManager.getProperty("path.page.error");
        } catch (NullPointerException e) {
            logger.error("exception throw:" + e);
            ConfigurationManager.getProperty("path.page.error");
            ;
        } finally {
            closeConnection();
        }
        return user;
    }

    @Override
    public int insertUser(User user) {
        try {
            preparedStatement = makeConnection().prepareStatement(ADD_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
            return -1;
        } finally {
            closeConnection();
        }
        return 0;
    }
}
