package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid User user, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "user/register";
        }
        userDao.save(user);

        //Save user to session
        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String homePage(){
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletRequest request){
        if(email.length() > 0 && password.length() > 0){
            User user = userDao.findByEmail(email);
            if(user != null && BCrypt.checkpw(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return "/home/index";
            }
        }
        return "user/login";
    }

    //tymczasowa akcja do usuwania uzytkownika

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        User user = userDao.findOne(id);
        String mail = user.getEmail();
        userDao.delete(user);
        return "User with mail: "+mail+" and id: "+id+" was deleted;";
    }
}
