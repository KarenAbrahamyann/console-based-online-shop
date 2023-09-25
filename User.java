package Project_Shop;

public class User {
    private String fullName;
    private String username;
    private String password;
    private Cart userCart;
    private double balance;

    public User(String fullName,String username,String password){
        this.fullName=fullName;
        this.username=username;
        this.password=password;
        this.userCart=new Cart();
        this.balance =0;
    }
    public double getBalance(){
        return balance;
    }
    public void addBalance (double money){
        this.balance+=money;
    }


    public Cart getUserCart() {
        return userCart;
    }

    public void setUserCart(Cart userCart) {
        this.userCart = userCart;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
