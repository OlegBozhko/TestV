package com.testForJR.controller;

import com.testForJR.service.UserService;
import org.apache.log4j.Logger;
import com.testForJR.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name="userService")
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        logger.debug("Received request to show all users");
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "userspage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        logger.debug("Received request to show add page");
        // Создает новую персону и добавляет ее в модель
        // Это возвращающая форма
        model.addAttribute("userAttribute", new User());
        // перенаправление на страницу Добавления
        return "addpage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user) {
        logger.debug("Received request to add new user");
        userService.add(user);
        return "addedpage";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
        logger.debug("Received request to delete existing user");
        userService.delete(id);
        model.addAttribute("id", id);
        return "deletedpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {
        logger.debug("Received request to show edit page");
        model.addAttribute("userAttribute", userService.get(id));
        return "editpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model) {
        logger.debug("Received request to update user");
        user.setId(id);
        userService.edit(user);
        model.addAttribute("id", id);
        return "editedpage";
    }

    @RequestMapping(value = "/searchContacts", method = RequestMethod.POST)
    public String searchContacts(@RequestParam(required = false, defaultValue="") String name, Model model)
    {
        List<User> users = userService.searchUserByName(name);
        model.addAttribute("users", users);
        return "searchcontacts";
    }

}