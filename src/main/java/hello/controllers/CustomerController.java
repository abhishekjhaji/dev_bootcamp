package hello.controllers;

import hello.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by manishkaatoch on 14/05/15.
 */
@Controller
public class CustomerController {

    @RequestMapping("/customer/{customerId}")
    public String checkout(@PathVariable Long customerId, Model model) {
        Customer customer = Customer.REPO.find(customerId);
        return customer.getEmailAddress();
    }
}
