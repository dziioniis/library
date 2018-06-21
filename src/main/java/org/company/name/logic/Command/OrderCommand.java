package org.company.name.logic.Command;

import org.company.name.dao.BookDAO;
import org.company.name.dao.RequestDAO;
import org.company.name.entity.Book;
import org.company.name.entity.Request;
import org.company.name.entity.User;
import org.company.name.logic.Convert;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class OrderCommand extends Command {
    private static OrderCommand instance = new OrderCommand();

    private OrderCommand() {
    }

    public static OrderCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("start to order command");
        String result = "";
        HttpSession session = request.getSession(false);
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = request.getParameterValues(name)[0];
            if (!value.equals("order")) {
                result = result + value;
            }
        }
        User user = (User) request.getSession().getAttribute("user");
        String[] split = result.split("checkbox");
        BookDAO bookDAO = BookDAO.getInstance();
        for (int a = 1; a < split.length; a++) {
            Book book = bookDAO.findBookById(Convert.strToInt(split[a]));
           Request bookRequest = new Request(book.getName(), user.getName(), "OPEN", book.getId());
            RequestDAO.getInstance().addBookRequest(bookRequest);
            book.setStock(book.getStock() - 1);
            bookDAO.updateBookStock(book);
        }
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
