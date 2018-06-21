package org.company.name.logic.Command;

import org.company.name.dao.BookDAO;
import org.company.name.dao.RequestDAO;
import org.company.name.entity.Book;
import org.company.name.entity.Request;
import org.company.name.logic.Convert;
import org.company.name.logic.PageContentMaker;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ReturnBookCommand extends Command {
    private static ReturnBookCommand instance = new ReturnBookCommand();

    private ReturnBookCommand() {
    }

    public static ReturnBookCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Enumeration names = request.getParameterNames();
        logger.info("start ReturnBookCommand");
        BookDAO bookDAO = BookDAO.getInstance();
        RequestDAO requestDAO = RequestDAO.getInstance();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            if (!name.equals("command")) {
                String replaceAll = name.replaceAll("check", "");
                Request request1 = new Request();
                request1 = requestDAO.getRequestById(Convert.strToInt(replaceAll));
                request1.setId(Convert.strToInt(replaceAll));
                String status = request1.getStatus();
                request1.setStatus("close");
                RequestDAO.getInstance().update(request1);
                Book book = new Book();
                book = bookDAO.findBook(request1.getTitle());
                book.setStock(book.getStock() + 1);
                bookDAO.updateBookStock(book);
            }
        }
        PageContentMaker.getUserRequests(request);
        String page = ConfigurationManager.getProperty("path.page.myrequests");
        return page;
    }
}














