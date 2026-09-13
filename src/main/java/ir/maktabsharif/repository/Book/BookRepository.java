package ir.maktabsharif.repository.Book;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;

import java.util.List;

public interface BookRepository extends BaseRepository<Book,Long> {

    List<Book> categoryBook();
}
