package repositaries;

import models.Customer;

/**
 * Created by abhishekkumarjha on 13/05/15.
 */
public class CustomerRepository {


    public static Customer findById(int customerId) {
        return new Customer(2,"test@email.com");
    }
}
