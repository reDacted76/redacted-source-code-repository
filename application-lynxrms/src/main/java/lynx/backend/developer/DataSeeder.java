//package lynx.backend.developer;
//
//import io.lynxrms.backend.user.User;
//import io.lynxrms.backend.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        User user = new User("jack","password","smith@lynxrm.io");
//        userService.saveUser(new User("SYSTEM","password","developer@lynxrm.io"));
//        userService.saveUser(user);
//        userService.saveUser(new User("dave","password","dave@lynxrm.io"));
//        userService.saveUser(new User("smith","password","smith@lynxrm.io"));
//        userService.saveUser(new User("bob","password","bob@lynxrm.io"));
//        userService.saveUser(new User("sam","password","sam@lynxrm.io"));
//        System.out.println("TEST USER DATA SEEDED");
//    }
//}

