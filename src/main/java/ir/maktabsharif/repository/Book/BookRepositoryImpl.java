package ir.maktabsharif.repository.Book;

import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

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

    @Override
    public List<Book> categoryBook() {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("category")
                        .getResultList();
            });
        } catch (RuntimeException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
