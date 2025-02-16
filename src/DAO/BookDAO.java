package DAO;

import models.Book;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookDAO {
    private static BookDAO instance;
    ArrayList<Book> books;

    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();

        }
        return instance;
    }

    private BookDAO() {
        books = new ArrayList<>();
    }

    public void add(Book b){
        books.add(b);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getBooksByType(int type) {
        return (ArrayList<Book>) books.stream().filter(b -> b.getRoomType() == type).collect(Collectors.toCollection(ArrayList::new));
    }

}
