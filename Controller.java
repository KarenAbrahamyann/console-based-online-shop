package Project_Shop;

public class Controller {
    private View view;
    private User user;
    private Database database;
    public static int TERMINATE_VALUE;

    public Controller() {
        this.view = new View();
        this.database=new Database();
    }

    public void run() {
            authorizeUser();
            runMenu();
    }
    public void runMenu(){
        while (true){
            int choice = view.printMenu();
            if (choice == 1) {
                addItemToCard();
            } else if (choice == 2) {
                getAllItemsFromShop();
            } else if (choice == 3) {
                removeItemsFromCart();
            } else if (choice == 4) {
                depositMoney();
            } else if (choice == 5) {
                makePurchase();
            } else if (choice == 6) {
                checkUserAccount();
            }
            else if (choice == 7){
                checkUserCart();
            }
            else if (choice ==TERMINATE_VALUE){
                break;
            }
            else {
                view.printMessage("Error invalid input ");
            }
        }
    }
    public void authorizeUser(){
        while (true) {
            String username = view.getTextInput("Input your username");
            String password = view.getTextInput("Input your password");
            User user = database.findUserByUsername(username);
            if (user == null) {
                view.printMessage("---Wrong username---");
            } else {
                if (user.getPassword().equals(password)) {
                    view.printMessage("---Login succesfully---");
                    this.user = user;
                    break;
                } else {
                    view.printMessage("Invalid password");
                }
            }
        }//at this point user logged in

    }
    private void addItemToCard(){
        getAllItemsFromShop();
        int ID =view.getIntegerInput("From list above which product do you want to add ");
        Product product =database.findProductById(ID);
        if(product!=null){
        int quantity=view.getIntegerInput("How many entries of this product do you want to add?");
        //TODO expection for negative values
        user.getUserCart().addProduct(product,quantity);
        view.printMessage("Product"+product.getTitle()+"Was added to your cart!");
    }else {
            view.printMessage("Error product not found ");
        }
        }
    public void getAllItemsFromShop(){
       String text = database.getAllProductsText();
       view.printMessage(text);

    }
    private void removeItemsFromCart(){

    }
    private void depositMoney(){

    }
    private void makePurchase(){

    }
    private void checkUserCart(){

    }

    public void checkUserAccount(){

    }
}
