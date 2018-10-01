package my.mapkn3.Orders.dao;

import my.mapkn3.Orders.model.PrettyEntity;

import java.io.Serializable;
import java.util.List;

public interface PrettyEntityDao {
    Serializable save(PrettyEntity entity);

    <E extends PrettyEntity> E findById(Class<E> entityClass, Serializable id);

    List getAll(Class entityClass);

    <E extends PrettyEntity> E update(E entity);

    void delete(PrettyEntity entity);
}
