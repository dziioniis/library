package org.company.name.logic.Command;


import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToRegisterCommand extends Command {
    private static GoToRegisterCommand instance = new GoToRegisterCommand();

    private GoToRegisterCommand() {
    }

    public static GoToRegisterCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start GoToRegister command");
        String page = ConfigurationManager.getProperty("path.page.register");
        return page;
    }
}
