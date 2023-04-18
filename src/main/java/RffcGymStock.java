import java.io.*;
import java.util.ArrayList;

public class RffcGymStock {

    // Declaring variables for the RffcGymStock class
    private int id, qnt;
    private String name;

    // Empty Constructor for GymStock
    public RffcGymStock() {
    }

    // Paramtrised Constructor for GymStock
    public RffcGymStock(int id, String name, int qnt) {
        this.id = id;
        this.name = name;
        this.qnt = qnt;
    }

    // The setter and getters method implementation for the project
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // RffcGymStockSerializer method implementation for the RffcGymStock class
    public static void RffcGymStockSerializer(ArrayList<RffcGymStock> product_list)
    {

        try {

            FileOutputStream fo =
                    new FileOutputStream("rffcproducts.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(product_list);
            o.close();
            fo.close();
            System.out.printf("Schedule successfully generated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // RffcGymStockDeserializer method implementation for the RffcGymStock class
    public static ArrayList<RffcGymStock> RffcGymStockDeserializer()
    {
        ArrayList<RffcGymStock> prodList= new ArrayList();
        try {
            FileInputStream fl = new FileInputStream("rffcproducts.ser");
            ObjectInputStream oi = new ObjectInputStream(fl);
            prodList =  (ArrayList<RffcGymStock>) oi.readObject();
            oi.close();
            fl.close();
        } catch (IOException e) {
            System.out.println("Product not available presently! check later");
            return prodList;
        } catch (ClassNotFoundException c) {
            System.out.println("Member class not available presently, check later");
            c.printStackTrace();
            return prodList;
        }

        System.out.println("Rffc Gym deserialized products...");

        return prodList;
    }

}
