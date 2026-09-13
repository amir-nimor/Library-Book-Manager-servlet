package ir.maktabsharif.service.Book;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.service.BaseService.BaseService;

import java.util.List;

public interface BookService extends BaseService<Book,Long> {

    List<Book> categoryBook();
}
