package ir.maktabsharif.service.Book;

import ir.maktabsharif.exception.BusinessesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.Book.BookRepository;
import ir.maktabsharif.repository.Book.BookRepositoryImpl;
import ir.maktabsharif.service.BaseService.BaseServiceImpl;
import ir.maktabsharif.util.Rule;

import java.math.BigInteger;
import java.util.List;

public class BookServiceImpl extends BaseServiceImpl<Book,Long, BookRepository> implements BookService {

    private BookRepositoryImpl bookRepository;

    public BookServiceImpl() {
        super(new BookRepositoryImpl());
        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    protected void validation(Book book) throws ValidationException {
        Rule.check(book.getTitle().isBlank(),"your title is empty !");
        Rule.check(book.getAuthor().isBlank(),"your author is empty !");
        Rule.check(book.getCategory().isBlank(),"your category is empty !");
        Rule.check(book.getPrice().compareTo(BigInteger.ZERO) < 0,"your price is negative !");
    }

    @Override
    public List<Book> categoryBook() {
        try {
            return bookRepository.categoryBook();
        } catch (RepositoryException e) {
            throw new BusinessesException(e.getMessage());
        }
    }
}
