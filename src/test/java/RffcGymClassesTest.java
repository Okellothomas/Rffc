import static org.junit.Assert.*;

public class RffcGymClassesTest {

    @org.junit.Test
    public void getId_true(){
        RffcGymClasses rfclasses = new RffcGymClasses(100, "Classic", "Kelvin");
        int rfclass_id = 100;
        assertEquals(rfclass_id, rfclasses.getC_id());
    }

    @org.junit.Test
    public void getClass_name_true() {
        RffcGymClasses rfclasses = new RffcGymClasses(100, "Classic", "Kelvin");
        String rf_name = "Classic";
        assertEquals(rf_name, rfclasses.getC_name());
    }

    @org.junit.Test
    public void getTutor_true() {
        RffcGymClasses rfclasses = new RffcGymClasses(100, "Classic", "Kelvin");
        String rf_tutor = "Kelvin";
        assertEquals(rf_tutor, rfclasses.getC_tutor());
    }

}