package org.company.name.logic.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandFactory {
    private HashMap<String, Command> commands;
    private static CommandFactory instance;

    private CommandFactory() {
        commands = new HashMap();
        commands.put("login", LoginCommand.getInstance());
        commands.put("logout", LogoutCommand.getInstance());
        commands.put("goToRegister", GoToRegisterCommand.getInstance());
        commands.put("register", RegisterCommand.getInstance());
        commands.put("search", SearchCommand.getInstance());
        commands.put("order", OrderCommand.getInstance());
        commands.put("ShowBooks", ShowBooksCommand.getInstance());
        commands.put("showMyRequest", GoToRequestsCommand.getInstance());
        commands.put("approve", ApproveCommand.getInstance());
        commands.put("returnBook", ReturnBookCommand.getInstance());
        commands.put("addBook", AddBookCommand.getInstance());
        commands.put("goToAddBook", GoToAddBookCommand.getInstance());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
        return command;
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }
}

