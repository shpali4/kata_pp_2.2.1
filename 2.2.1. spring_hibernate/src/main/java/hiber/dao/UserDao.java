package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void addNewUserInList(User user, Car car);

    User searchByModelAndSeries(String model, int series);

    List<User> showListOfUsers();
}
