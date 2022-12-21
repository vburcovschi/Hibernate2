package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class GenericDAO <T>{
    private final Class<T> clazz;

    private SessionFactory sessionFactory;
    public GenericDAO(final Class<T> clazzToSet, SessionFactory sessionFactory){
        this.clazz = clazzToSet;
        this.sessionFactory = sessionFactory;
    }

    public T getById(final int id){
       return (T) getCurrentSession().get(clazz,id);
    }

    public List<T> getItems (int offset, int count){
        Query query = getCurrentSession().createQuery("from "+ clazz.getName(),clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    public List<T> findAll (){
       return getCurrentSession().createQuery("from "+ clazz.getName(),clazz).list();
    }

    public T save (final T entity){
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update (final T entity){
        getCurrentSession().merge(entity);
        return entity;
    }

    public void delete(final T entity){
        getCurrentSession().delete(entity);
    }

    public void deleteById(final int entityId){
        final T entity = getById(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
