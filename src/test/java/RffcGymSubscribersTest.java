import static org.junit.Assert.*;

public class RffcGymSubscribersTest {

    @org.junit.Test
    public void getId_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(1, "Peter","NyP street 09", "Indiana","indiana@gmail.com");
        int id = 1;
        assertEquals(id, subs.getId());
    }

    @org.junit.Test
    public void getName_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(1, "Peter","NyP street 09", "Indiana","indiana@gmail.com");
        String name = "Peter";
        assertEquals(name, subs.getName());
    }


    @org.junit.Test
    public void getAddress_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(1, "Peter","NyP street 09", "Indiana","indiana@gmail.com");
        String address = "NyP street 09";
        assertEquals(address, subs.getFaddress());
    }

    @org.junit.Test
    public void getCity_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(1, "Peter","NyP street 09", "Indiana","indiana@gmail.com");
        String city = "Indiana";
        assertEquals(city, subs.getFcity());
    }

    @org.junit.Test
    public void getEmail_true(){
        RffcGymSubscribers subs = new RffcGymSubscribers(1, "Peter","NyP street 09", "Indiana","indiana@gmail.com");
        String email = "indiana@gmail.com";
        assertEquals(email, subs.getFemail());
    }

}