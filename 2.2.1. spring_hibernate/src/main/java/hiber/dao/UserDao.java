package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user, Car car);

    void add(User user);

    User searchByModelAndSeries(String model, int series);

    List<User> listUsers();
}
