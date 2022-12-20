package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addNewUserInList(User user, Car car) {
      user.setCar(car);
      sessionFactory.getCurrentSession().save(user);
   }
   @Override
   public User searchByModelAndSeries(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery("from User user where " +
              "car.model = :model and car.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return (User) query.getSingleResult();
   }

   @Override
   public List<User> showListOfUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
