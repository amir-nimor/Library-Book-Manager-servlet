package ir.maktabsharif.servlet;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.service.Book.BookServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "allBook", value = "/allBook")
public class allBook extends HttpServlet {

    private BookServiceImpl bookService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bookService = (BookServiceImpl) super.getServletContext().getAttribute("bookService");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<Book> books = bookService.findAll();

        PrintWriter out = resp.getWriter();

        out.println("<center><ul>");

        for (Book b : books) {
            out.println("<li>" + b + "</li>");
        }

        out.println("</ul></center>");

    }

}
