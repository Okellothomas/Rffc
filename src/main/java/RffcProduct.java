import java.io.*;
import java.util.ArrayList;

public class RffcProduct implements Serializable {

    // Initializing the integer and string variables for the RffcProduct class
    private int id, stock_quantity;
    private String rfcc_stock_name;

    /*
       The empty rffcproduct construct for the project
     */
    public RffcProduct() {
    }

    // The parametrised rffcproduct constructor for the project
    public RffcProduct(int id, String rfcc_stock_name, int stock_quantity) {
        this.id = id;
        this.rfcc_stock_name = rfcc_stock_name;
        this.stock_quantity = stock_quantity;
    }

    /*
      Implementing the setter as well as the getters method for the project
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getRfcc_stock_name() {
        return rfcc_stock_name;
    }

    public void setRfcc_stock_name(String rfcc_stock_name) {
        this.rfcc_stock_name = rfcc_stock_name;
    }

    // Implementing the ProductSerializer method for the project.
    public void RffcGymProductSerializer(ArrayList<RffcProduct> rffcProduct_list)
    {
        try {

            FileOutputStream fo =
                    new FileOutputStream("rffcproducts.ser");
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(rffcProduct_list);
            o.close();
            fo.close();
            System.out.printf("Rffc Gym product have been successfully added!\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
      Implementing the RffcGymProductDeserializer method for the project
     */
    public ArrayList<RffcProduct> RffcGymProductDeserializer()
    {
        ArrayList<RffcProduct> pl= new ArrayList();
        try {
            FileInputStream fl = new FileInputStream("rffcproducts.ser");
            ObjectInputStream oi = new ObjectInputStream(fl);
            pl =  (ArrayList<RffcProduct>) oi.readObject();
            oi.close();
            fl.close();
        } catch (IOException e) {
            System.out.println("The products for rffc gym are not available presently check later please!");
            return pl;
        } catch (ClassNotFoundException e) {
            System.out.println("The member class you have entered in invalid!");
            e.printStackTrace();
            return pl;
        }

        System.out.println("The rffc gym deserialized products...");

        return pl;
    }

}
