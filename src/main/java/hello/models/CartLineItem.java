package hello.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by manishkaatoch on 14/05/15.
 */

@Table(name="CartLineItem")
@Entity
public class CartLineItem {
    @Id
    private int lineItemId;
    @Id
    private String productName;
    @Id
    private int quantity;

}
