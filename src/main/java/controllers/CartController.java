package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by abhishekkumarjha on 13/05/15.
 */
@Controller
public class CartController {

    @RequestMapping("/cart/checkout/")
    public String checkout() {
        return "customerId" + " hellos";
    }


}
