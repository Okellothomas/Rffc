import static org.junit.Assert.*;

public class RffcGymEnrolmentTest {

    @org.junit.Test
    public void getEnrol_id_true(){
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "John", "Fox", "Yoga");
        int id  = 1;
        assertEquals(id, enrol.getMember_id_id());
    }

    @org.junit.Test
    public void getName_true(){
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "John", "Fox", "Yoga");
        String name  = "John";
        assertEquals(name, enrol.getName());
    }

    @org.junit.Test
    public void getPlan_true() {
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "John", "Fox", "Yoga");
        String plan  = "Fox";
        assertEquals(plan, enrol.getPlan());
    }

    @org.junit.Test
    public void getType_true() {
        RffcGymEnrolment enrol = new RffcGymEnrolment(1, "John", "Fox", "Yoga");
        String type  = "Yoga";
        assertEquals(type, enrol.getType());
    }

}