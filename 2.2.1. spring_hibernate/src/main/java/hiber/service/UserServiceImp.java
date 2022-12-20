package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void addNewUserInList(User user, Car car) {
      userDao.addNewUserInList(user, car);
   }

   @Transactional
   @Override
   public User searchByModelAndSeries(String model, int series) {
      return userDao.searchByModelAndSeries(model, series);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> showListOfUsers() {
      return userDao.showListOfUsers();
   }

}
