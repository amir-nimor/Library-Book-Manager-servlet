package ir.maktabsharif.service.BaseService;

import ir.maktabsharif.exception.BusinessesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;

import java.util.List;

public abstract class BaseServiceImpl <T extends BaseModel<ID>,ID extends Number,R extends BaseRepository<T,ID>> implements BaseService<T,ID>{


    private R repository;

    public BaseServiceImpl(R repository){
        this.repository = repository;
    }

    @Override
    public ID save(T t) {
        try {
            validation(t);
            return repository.create(t);
        } catch (ValidationException | RepositoryException e) {
            throw new  BusinessesException(e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            validation(t);
            return repository.update(t);
        } catch (ValidationException | RepositoryException e) {
            throw new  BusinessesException(e.getMessage());
        }
    }

    @Override
    public T findById(ID id) {
        try {
            return repository.read(id);
        } catch (RepositoryException e) {
            throw new  BusinessesException(e.getMessage());
        }
    }

    @Override
    public ID Delete(ID id) {
        try {
            return repository.Delete(id);
        } catch (RepositoryException e) {
            throw new  BusinessesException(e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return repository.findAll();
        } catch (RepositoryException e) {
            throw new  BusinessesException(e.getMessage());
        }
    }

    protected abstract void validation(T t)throws ValidationException;
}
