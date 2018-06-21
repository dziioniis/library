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

public class ApproveCommand extends Command {
    private static ApproveCommand instance = new ApproveCommand();

    private ApproveCommand() {
    }

    public static ApproveCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start Approve Command");
        Enumeration names = request.getParameterNames();
        RequestDAO requestDAO = RequestDAO.getInstance();
        BookDAO bookDAO = BookDAO.getInstance();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            if (!name.equals("command")) {
                String replaceAll = name.replaceAll("check", "");
                Request requestApp = new Request();
                requestApp = requestDAO.getRequestById(Convert.strToInt(replaceAll));
                requestApp.setId(Convert.strToInt(replaceAll));
                String value = request.getParameterValues(name)[0];
                if (value.equals("reject")) {
                    value = "close";
                    requestApp.setStatus(value);
                    requestDAO.update(requestApp);
                    Book book = new Book();
                    book = bookDAO.findBook(requestApp.getTitle());
                    book.setStock(book.getStock() + 1);
                    bookDAO.updateBookStock(book);
                } else {
                    requestApp.setStatus(value);
                    requestDAO.update(requestApp);
                }
            }
        }
        PageContentMaker.getAllRequests(request);
        String page = ConfigurationManager.getProperty("path.page.admin");
        return page;
    }
}
