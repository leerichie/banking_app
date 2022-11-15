package lee.atm.mybankingapp.web;

import lee.atm.mybankingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    UserService userService;
    public MainController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/main_menu")
    public String home() {
        return "main_menu";
    }

    // withdraw
    @GetMapping("/withdraw")
    public String withdraw(Model model){
        model.addAttribute("fixedWithdrawAmounts", List.of(20, 50, 100, 250, 500));
        return "withdraw";
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amountOut) {
        System.out.println(amountOut);
        //pobierz repozytorium, dodaj nowa operacje, albo usun srodki na koncie
        return "redirect:/withdraw";
    }

    // deposit
    @GetMapping("/deposit")
    public String deposit(Model model){
        model.addAttribute("customDepositAmounts", List.of(20, 50, 100, 250, 500));
        return "deposit";
    }
    @PostMapping("/deposit")
    public String deposit(@RequestParam int amountIn){
        System.out.println(amountIn);
        return "redirect:/deposit";
    }

}
