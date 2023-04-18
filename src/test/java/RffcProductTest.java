import org.junit.Test;

import static org.junit.Assert.*;

public class RffcProductTest {

    @Test
    public void getId_true() throws Exception {
        RffcProduct pros = new RffcProduct(1, "Shirts", 30);
        int id = 1;
        assertEquals(id, pros.getId());
    }

    @Test
    public void getStock_quantity_true() throws Exception {
        RffcProduct pros = new RffcProduct(1, "Shirts", 30);
        String name = "Shirts";
        assertEquals(name, pros.getRfcc_stock_name());
    }

    @Test
    public void getName_true() throws Exception {
        RffcProduct pros = new RffcProduct(1, "Shirts", 30);
        int quantity = 30;
        assertEquals(quantity, pros.getStock_quantity());
    }

}