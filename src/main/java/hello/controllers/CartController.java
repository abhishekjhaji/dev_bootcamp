package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
@Controller
public class CartController {

    @RequestMapping("/cart/{customerId}/checkout")
    public String checkout(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customerId",customerId);
        return "checkout";
    }


}
