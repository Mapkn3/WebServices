package my.mapkn3.Orders.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import my.mapkn3.Orders.model.PrettyEntity;

import java.io.Serializable;
import java.util.List;

@Repository
public class PrettyEntityDaoImpl implements PrettyEntityDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public Serializable save(PrettyEntity entity) {
        return getSession().save(entity);
    }

    @Override
    public <E extends PrettyEntity> E findById(Class<E> entityClass, final Serializable id) {
        return getSession().get(entityClass, id);
    }

    @Override
    public List getAll(Class entityClass) {
        String hql = "From " + entityClass.getSimpleName();
        return getSession().createQuery(hql).getResultList();
    }

    @Override
    public <E extends PrettyEntity> E update(E entity) {
        return (E) getSession().merge(entity);
    }

    @Override
    public void delete(PrettyEntity entity) {
        getSession().delete(entity);
    }
}
