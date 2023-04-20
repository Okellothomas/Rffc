import org.junit.Test;

import static org.junit.Assert.*;

public class RffcProductTest {

    @Test
    public void getId_true() {
        RffcProduct pros = new RffcProduct(1, "shoes", 1);
        int id = 1;
        assertEquals(id, pros.getId());
    }

    @Test
    public void getStock_quantity_true() {
        RffcProduct pros = new RffcProduct(1, "shoes", 1);
        String name = "shoes";
        assertEquals(name, pros.getRfcc_stock_name());
    }

    @Test
    public void getName_true(){
        RffcProduct pros = new RffcProduct(1, "Shirts", 1);
        int quantity = 1;
        assertEquals(quantity, pros.getStock_quantity());
    }

}