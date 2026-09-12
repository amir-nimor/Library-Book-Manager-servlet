package ir.maktabsharif.repository.BaseRepository;

import ir.maktabsharif.exception.HiberanteException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>,ID extends Number> implements BaseRepository<T,ID>{

    private Class<T> entityClass;


    public BaseRepositoryImpl(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public ID create(T t) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                em.persist(t);
                return t.getId();
            });
        }catch (HiberanteException e){
            throw new RepositoryException("create operation is failed => "+e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                T DbEntity = em.find(entityClass,t.getId());
                change(t,DbEntity);
                return t;
            });
        }catch (HiberanteException e){
            throw new RepositoryException("update operation is failed => "+e.getMessage());
        }
    }

    @Override
    public T read(ID id) {
        try {
            return HibernateUtil.read(em -> {
                return em.find(entityClass,id);
            });
        }catch (HiberanteException e){
            throw new RepositoryException("read operation is failed => "+e.getMessage());
        }
    }

    @Override
    public ID Delete(ID id) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                em.remove(em.find(entityClass,id));
                return id;
            });
        }catch (HiberanteException e){
            throw new RepositoryException("delete operation is failed => "+e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("FROM "+entityClass.getSimpleName())
                        .getResultList();
            });
        }catch (HiberanteException e){
            throw new RepositoryException("find all operation is failed => "+e.getMessage());
        }
    }

    protected abstract void change(T enwEntity,T DbEntity);
}
