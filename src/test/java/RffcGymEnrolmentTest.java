import static org.junit.Assert.*;

public class RffcGymEnrolmentTest {

    @org.junit.Test
    public void getEnrol_id_true(){
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "Zedy", "Fox", "Yoga");
        int id  = 1;
        assertEquals(id, enrol.getMember_id_id());
    }

    @org.junit.Test
    public void getName_true(){
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "Zedy", "Fox", "Yoga");
        String name  = "Zedy";
        assertEquals(name, enrol.getName());
    }

    @org.junit.Test
    public void getPlan_true() throws Exception{
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "Zedy", "Fox", "Yoga");
        String plan  = "Fox";
        assertEquals(plan, enrol.getPlan());
    }

}