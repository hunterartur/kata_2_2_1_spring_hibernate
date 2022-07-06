package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements Dao<User, Car> {


    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getBy(Car car) {
        Session session = sessionFactory.getCurrentSession();
        Car realCar = session
                .createQuery("from Car c where c.model=:car_model and c.series=:car_series", Car.class)
                .setParameter("car_model", car.getModel())
                .setParameter("car_series", car.getSeries())
                .getSingleResult();
        return realCar.getUser();
    }


}
