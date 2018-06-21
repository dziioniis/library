package org.company.name.logic.Command;

import org.company.name.dao.BookDAO;
import org.company.name.entity.Book;
import org.company.name.logic.Convert;
import org.company.name.manager.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddBookCommand extends Command {
    private static AddBookCommand instance = new AddBookCommand();

    private AddBookCommand() {
    }

    public static AddBookCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        logger.info("start AddBook command");

        try {
            Part filePart = req.getPart("file");
            getSubmittedFileName(filePart);
            String filename = getSubmittedFileName(filePart);
            String url = "./src/main/webapp/picture/" + filename;
            InputStream filecontent = filePart.getInputStream();
            Files.copy(filecontent, Paths.get(url));
            Book book = new Book();
            book.setAuthor(req.getParameter("author"));
            book.setGenre(req.getParameter("genre"));
            book.setName(req.getParameter("title"));
            book.setPageCount(Convert.strToInt(req.getParameter("pageCount")));
            book.setUrlImage("/picture/" + filename);
            book.setStock(Convert.strToInt(req.getParameter("stock")));
            book.setData(Convert.strToInt(req.getParameter("data")));
            BookDAO.getInstance().addBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        String page = ConfigurationManager.getProperty("path.page.admin");
        return page;
    }

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}


