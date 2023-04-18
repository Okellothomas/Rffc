import java.io.*;
import java.util.ArrayList;

public class RffcGymEnrolment implements Serializable{

    // declear the variables for the RffcGymEnrolment class
    private int id;
    private String name, plan, type;

    // Empty constructor the class
    public RffcGymEnrolment() {
    }

    // Parametrised RffcGymeEnrolment constructor
    public RffcGymEnrolment(int id, String name, String plan, String type) {
        this.id = id;
        this.name = name;
        this.plan = plan;
        this.type = type;
    }

    // The setter and the getters methods.
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMember_id_id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }

    public String getType() {
        return type;
    }

    // RfcGymEnrolmentSerializer method implementation for the project
    public void RfcGymEnrolmentSerializer(RffcGymEnrolment rffcGymEnrolment)
    {
        ArrayList<RffcGymEnrolment> el;

        el = RffcGymEnrolmentDeseralizer();

        try {
            el.add(rffcGymEnrolment);
            FileOutputStream fo =
                    new FileOutputStream("enrolment.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(el);
            o.close();
            fo.close();
            System.out.printf("Subscriber enrolled successfully.");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // RffcGymEnrolmentDeseralizer method implementation in the project
    public ArrayList<RffcGymEnrolment> RffcGymEnrolmentDeseralizer()
    {
        ArrayList<RffcGymEnrolment> el = new ArrayList();
        try {
            FileInputStream fn = new FileInputStream("enrolment.ser");
            ObjectInputStream oi = new ObjectInputStream(fn);
            el =  (ArrayList<RffcGymEnrolment>) oi.readObject();
            oi.close();
            fn.close();
        } catch (IOException e) {
            System.out.println("Kindly enrolled!");
            return el;
        } catch (ClassNotFoundException e) {
            System.out.println("Enrolment class not found!");
            e.printStackTrace();
            return el;
        }

        System.out.println("Rffc Gym deserialized enrolments...");

        return el;
    }

    // RffcGymEnrolmentSerializerUpdated method implementation for the project
    public void RffcGymEnrolmentSerializerUpdated(ArrayList<RffcGymEnrolment> enrols_list)
    {
        try {
            FileOutputStream fo =
                    new FileOutputStream("enrolment.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(enrols_list);
            o.close();
            fo.close();
            System.out.printf("Subscriber successfully switched plans.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
