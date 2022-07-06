package hiber.service;

import hiber.dao.Dao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements Services<User, Car> {

   private Dao dao;

   public UserServiceImp(@Qualifier("userDaoImp") Dao dao) {
      this.dao = dao;
   }

   @Transactional
   @Override
   public void add(User user) {
      dao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getAll() {
      return dao.getAll();
   }

   @Override
   public User getBy(Car obj) {
      return (User) dao.getBy(obj);
   }

}
