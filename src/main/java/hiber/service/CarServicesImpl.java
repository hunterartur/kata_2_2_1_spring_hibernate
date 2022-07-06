package hiber.service;

import hiber.dao.Dao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServicesImpl implements Services<Car, User> {

    private final Dao<Car, User> dao;

    public CarServicesImpl(@Qualifier("carDaoImpl") Dao<Car, User> dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void add(Car obj) {
        dao.add(obj);
    }

    @Transactional
    @Override
    public List<Car> getAll() {
        return dao.getAll();
    }

    @Transactional
    @Override
    public Car getBy(User obj) {
        return null;
    }
}
