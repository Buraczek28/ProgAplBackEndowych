package ProgAplBackEndowych.library.controller;

import ProgAplBackEndowych.library.BookRepository;
import ProgAplBackEndowych.library.model.UsersModel;
import ProgAplBackEndowych.library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {


    private final UsersService usersService;

    @Autowired
    BookRepository bookRepository;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {
        System.out.println("register request: " + usersModel);
        UsersModel registeredUser = usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("login request: " + usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/tabele")
    public ModelAndView dataShow() {

        ModelAndView mv = new ModelAndView("Book");
        mv.addObject("booksKey", bookRepository.getAll());
        mv.setViewName("tabele");

        return mv;
    }

    @GetMapping("/tabele2")
    public ModelAndView dataShow2() {

        ModelAndView mv = new ModelAndView("Audiobook");
        mv.addObject("booksKey2", bookRepository.getAll());
        mv.setViewName("tabele2");

        return mv;
    }


}
