package ir.maktabsharif.service.BaseService;

import ir.maktabsharif.model.BaseModel;

import java.util.List;

public interface BaseService <T extends BaseModel<ID>,ID extends Number>{

    ID save(T t);

    T update(T t);

    T findById(ID id);

    ID Delete(ID id);

    List<T> findAll();
}
