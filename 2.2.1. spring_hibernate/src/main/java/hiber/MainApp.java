package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addNewUserInList(new User("User1", "Lastname1", "user1@mail.ru"),
              new Car("car1", 1));
      userService.addNewUserInList(new User("User2", "Lastname2", "user2@mail.ru"),
              new Car("car2", 2));
      userService.addNewUserInList(new User("User3", "Lastname3", "user3@mail.ru"),
              new Car("car3", 3));
      userService.addNewUserInList(new User("User4", "Lastname4", "user4@mail.ru"),
              new Car("car4", 4));
      userService.addNewUserInList(new User("User5", "Lastname5", "user5@mail.ru"),
              new Car("car5", 5));

      List<User> users = userService.showListOfUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println();
      }
      try {
         System.out.println(userService.searchByModelAndSeries("car4", 3).toString());
      } catch (NoResultException e) {
         System.out.println(e.getMessage());
      }


      context.close();
   }
}
