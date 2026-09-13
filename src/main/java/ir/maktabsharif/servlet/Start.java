package ir.maktabsharif.servlet;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.service.Book.BookServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.math.BigInteger;

@WebListener
public class Start implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BookServiceImpl bookService = new BookServiceImpl();


        Book book1 = new Book("The Alchemist", "Paulo Coelho", "Novel", BigInteger.valueOf(150000));
        Book book2 = new Book("1984", "George Orwell", "Dystopian", BigInteger.valueOf(180000));
        Book book3 = new Book("Clean Code", "Robert C. Martin", "Programming", BigInteger.valueOf(320000));
        Book book4 = new Book("Java Basics", "Herbert Schildt", "Programming", BigInteger.valueOf(280000));
        Book book5 = new Book("Harry Potter", "J.K. Rowling", "Fantasy", BigInteger.valueOf(250000));
        Book book6 = new Book("The Hobbit", "J.R.R. Tolkien", "Programming", BigInteger.valueOf(220000));
        Book book7 = new Book("Animal Farm", "George Orwell", "Political Fiction", BigInteger.valueOf(170000));
        Book book8 = new Book("Effective Java", "Joshua Bloch", "Programming", BigInteger.valueOf(350000));
        Book book9 = new Book("Pride and Prejudice", "Jane Austen", "Programming", BigInteger.valueOf(190000));
        Book book10 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", BigInteger.valueOf(160000));


        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
        bookService.save(book6);
        bookService.save(book7);
        bookService.save(book8);
        bookService.save(book9);
        bookService.save(book10);

        sce.getServletContext().setAttribute("bookService", bookService);

    }
}
