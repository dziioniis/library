package org.company.name.logic.Command;

import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToAddBookCommand extends Command {
    private static GoToAddBookCommand instance = new GoToAddBookCommand();

    private GoToAddBookCommand() {
    }

    public static GoToAddBookCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start goToAddBook command");
        String page = ConfigurationManager.getProperty("path.page.addBook");
        return page;
    }
}
