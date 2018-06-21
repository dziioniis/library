package org.company.name.dao;

import org.company.name.dao.interfaceCRUD.RequestCRUD;
import org.company.name.entity.Request;
import org.company.name.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO extends BasicCRUD implements RequestCRUD {
    private static String ADD_BOOK_REQUEST = "INSERT INTO requests(title,user,status) values(?,?,?)";
    private static String UPDATE_BOOK_REQUEST = "UPDATE requests  SET status=? WHERE id=?";
    private static String GET_REQUEST_BY_ID = "SELECT * FROM requests WHERE id=?";
    private static String GET_ALL_REQUESTS = "SELECT * FROM requests";
    private static String GET_USER_REQUEST = "SELECT * FROM requests WHERE user=?";
    private static RequestDAO instance = new RequestDAO();

    private RequestDAO() {
    }

    public static RequestDAO getInstance() {
        return instance;
    }

    public boolean update(Request request) {
        try {
            preparedStatement = makeConnection().prepareStatement(UPDATE_BOOK_REQUEST);
            preparedStatement.setString(1, request.getStatus());
            preparedStatement.setLong(2, request.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }


    public int addBookRequest(Request request) {
        try {
            preparedStatement = makeConnection().prepareStatement(ADD_BOOK_REQUEST);
            preparedStatement.setString(1, request.getTitle());
            preparedStatement.setString(2, request.getUser());
            preparedStatement.setString(3, request.getStatus());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
            return -1;
        } finally {
            closeConnection();
        }
    }

    public Request getRequestById(int a) {
        Request requestById = new Request();
        try {
            preparedStatement = makeConnection().prepareStatement(GET_REQUEST_BY_ID);
            preparedStatement.setInt(1, a);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                requestById.setId(resultSet.getLong("id"));
                requestById.setTitle(resultSet.getString("title"));
                requestById.setUser(resultSet.getString("user"));
                requestById.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
        } catch (NullPointerException e) {
            logger.error("exception throw:" + e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return  requestById;
    }

    public List<Request> getAllRequests() {
        List<Request> requestList = new ArrayList<>();
        try {
            statement = makeConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_REQUESTS);
            while (resultSet.next()) {
                Request request = new Request();
                request.setId(resultSet.getLong("id"));
                request.setTitle(resultSet.getString("title"));
                request.setUser(resultSet.getString("user"));
                request.setStatus(resultSet.getString("status"));
                if (!request.getStatus().equals("close")) {
                    requestList.add(request);
                }
            }
        } catch (SQLException e) {
            logger.error("Exception was thrown:", e);
        } finally {
            closeConnection();
        }
        return requestList;
    }

    public List<Request> getRequestByName(User user) {
        List<Request> requestList = new ArrayList<>();
        try {
            preparedStatement = makeConnection().prepareStatement(GET_USER_REQUEST);
            preparedStatement.setString(1, user.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Request requestByName = new Request();
                requestByName.setId(resultSet.getLong("id"));
                requestByName.setTitle(resultSet.getString("title"));
                requestByName.setUser(resultSet.getString("user"));
                requestByName.setStatus(resultSet.getString("status"));
                if (!requestByName.getStatus().equals("close")) {
                    requestList.add(requestByName);
                }
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
        } catch (NullPointerException e) {
            logger.error("exception throw:" + e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return requestList;
    }
}



