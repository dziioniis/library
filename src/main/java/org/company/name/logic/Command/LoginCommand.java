package org.company.name.logic.Command;

import org.company.name.dao.UserDAO;
import org.company.name.entity.User;
import org.company.name.logic.PageContentMaker;
import org.company.name.manager.ConfigurationManager;
import org.company.name.util.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends Command {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static LoginCommand instance = new LoginCommand();

    private LoginCommand() {
    }

    public static LoginCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        logger.info("Start login command");
        String username = request.getParameter(USERNAME);
        String pass = MD5.md5(request.getParameter(PASSWORD));
        HttpSession session = request.getSession(false);
        User user = UserDAO.getInstance().findUser(username);
        if (user == null) {
            page = ConfigurationManager.getProperty("path.page.error");
        } else if (user.getPass().equals(pass)) {
            if (user.getName().equals("admin")) {
                session.setAttribute("user", user);
                PageContentMaker.getAllRequests(request);
                page = ConfigurationManager.getProperty("path.page.admin");
            } else {
                session.setAttribute("user", user);
                PageContentMaker.getAllGenres(request);
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.error");
        }
        return page;
    }
}