package org.company.name.logic;

import org.company.name.dao.BookDAO;
import org.company.name.dao.GenreDAO;
import org.company.name.dao.RequestDAO;
import org.company.name.entity.Book;
import org.company.name.entity.Genre;
import org.company.name.entity.Request;
import org.company.name.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class PageContentMaker {

    public static void getAllRequests(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<Request> requestList = RequestDAO.getInstance().getAllRequests();
        session.setAttribute("requestlist", requestList);
    }

    public static void getUserRequests(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        System.out.println("user:" + user.getName());
        List<Request> requestList = RequestDAO.getInstance().getRequestByName(user);
        session.setAttribute("yourRequestList", requestList);
    }

    public static void getAllGenres(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<Genre> genreList = GenreDAO.getInstance().getAllGenres();
        session.setAttribute("datalist", genreList);
    }

    public static void getBooks(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        List<Book> bookList = BookDAO.getInstance().getBooksFromGenre(request.getParameter("genre"));
        session.setAttribute("bookslist", bookList);
    }
}

