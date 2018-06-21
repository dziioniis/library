package org.company.name.logic.Command;

import org.company.name.dao.UserDAO;
import org.company.name.entity.User;
import org.company.name.manager.ConfigurationManager;
import org.company.name.util.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends Command {
    private static RegisterCommand instance = new RegisterCommand();

    private RegisterCommand() {
    }

    public static RegisterCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start register command");
        String page;
        String name = request.getParameter("username");
        String mail = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        if (password.equals(passwordConfirm)) {
            User user = new User(name, MD5.md5(password), mail);
            UserDAO.getInstance().insertUser(user);
            HttpSession session = request.getSession(false);
            session.setAttribute("user", user);
            page = ConfigurationManager.getProperty("path.page.index");
        } else {
            page = ConfigurationManager.getProperty("path.page.error");
        }
        return page;
    }
}

