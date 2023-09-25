package Project_Shop;

import java.util.HashMap;
import java.util.Map;


// Если нужны только продукты - map.keySet()
// Если нужны только значения кол-ва - map.values()
// Ecли нужно и то и другое - map.entrySet()

public class Cart {
    private HashMap<Product,Integer>map;

    public  Cart(){
        this.map=new HashMap<>();
    }
    public void addProduct(Product product,int quantity){
    map.put(product,quantity);
    }
    public String getMapText(){
        String text="";
        for(Map.Entry<Product,Integer>entry:map.entrySet()){
            Product product =entry.getKey();
            Integer quantity=entry.getValue();
            text+=product.getProductId()+"" +product.getTitle() +"->"+quantity + " items";
        }
        return text;
    }
    public boolean removeItemsFromCartByID(int id) {
        for (Product product : map.keySet()) {
            if (product.getProductId() == id) {
                map.remove(product);
                return true;
            }

        }return false;
    }
    public double getTotalCost(){
        double cost=0;
        for(Map.Entry<Product,Integer>entry:map.entrySet()){
            Product product=entry.getKey();
            Integer quantity= entry.getValue();
            cost+= product.getPrice()*quantity;
        }
        return cost;
    }
    public int getTotalQuantity(){
        int quantity=0;
        for(Integer eachItemQuantity: map.values()){
            quantity+=eachItemQuantity;
        }
        return quantity;

    }
}
