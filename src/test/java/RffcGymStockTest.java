import org.junit.Test;

import static org.junit.Assert.*;

public class RffcGymStockTest {

    @Test
    public void getId_true() {
        RffcGymStock stocs = new RffcGymStock(1, "shoes", 1);
        int id = 1;
        assertEquals(id, stocs.getId());
    }

    @Test
    public void getStock_quantity_true() {
        RffcGymStock stocs = new RffcGymStock(1, "shoes", 1);
        String name = "shoes";
        assertEquals(name, stocs.getName());
    }

    @Test
    public void getName_true() {
        RffcGymStock stocs = new RffcGymStock(1, "shoes", 1);
        int quantity = 1;
        assertEquals(quantity, stocs.getQnt());
    }

}