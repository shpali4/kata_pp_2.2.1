package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void addNewUserInList(User user, Car car);

    User searchByModelAndSeries(String model, int series);

    List<User> showListOfUsers();
}
