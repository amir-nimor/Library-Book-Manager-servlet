package ir.maktabsharif.servlet;

import ir.maktabsharif.exception.BusinessesException;
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
import java.math.BigInteger;

@WebServlet(name = "createBook",value = "/CreateBook")
public class BookServlet extends HttpServlet {

    private BookServiceImpl bookService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.bookService = (BookServiceImpl) super.getServletContext().getAttribute("bookService");
    }



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/page/createBook.jsp")
                .forward(req,resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        BigInteger price = BigInteger.valueOf(Integer.parseInt(req.getParameter("price")));

        Book book = new ir.maktabsharif.model.Book(title,author,category,price);
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            bookService.save(book);
            out.println(book);
        }catch (BusinessesException e){
            out.println("error   "+e.getMessage());
        }
    }
}
