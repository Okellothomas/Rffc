import java.util.ArrayList;
import java.util.Scanner;

public class MasterClass {

    // All system to get input from new and old users
    static Scanner getUserData = new Scanner(System.in);

    /*
      Implementing the main method for the project
     */
    public static void main(String [] args)
    {

        System.out.println("--------------------The Rffc Gym Welcome!--------------------" +
                "\n\nEnter a valid option from the ones listed below: \n" +
                "1. A subscriber\n" +
                "2. An Employee\n" +
                "3. I want to Exit");

        availableChoices();
    }

    // Implementing the available subscribers choices.
    public static void availableChoices()
    {
        Scanner keyboard = new Scanner(System.in);
        int i = keyboard.nextInt();

        switch (i){
            case 1:
                allOurSubscribers();
                break;
            case 2:
                allOurEmployees();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice, kindly choose from existing options");
                availableChoices();
        }

    }
       /*
         Implementing allOurSubscribers method for the project
        */

    public static void allOurSubscribers()
    {
        RffcGymSubscribers s = new RffcGymSubscribers();
        RffcGymClasses allOurRffcGymClasses = new RffcGymClasses();
        System.out.println("---------------------All Our Online Subscribers---------------------\n1. Subscribe now! \n2. Enrol now!" +
                "\n3. Switch plan now! \n5. Cancel Plan now! \n5. Review Schedule now! \n6. Request One on One class now!");
        int i = getUserData.nextInt();

        if (i == 1){
            s.RffcSignUp();
        }
        else if(i == 2){
            s.RffcGymSubscriberEnrolment();
        }
        else if(i == 3){
            s.RffcGymSwitchingAvailablePlans();
        }
        else if(i == 4){
            s.RffcGymCancellingAvailablePlans();
        }
        else if(i == 5){
            allOurRffcGymClasses.RffcGymdisplaySchedule();
        }
        else if(i == 6){
            System.out.println("The request you have made for one on one classes have been successful!");
        }
        else{
            System.out.println("Your choice is not valid, choose one of the above options!");
            allOurSubscribers();
        }

    }

    // implementing the allOurEmployees method in our project
    public static void allOurEmployees()
    {
        RffcGymSubscribers s = new RffcGymSubscribers();
        RffcGymClasses c = new RffcGymClasses();
        System.out.println("-------------------All our gym employees------------------\n1. Log in members of the gym \n2. View the list of all gym subscribers" +
                "\n3. Manage the Rffc gym inventory \n4. Generate the Rffc gym schedule \n5. View the Rffc gym Schedule \n6. -----------");
        int i = getUserData.nextInt();

        switch (i){
            case 1:
                s.RffcSignUp();
                break;
            case 2:
                s.RffcGymSubscriberList();
                break;
            case 3:
                RffcGymInventoryManager();
                break;
            case 4:
                rffcGymScheduleGenerator();
                break;
            case 5:
                c.RffcGymdisplaySchedule();
                break;
            default:
                System.out.println("Your choice is not valid, choose one of the above options!");
                allOurEmployees();
        }
    }

    /*
      Implementing the rffcGymScheduleGenerator method in our program.
     */
    public static void rffcGymScheduleGenerator()
    {
        RffcGymClasses c = new RffcGymClasses();
        System.out.println("Want to generate a new schedule for this month, enter one of the option below:\n" +
                "1. Generate now! \n2. Cancel now! ");
        int cn = getUserData.nextInt();

        if (cn == 0){
            System.exit(0);
        }
        else if (cn == 1){
            c.scheduleGenerator();
        }
        else {
            System.out.println("Your choice is not valid, choose one of the above options!");
            rffcGymScheduleGenerator();
        }
    }

    // Implementing the RffcGymInventoryManager method in our project
    public static void RffcGymInventoryManager()
    {

        System.out.println("---------------------------------------------\n" +
                "1. Add the Rffc gym products \n2. Sell the Rffc gym products \n3. View the Rffc gym inventory report");
        int i = getUserData.nextInt();

        switch (i){
            case 1:
                RffcGyamProductCreators();
                break;
            case 2:
                System.out.println("Sell the Rffc gym products to respective gym subscribers");
                break;
            case 3:
                RffcGymStockReport();
                break;
            default:
                System.out.println("Your choice is not valid, choose one of the above options!");
                rffcGymScheduleGenerator();
        }
    }

    /*
      Implementing the RffcGymStockReport method in the project
     */
    public static void RffcGymStockReport()
    {
        RffcProduct gymproducts = new RffcProduct();
        System.out.println("----------------------Rffc gym stock report for the project----------------------------\n");

        ArrayList<RffcProduct> stock_list = gymproducts.RffcGymProductDeserializer();

        for(RffcProduct prod: stock_list)
        {
            System.out.println("\nRffc gym product's name: \t"+prod.getRfcc_stock_name()+"" +
                    "\nRffc gym stock quantity: "+prod.getStock_quantity()+"\n");
        }

        System.out.println("--------------------------------------------------------------------------------------\n");
    }

    // Implementing the RffcGyamProductCreators method for the project
    public static void RffcGyamProductCreators()
    {
        int productQuantity;
        String productName;
        RffcProduct p_o = new RffcProduct();
        System.out.println("--------------------------------------- Add product for Rffc gym------------------------\n" +
                "Enter the name of the product: ");
        productName = getUserData.next();
        System.out.println("Enter the quantity of the product: ");
        productQuantity = getUserData.nextInt();

        ArrayList<RffcProduct> prodlist = p_o.RffcGymProductDeserializer();
        ArrayList<String> p_n = new ArrayList<>();

        for(RffcProduct p:prodlist)
        {
            p_n.add(p.getRfcc_stock_name());
        }

        RffcProduct new_Gym_product;
        if(p_n.contains(productName)) {
            RffcProduct rffcProduct_to_edit = prodlist.get(p_n.indexOf(productName));

            new_Gym_product = new RffcProduct(2, rffcProduct_to_edit.getRfcc_stock_name(), rffcProduct_to_edit.getStock_quantity() + productQuantity);
            prodlist.remove(rffcProduct_to_edit);
            prodlist.add(new_Gym_product);
        }
        else {
            new_Gym_product = new RffcProduct(2, productName, productQuantity);
            prodlist.add(new_Gym_product);

        }

        p_o.RffcGymProductSerializer(prodlist);

    }
}
