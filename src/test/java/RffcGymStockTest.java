import org.junit.Test;

import static org.junit.Assert.*;

public class RffcGymStockTest {

    @Test
    public void getId_true() throws Exception {
        RffcGymStock stocs = new RffcGymStock(88, "Cloths", 89);
        int id = 88;
        assertEquals(id, stocs.getId());
    }

    @Test
    public void getStock_quantity_true() throws Exception {
        RffcGymStock stocs = new RffcGymStock(88, "Cloths", 89);
        String name = "Cloths";
        assertEquals(name, stocs.getName());
    }

    @Test
    public void getName_true() throws Exception{
        RffcGymStock stocs = new RffcGymStock(88, "Cloths", 89);
        int quantity = 89;
        assertEquals(quantity, stocs.getQnt());
    }

}