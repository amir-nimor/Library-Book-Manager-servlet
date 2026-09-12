package ir.maktabsharif.repository.BaseRepository;

import ir.maktabsharif.model.BaseModel;

import java.util.List;

public interface BaseRepository <T extends BaseModel<ID>,ID extends Number>{

    ID create(T t);

    T update(T t);

    T read(ID id);

    ID Delete(ID id);

    List<T> findAll();
}
