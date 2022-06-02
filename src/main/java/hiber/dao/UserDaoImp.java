package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCar(Car car) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Car c where c.model=:car_model and c.series=:car_series");
        query.setParameter("car_model", car.getModel());
        query.setParameter("car_series", car.getSeries());
        List<Car> cars = query.getResultList();
        Query query1 = session.createQuery("from User u where u.car=:car_id");
        List<User> user = query1.setParameter("car_id", cars.get(0).getId()).getResultList();
        return user.get(0);
    }

}
