package org.company.name.dao;


import org.company.name.dao.interfaceCRUD.BookCRUD;
import org.company.name.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDAO extends BasicCRUD implements BookCRUD {
    final private static String UPDATE_BOOK_STOCK = "UPDATE books SET stock=? WHERE idbooks=?";
    final private static String GET_BOOKS_FROM_GENRE = "SELECT * FROM books WHERE genre=?";
    final private static String FIND_BOOK = "SELECT * FROM books where book=?";
    final private static String ADD_BOOK = "INSERT INTO books(book,data,url,genre,pages,stock,author)values(?,?,?,?,?,?,?)";
    private static BookDAO instance = new BookDAO();

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        return instance;
    }

    public boolean updateBookStock(Book book) {
        try {
            preparedStatement = makeConnection().prepareStatement(UPDATE_BOOK_STOCK);
            preparedStatement.setInt(1, book.getStock());
            preparedStatement.setLong(2, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }finally {
        closeConnection();
        }
        return true;
    }

    @Override
    public void addBook(Book book) {
        try {
            preparedStatement = makeConnection().prepareStatement(ADD_BOOK);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setInt(2, book.getData());
            preparedStatement.setString(3, book.getUrlImage());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setInt(5, book.getPageCount());
            preparedStatement.setInt(6, book.getStock());
            preparedStatement.setString(7, book.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("exception  throw:" + e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Book> getBooksFromGenre(String genre) {

        List<Book> bookList = new ArrayList<>();
        try {
            preparedStatement = makeConnection().prepareStatement(GET_BOOKS_FROM_GENRE);
            preparedStatement.setString(1, genre);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setStock(resultSet.getInt("stock"));
                book.setId(resultSet.getLong("idbooks"));
                book.setName(resultSet.getString("book"));
                book.setGenre(resultSet.getString("genre"));
                book.setAuthor(resultSet.getString("author"));
                book.setPageCount(resultSet.getInt("pages"));
                book.setData(resultSet.getInt("data"));
                book.setUrlImage(resultSet.getString("url"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
        } finally {
            closeConnection();
        }
        return bookList;
    }


    @Override
    public Book findBook(String name) {
        Book book = new Book();
        try {
            preparedStatement = makeConnection().prepareStatement(FIND_BOOK);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                book.setStock(resultSet.getInt("stock"));
                book.setAuthor(resultSet.getString("author"));
                book.setUrlImage(resultSet.getString("url"));
                book.setGenre(resultSet.getString("genre"));
                book.setName(resultSet.getString("book"));
                book.setId(resultSet.getLong("idbooks"));
                return book;
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
        } catch (NullPointerException e) {
            logger.error("exception throw:" + e);
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return book;
    }


    public Book findBookById(Long id) {
        Book book = new Book();
        try {
            preparedStatement = makeConnection().prepareStatement("SELECT * from books where idbooks=?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                book.setAuthor(resultSet.getString("author"));
                book.setUrlImage(resultSet.getString("url"));
                book.setGenre(resultSet.getString("genre"));
                book.setName(resultSet.getString("book"));
                book.setId(resultSet.getLong("idbooks"));
                book.setStock((resultSet.getInt("stock")));
                return book;
            }
        } catch (SQLException e) {
            logger.error("exception throw:" + e);
        } catch (NullPointerException e) {
            logger.error("exception throw:" + e);
        } finally {
            closeConnection();
        }

        return book;
    }
}

