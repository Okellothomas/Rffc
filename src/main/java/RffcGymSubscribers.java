import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RffcGymSubscribers implements Serializable{


    // allowing users to input their data
    public transient Scanner getrffcgymusers = new Scanner(System.in);

    /*
      Initializing the variables for our project
     */
    private int id;
    private String name, faddress, fcity, femail, fplan;


    // The empty constructor
    public RffcGymSubscribers() {
    }


    /*
      The parametrised constructor
     */
    public RffcGymSubscribers(int id, String name, String faddress, String fcity, String femail) {
        this.id = id;
        this.name = name;
        this.faddress = faddress;
        this.fcity = fcity;
        this.femail = femail;

    }


    // The setters and getters methods for the project

    public void setFplan(String fplan) {
        this.fplan = fplan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public void setFcity(String fcity) {
        this.fcity = fcity;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFplan() {
        return fplan;
    }

    public String getFaddress() {
        return faddress;
    }

    public String getFcity() {
        return fcity;
    }

    public String getFemail() {
        return femail;
    }


    /*
      The RffcSignUp method implementation for the project
     */
    public void RffcSignUp()
    {
       System.out.println("--------------------------Rffc Sign Up for New Subscribers-----------------------------------\n");
        ArrayList<RffcGymSubscribers> l = RffcGymSubscriberDeserialization();
        ArrayList<Integer> il = new ArrayList<Integer>();
        for(RffcGymSubscribers memb: l)
        {
            il.add(memb.getId());
        }
        int id;
        String name, address, city, email,plan;


        System.out.println("Enter the rffc's new subscriber's id: ");
        id = getrffcgymusers.nextInt();
        if(il.contains(id))
        {
            System.out.println("A rffc subscriber with that id already exists.");
            RffcSignUp();
            System.exit(0);
        }
        System.out.println(("Enter the rffc's new subscriber's name: "));
        name = getrffcgymusers.next();

        System.out.println("Enter the rffc's new subscriber's current address");
        address = getrffcgymusers.next();

        System.out.println("Enter the rffc's new subscriber's current Email address: ");
        email = getrffcgymusers.next();

        System.out.println("Enter the rffc's new subscriber's current city: ");
        city = getrffcgymusers.next();
        if(id==0|name.equals("") | email.equals("")|address.equals("")|city.equals(""))
        {
            System.out.println("Kindly fill out all the field and try again!");
            RffcSignUp();
            System.exit(0);
        }
        RffcGymSubscribers rffcGymSubscribers = new RffcGymSubscribers(id,name,address,city,email);
        RffcGymSavingSubscribers(rffcGymSubscribers);
    }


    //RffcGymSubscriberSerialization method implementation for the project
    public static void RffcGymSubscriberSerialization(RffcGymSubscribers rffcGymSubscribers)
    {
        ArrayList<RffcGymSubscribers> ml;

        ml = RffcGymSubscriberDeserialization();

        try {
            ml.add(rffcGymSubscribers);
            FileOutputStream fo =
                    new FileOutputStream("members.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(ml);
            o.close();
            fo.close();
            System.out.printf("Rffc new subscriber successfully saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
      RffcGymSubscriberDeserialization method implementation for the project
     */
    public static ArrayList<RffcGymSubscribers> RffcGymSubscriberDeserialization()
    {
        ArrayList<RffcGymSubscribers> fgl = new ArrayList();
        try {
            FileInputStream fl = new FileInputStream("members.ser");
            ObjectInputStream pi = new ObjectInputStream(fl);
            fgl =  (ArrayList<RffcGymSubscribers>) pi.readObject();
            pi.close();
            fl.close();
        } catch (IOException e) {
            System.out.println("That is an invalid record");
            return fgl;
        } catch (ClassNotFoundException e) {
            System.out.println("The rffc subscriber class not found, kindly try again!");
            e.printStackTrace();
            return fgl;
        }

        System.out.println("The rffc gym subscriber deserialization...");


        return fgl;
    }

    // RffcGymSubscriberEnrolment method implementation for the project
    public void RffcGymSubscriberEnrolment()
    {
        ArrayList<RffcGymSubscribers> lis = RffcGymSubscriberDeserialization();
        ArrayList<Integer> il = new ArrayList<Integer>();
        for(RffcGymSubscribers rffcGymSubscribers : lis)
        {
            il.add(rffcGymSubscribers.getId());
        }
        int id;
        String name, type, plan;

        System.out.println("Enter rffc subscriber's id:");
        id = getrffcgymusers.nextInt();

        if(!il.contains(id))
        {
            System.out.println("You have entered an invalid subscriber's id, please sign the up the subscriber");
            RffcSignUp();
            RffcGymSubscriberEnrolment();
            System.exit(0);
        }


        System.out.println("Choose below your most preferred plan: ");
        System.out.println("Choose a plan as indicated below: \n" +
                "1. The basic plan - $9.99/month \n" +
                "\t->Equipments \n" +
                "\t->Guests - $10 per session - only equipments\n" +
                "2. The fox plan - 19.99/month\n" +
                "\t->Equipments\n" +
                "\t->Guest\n" +
                "\t->Free group fitness classes");
        plan = RffcGymAvailablePlans();
        System.out.println("Choose your most preferred class: ");
        System.out.println("The available plans are listed here: \n" +
                "1. Yoga \n" +
                "2. Zumba\n" +
                "3. Cardio\n");


        name = lis.get(il.indexOf(id)).getName();
        type = RffcGymAvailableClasses();

        RffcGymEnrolment e = new RffcGymEnrolment(id,name,plan,type);

        RffcGymSavingEnrolment(e);

    }

    // RffcGymAvailablePlans method implementation for the project.
    public  String RffcGymAvailablePlans()
    {
        System.out.println("Choose plan: ");
        int c = getrffcgymusers.nextInt();

        switch (c){
            case 1:
                return "Basic";
            case 2:
                return "Fox";
            default:
                System.out.println("Choice not available kindly choose from the available options");
                RffcGymAvailablePlans();
        }
        return null;
    }


    // RffcGymAvailableClasses method implementation for the project
    public  String RffcGymAvailableClasses()
    {
        System.out.println("Choose you preferred class of c: ");
        int c = getrffcgymusers.nextInt();

        if (c == 1){
            return "Yoga";
        }
        else if (c == 2){
            return "Zumba";
        }
        else if (c == 3){
            return "Cardio";
        }
        else {
            System.out.println("IChoice not available kindly choose from the available options");
            RffcGymAvailableClasses();
        }
        return null;
    }

    // RffcGymSubscriberList method implementation for the project.
    public void RffcGymSubscriberList()
    {
        ArrayList<RffcGymSubscribers> ol = new ArrayList();

        ol = RffcGymSubscriberDeserialization();

        for(RffcGymSubscribers rffcGymSubscribers : ol)
        {
            System.out.println("Rffc Gym subscriber name: "+ rffcGymSubscribers.getName()+"\nRffc Gym subscriber Email Address: "+ rffcGymSubscribers.getFemail()+"\n");
        }

    }

    /*
      RffcGymSavingSubscribers method implementation for the project
     */
    public void RffcGymSavingSubscribers(RffcGymSubscribers rffcGymSubscribers) {

        System.out.println("Press 1 to save and 2 to Cancel:\n1. Save now! \n2. Cancel now!");
        int act = getrffcgymusers.nextInt();


        switch (act){
            case 1:
                RffcGymSubscriberSerialization(rffcGymSubscribers);
                break;
            case 2:
                System.out.println("You have successfully cancelled the operation");
                break;
            default:
                System.out.println("Invalid choice, kindly choose from the available options!\n\n");
                RffcGymSavingSubscribers(rffcGymSubscribers);
        }
    }


    // RffcGymSavingEnrolment method implementation for the project
        public void RffcGymSavingEnrolment(RffcGymEnrolment rffcGymEnrolment)
        {

            RffcGymEnrolment en = new RffcGymEnrolment();
            System.out.println("Press 1 to save and 2 to Cancel:\n1. Confirm Enrolment now! \n2. Cancel enrolment now!");
            int act= getrffcgymusers.nextInt();

            switch (act){
                case 1:
                    en.RfcGymEnrolmentSerializer(rffcGymEnrolment);
                    break;
                case 2:
                    System.out.println("Operation cancelled successfully!");
                    break;
                default:
                    System.out.println("Invalid selection, Please select from the provided options!\n\n");
                    RffcGymSavingEnrolment(rffcGymEnrolment);
            }
    }

    // RffcGymSwitchingAvailablePlans method implementation for the project
    public void RffcGymSwitchingAvailablePlans()
    {
        System.out.println("---------------------------Switch in between the available Rffc Gym plans----------------\n");
        RffcGymEnrolment en = new RffcGymEnrolment();
        ArrayList<RffcGymEnrolment> l = en.RffcGymEnrolmentDeseralizer();

        ArrayList<Integer> il = new ArrayList<Integer>();
        for(RffcGymEnrolment enl: l)
        {
            il.add(enl.getMember_id_id());
        }
        int id;


        System.out.println("Enter Rffc gym subscriber id: ");
        id = getrffcgymusers.nextInt();
        if(!il.contains(id))
        {
            System.out.println("Invalid subscriber id, kindly enrol the subscriber.");
            RffcGymSubscriberEnrolment();
            System.exit(0);
        }
        RffcGymEnrolment otp = l.get(il.indexOf(id));
      System.out.println("Subscriber currently enrolled on Rffc Gym "+l.get(il.indexOf(id)).getPlan()+"plan" +
              " \n" +
              "1. Basic \n" +
              "2. Fox");
        String pc = RffcGymAvailablePlans();
        RffcGymEnrolment ue = new RffcGymEnrolment(id,otp.getName(),pc,otp.getType());

        l.remove(otp);
        l.add(ue);

        en.RffcGymEnrolmentSerializerUpdated(l);
    }

    // RffcGymCancellingAvailablePlans method implementation for the project
    public void RffcGymCancellingAvailablePlans()
    {
        System.out.println("--------------------Cancel the available Rffc Gym plan-----------------------------\n");
        RffcGymEnrolment en = new RffcGymEnrolment();
        ArrayList<RffcGymEnrolment> li = en.RffcGymEnrolmentDeseralizer();

        ArrayList<Integer> idl = new ArrayList<Integer>();
        for(RffcGymEnrolment enl: li)
        {
            idl.add(enl.getMember_id_id());
        }
        int id;

        System.out.println("Enter the rffc gym subscriber id: ");
        id = getrffcgymusers.nextInt();
        if(!idl.contains(id))
        {
            System.out.println("Invalid subscriber id, kindly enrol the subscriber.");
            RffcGymSubscriberEnrolment();
            System.exit(0);
        }
        RffcGymEnrolment object_to_update = li.get(idl.indexOf(id));
        System.out.println("Subscriber currently enrolled on Rffc Gym -"+li.get(idl.indexOf(id)).getPlan()+"- plan" +
                " \n Want to cancel the current plan? choose your preferred option" +
                "1. Confirm \n" +
                "2. Cancel");
        int ci = getrffcgymusers.nextInt();

        switch (ci){
            case 1:
                li.remove(object_to_update);
                en.RffcGymEnrolmentSerializerUpdated(li);
                break;
            case 2:
                System.out.println("Kindly pick from he available option!");
                System.exit(0);
                break;
            default:
                System.out.println("kindly choose from available options: ");
                RffcGymCancellingAvailablePlans();
        }
    }
}
