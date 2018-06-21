package org.company.name.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private long id;
    private String name;
    private int pageCount;
    private String genre;
    private String author;
    private int data;
    private String urlImage;
    private int stock;

}
