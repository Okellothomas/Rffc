import java.io.*;
import java.util.ArrayList;

public class RffcGymClasses implements Serializable{

    //variable declaration
    private int c_id;
    private String c_name, c_tutor;


    // The empty Classes constructor
    public RffcGymClasses() {
    }


    // The inflated Classes constructor
    public RffcGymClasses(int c_id, String c_name, String c_tutor) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_tutor = c_tutor;
    }


    //The setter and getters methods implementation
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_tutor() {
        return c_tutor;
    }

    public void setC_tutor(String c_tutor) {
        this.c_tutor = c_tutor;
    }


    public void scheduleGenerator()
    {
        ArrayList<String> tutors = new ArrayList();
        ArrayList<String> classNames = new ArrayList();

        tutors.add("Kevin");
        tutors.add("Samwel");
        tutors.add("Peter");
        tutors.add("Kennedy");
        tutors.add("John");
        tutors.add("Judah");
        tutors.add("Elizabeth");
        tutors.add("Sharon");
        classNames.add("Cardio");
        classNames.add("Yoga");
        classNames.add("Zumba");

        ArrayList<RffcGymClasses> fl = new ArrayList();

       for(int i = 0;i<=42;i++)
       {
           RffcGymClasses gym_class = new RffcGymClasses(i+1, classNames.get(0 + (int)(Math.random() * ((2 - 0) + 1))),tutors.get(0 + (int)(Math.random() * ((7 - 0) + 1))));


           fl.add(gym_class);
       }

       RffcGymscheduleSerializer(fl);


    }

    // RffcGymscheduleSerializer method implementation for the project
    public static void RffcGymscheduleSerializer(ArrayList<RffcGymClasses> schedule)
    {
        try {

            FileOutputStream fo =
                    new FileOutputStream("schedule.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(schedule);
            o.close();
            fo.close();
            System.out.printf("Schedule generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // RffcGymscheduledeserializer method implementation for the project
    public static ArrayList<RffcGymClasses> RffcGymscheduledeserializer()
    {
        ArrayList<RffcGymClasses> cl = new ArrayList();
        try {
            FileInputStream fl = new FileInputStream("schedule.ser");
            ObjectInputStream oi = new ObjectInputStream(fl);
            cl =  (ArrayList<RffcGymClasses>) oi.readObject();
            oi.close();
            fl.close();
        } catch (IOException e) {
            System.out.println("Schedule not available");
            return cl;
        } catch (ClassNotFoundException e) {
            System.out.println("member class not available");
            e.printStackTrace();
            return cl;
        }

        System.out.println("Rffc Gym deserialized member...");


        return cl;
    }

    // RffcGymdisplaySchedule method implementation for the project
    public void RffcGymdisplaySchedule()
    {
        ArrayList<RffcGymClasses> sc =  RffcGymscheduledeserializer();

        System.out.println("---------------------Rffc Gym class Schedule for this Month-------------------" +
                        "\nMonday\n" +
                        "\t-  8.00 - 9.00 am \t\t"+sc.get(0).c_name +"("+sc.get(0).getC_tutor()+")\n" +
                        "\t-  9.00 - 10.00 am : No Class\n"+
                        "\t-  11.00 - 12.00 am \t\t"+sc.get(1).c_name +"("+sc.get(1).getC_tutor()+")\n" +
                        "\t-  2.00 - 3.00 pm \t\t"+sc.get(2).c_name +"("+sc.get(2).getC_tutor()+")\n" +
                        "\t-  5.00 - 6.00 pm \t\t"+sc.get(2).c_name +"("+sc.get(3).getC_tutor()+")\n" +
                        "\t-  7.00 - 8.00 pm \t\t"+sc.get(4).c_name +"("+sc.get(4).getC_tutor()+")\n" +
                        "\t-  8.00 - 9.00 pm \t\t"+sc.get(5).c_name +"("+sc.get(5).getC_tutor()+")\n"
        );

                System.out.println("\n\n-" +
                "\nTuesday\n" +
                "\t-  8.00 - 9.00 am \t\t"+sc.get(6).c_name +"("+sc.get(6).getC_tutor()+")\n" +
                "\t-  9.00 - 10.00 am : No Class\n"+
                "\t-  11.00 - 12.00 am \t\t"+sc.get(7).c_name +"("+sc.get(7).getC_tutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+sc.get(8).c_name +"("+sc.get(8).getC_tutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+sc.get(9).c_name +"("+sc.get(9).getC_tutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+sc.get(10).c_name +"("+sc.get(10).getC_tutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+sc.get(11).c_name +"("+sc.get(11).getC_tutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nWednesday\n" +
                "\t-  8.00 - 9.00 am \t\t"+sc.get(12).c_name +"("+sc.get(12).getC_tutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+sc.get(13).c_name +"("+sc.get(13).getC_tutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+sc.get(14).c_name +"("+sc.get(14).getC_tutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+sc.get(15).c_name +"("+sc.get(15).getC_tutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+sc.get(16).c_name +"("+sc.get(16).getC_tutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+sc.get(17).c_name +"("+sc.get(17).getC_tutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+sc.get(18).c_name +"("+sc.get(18).getC_tutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nThursday\n" +
                "\t-  8.00 - 9.00 am \t\t"+sc.get(19).c_name +"("+sc.get(19).getC_tutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+sc.get(20).c_name +"("+sc.get(20).getC_tutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+sc.get(21).c_name +"("+sc.get(21).getC_tutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+sc.get(22).c_name +"("+sc.get(22).getC_tutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+sc.get(23).c_name +"("+sc.get(23).getC_tutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+sc.get(24).c_name +"("+sc.get(24).getC_tutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+sc.get(25).c_name +"("+sc.get(25).getC_tutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nFriday\n" +
                "\t-  8.00 - 9.00 am \t\t"+sc.get(26).c_name +"("+sc.get(26).getC_tutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+sc.get(27).c_name +"("+sc.get(27).getC_tutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+sc.get(28).c_name +"("+sc.get(28).getC_tutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+sc.get(29).c_name +"("+sc.get(29).getC_tutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+sc.get(30).c_name +"("+sc.get(30).getC_tutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\t"+sc.get(31).c_name +"("+sc.get(31).getC_tutor()+")\n" +
                "\t-  8.00 - 9.00 pm \t\t"+sc.get(32).c_name +"("+sc.get(32).getC_tutor()+")\n"

        );

        System.out.println("\n\n-" +
                "\nSunday\n" +
                "\t-  8.00 - 9.00 am \t\t"+sc.get(33).c_name +"("+sc.get(33).getC_tutor()+")\n" +
                "\t-  9.00 - 10.00 am :\t\t"+sc.get(34).c_name +"("+sc.get(34).getC_tutor()+")\n" +
                "\t-  11.00 - 12.00 am \t\t"+sc.get(35).c_name +"("+sc.get(35).getC_tutor()+")\n" +
                "\t-  2.00 - 3.00 pm \t\t"+sc.get(36).c_name +"("+sc.get(36).getC_tutor()+")\n" +
                "\t-  5.00 - 6.00 pm \t\t"+sc.get(37).c_name +"("+sc.get(37).getC_tutor()+")\n" +
                "\t-  7.00 - 8.00 pm \t\tNo class\n"+
                "\t-  8.00 - 9.00 pm \t\tNo Class"

        );
    }

}
