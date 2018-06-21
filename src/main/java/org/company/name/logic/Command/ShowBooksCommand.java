package org.company.name.logic.Command;

import org.company.name.logic.PageContentMaker;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBooksCommand extends Command {
    private static ShowBooksCommand instance = new ShowBooksCommand();

    private ShowBooksCommand() {
    }

    public static ShowBooksCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start showbooks command");
        PageContentMaker.getBooks(request);
        String page = ConfigurationManager.getProperty("path.page.books");
        return page;
    }
}
