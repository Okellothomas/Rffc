import static org.junit.Assert.*;

public class RffcGymSubscribersTest {

    @org.junit.Test
    public void getId_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(2, "Kelvin","New Yolk City", "New Yolk","kev@gmail.com");
        int id = 2;
        assertEquals(id, subs.getId());
    }

    @org.junit.Test
    public void getName_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(2, "Kelvin","New Yolk City", "New Yolk","kev@gmail.com");
        String name = "Kelvin";
        assertEquals(name, subs.getName());
    }


    @org.junit.Test
    public void getAddress_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(2, "Kelvin","New Yolk City", "New Yolk","kev@gmail.com");
        String address = "New Yolk City";
        assertEquals(address, subs.getFaddress());
    }

    @org.junit.Test
    public void getCity_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(2, "Kelvin","New Yolk City", "New Yolk","kev@gmail.com");
        String city = "New Yolk";
        assertEquals(city, subs.getFcity());
    }

    @org.junit.Test
    public void getEmail_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(2, "Kelvin","New Yolk City", "New Yolk","kev@gmail.com");
        String email = "kev@gmail.com";
        assertEquals(email, subs.getFemail());
    }

}