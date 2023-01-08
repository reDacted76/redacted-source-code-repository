package lynx.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String users(Model model) {
        model.addAttribute("module", "User Profile Module");
        model.addAttribute("title", "Users Controls Module");
        model.addAttribute("users",  userService.getAllUsers());
        return "users/index";
    }

    @RequestMapping("/add")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("module", "Add User");
        model.addAttribute("title", "Add System User");
        return "users/add";
    }

    @GetMapping("/users")
    public String getAllPages(Model model) {
        return getPage(model, 1);
    }

    @GetMapping("users/{pageNumber}")
    public String getPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<User> page = userService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<User> users = page.getContent();
        model.addAttribute("module", "User Profile Module");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("users", users);
        return "users/index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("module", "Edit User");
        model.addAttribute("title", "Edit System User");
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @RequestMapping("/delete")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:";
    }
}
