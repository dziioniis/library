package org.company.name.logic.Command;

import org.apache.log4j.Logger;
import org.company.name.controller.MainServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
    static Logger logger = Logger.getLogger(MainServlet.class);

    public abstract String execute(HttpServletRequest request,
                                   HttpServletResponse response);
}
