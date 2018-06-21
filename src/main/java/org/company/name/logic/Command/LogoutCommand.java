package org.company.name.logic.Command;


import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand extends Command {
    private static LogoutCommand instance = new LogoutCommand();

    private LogoutCommand() {
    }

    public static LogoutCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start logout command");
        HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
