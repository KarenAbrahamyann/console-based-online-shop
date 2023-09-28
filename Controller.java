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
            try{
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
            }catch(Exception exception){
                view.printMessage(exception.getMessage());
            }
        }
    }
    public void authorizeUser(){
        while (true) {
            String username = view.getTextInput(" Input your username ");
            String password = view.getTextInput(" Input your password ");
            User user = database.findUserByUsername(username);
            if (user == null) {
                view.printMessage("---Wrong username---");
            } else {
                if (user.getPassword().equals(password)) {
                    view.printMessage("---Login succesfully---");
                    this.user = user;
                    break;
                } else {
                    view.printMessage(" Invalid password ");
                }
            }
        }

    }
    private void addItemToCard() throws Exception{
        getAllItemsFromShop();
        int ID =view.getIntegerInput(" From list above which product do you want to add ");
        Product product =database.findProductById(ID);
        if(product!=null){
        int quantity=view.getIntegerInput(" How many entries of this product do you want to add? ");
        if(quantity<1){
            throw new Exception("Quantity cant be less than 1");}
        else{
        user.getUserCart().addProduct(product,quantity);
        view.printMessage("Product"+product.getTitle()+" Was added to your cart! ");}
    }else {
            view.printMessage(" Error product not found ");
        }
        }
    public void getAllItemsFromShop(){
       String text = database.getAllProductsText();
       view.printMessage(text);

    }
    private void removeItemsFromCart(){
        checkUserCart();

        int id = view.getIntegerInput(" Which product do you want to remove? (input ID) ");
        Cart cart =user.getUserCart();
        boolean wasRemoved =cart.removeItemsFromCartByID(id);
        if(wasRemoved==true){
            view.printMessage(" Item with ID"+id+"was removed ");
        }else{
            view.printMessage(" Item with ID"+id+"was not found ");
        }
    }
    private void depositMoney()throws Exception{
        //ask how much
        double amount=view.getDoubleInput(" How much money would you like to deposit ");
        if(amount<0){
            throw new Exception(" Amount cant be minus ");
        }
        else{
            user.addBalance(amount);
            view.printMessage(amount+" $ was added ,total balance "+user.getBalance()+" $ ");
        }

    }
    private void makePurchase() throws Exception {
        Cart cart =user.getUserCart();
        double cartTotal= cart.getTotalCost();
        if(user.getBalance()<cartTotal){
            throw new Exception(("balance of"+ user.getBalance()+"$ is less than total" +cartTotal+"$"));
        }else {
            double userCurrentBalance =user.getBalance();
            double newBalance = userCurrentBalance-cartTotal;
            user.setBalance(newBalance);
            view.printMessage("Purchase successfully,remaining balance "+user.getBalance());
        }
    }
    private void checkUserCart(){
        Cart cart=user.getUserCart();
        view.printMessage(cart.getMapText());
    }

    public void checkUserAccount(){
        view.printMessage("----");
        view.printMessage(user.toString());
        view.printMessage("----");
    }
}
