import static org.junit.Assert.*;

public class RffcGymClassesTest {

    @org.junit.Test
    public void getId_true(){
        RffcGymClasses rfclasses = new RffcGymClasses(1, "Class", "Peter");
        int rfclass_id = 1;
        assertEquals(rfclass_id, rfclasses.getC_id());
    }

    @org.junit.Test
    public void getClass_name_true() {
        RffcGymClasses rfclasses = new RffcGymClasses(1, "Class", "Peter");
        String rf_name = "Class";
        assertEquals(rf_name, rfclasses.getC_name());
    }

    @org.junit.Test
    public void getTutor_true() {
        RffcGymClasses rfclasses = new RffcGymClasses(1, "Class", "Peter");
        String rf_tutor = "Peter";
        assertEquals(rf_tutor, rfclasses.getC_tutor());
    }

}