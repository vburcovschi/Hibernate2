package dao;

import entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class RentalDAO extends GenericDAO<Rental>{
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyUnreturnedRental() {
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null");
        query.setMaxResults(1);
        return  query.getSingleResult();
    }
}
