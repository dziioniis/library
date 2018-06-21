package org.company.name.logic.Command;

import org.company.name.logic.PageContentMaker;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToRequestsCommand extends Command {
    private static GoToRequestsCommand instance = new GoToRequestsCommand();

    private GoToRequestsCommand() {
    }

    public static GoToRequestsCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Start showmyRequest command");
        PageContentMaker.getUserRequests(request);
        String page = ConfigurationManager.getProperty("path.page.myrequests");
        return page;
    }
}
