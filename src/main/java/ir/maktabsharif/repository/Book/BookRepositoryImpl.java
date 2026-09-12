package ir.maktabsharif.repository.Book;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Long> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    protected void change(Book enwEntity, Book DbEntity) {
        DbEntity.setTitle(enwEntity.getTitle());
        DbEntity.setAuthor(enwEntity.getAuthor());
        DbEntity.setCategory(enwEntity.getCategory());
        DbEntity.setPrice(enwEntity.getPrice());
    }
}
