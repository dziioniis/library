package org.company.name.logic.Command;

import org.company.name.dao.BookDAO;
import org.company.name.entity.Book;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchCommand extends Command {
    private static SearchCommand instance = new SearchCommand();

    private SearchCommand() {
    }

    public static SearchCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("search command");
        String name = request.getParameter("find");
        Book book = BookDAO.getInstance().findBook(name);
        HttpSession session = request.getSession(false);
        session.setAttribute("book", book);
        String page = ConfigurationManager.getProperty("path.page.find");
        return page;
    }
}
