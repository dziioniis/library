package org.company.name.dao;

import org.company.name.dao.interfaceCRUD.GenreCRUD;
import org.company.name.entity.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO extends BasicCRUD implements GenreCRUD {
    private final static String GET_ALL_GENRES = "SELECT * FROM genres";
    private static GenreDAO instance = new GenreDAO();

    private GenreDAO() {
    }

    public static GenreDAO getInstance() {
        return instance;
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genreList = new ArrayList<>();
        try {
            statement = makeConnection().createStatement();
            resultSet = statement.executeQuery(GET_ALL_GENRES);
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setName(resultSet.getString("genre"));
                genreList.add(genre);
            }
        } catch (SQLException e) {
            logger.error("Exception was thrown:", e);
        } finally {
            closeConnection();
        }
        return genreList;
    }
}
