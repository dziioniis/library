package org.company.name.dao.interfaceCRUD;

import org.company.name.entity.Book;

import java.util.List;

public interface BookCRUD {
    Book findBook(String name);

    boolean updateBookStock(Book book);

    void addBook(Book book);

    List<Book> getBooksFromGenre(String genre);
}
