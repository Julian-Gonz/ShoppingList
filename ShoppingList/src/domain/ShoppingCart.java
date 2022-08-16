
package domain;

import java.util.ArrayList;

public class ShoppingCart {
    //The 3 attributes are created
private String customerName;
private String currentDate;
private ArrayList<ItemToPurchase>cartItems;

    public ShoppingCart(){
        this.customerName = "none";
        this.currentDate = "January 1, 2022";
        this.cartItems = new ArrayList<>();
    }

    public ShoppingCart(String customerName, String currentDate){
        this.customerName = customerName;
        this.currentDate = currentDate;
        this.cartItems = new ArrayList<>();
}

    public String getCustomerName() {
        return customerName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void addItem(ItemToPurchase anItem){
        cartItems.add(anItem);
    }

    public void removeItem(String itemName){
        ItemToPurchase item;
        for(int i =0; i<cartItems.size(); i++) {
            item = cartItems.get(i);
            if (itemName.equals(item.getItemName())) {  //Removes item with the itemName
                cartItems.remove(item);
                System.out.println("Item was removed from cart.");
                break;
            }
            else {
                System.out.println("Item not found in cart. Nothing removed.");
            }
            }
            }

    public void modifyItem(ItemToPurchase anItem){
        ItemToPurchase item;
        for(int i = 0; i<cartItems.size(); i++){
            item = cartItems.get(i);
            if(item.getItemName().equals(anItem.getItemName())){    //Sets new quantity for item
                item.setItemQuantity(anItem.getItemQuantity());
                System.out.println("Item was modified in cart.");
                break;
            }
            else{
                System.out.println("Item not found in cart. Nothing modified.");
            }
        }
    }

    public int getNumItemsInCart(){
        int quantityOfItems =0;
        for(int i =0; i<cartItems.size(); i++){
            quantityOfItems +=cartItems.get(i).getItemQuantity();   //Adds quantity of items
        }
        return quantityOfItems;
    }

    public double getCostOfCart(){
        double costOfCart =0;
        for(int i =0; i<cartItems.size(); i++){
            costOfCart += cartItems.get(i).getItemPrice() * cartItems.get(i).getItemQuantity();
        }
        return costOfCart;
    }

    public void printTotal(){
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
        if(cartItems.size()==0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        for(int i =0;i<cartItems.size(); i++){
            cartItems.get(i).printItemCost();
        }
        System.out.println();
        System.out.println("Total: $" + getCostOfCart());

    }

    public void printDescriptions(){
        System.out.println(customerName + "'s Shopping Cart - " + currentDate + "\n");
        System.out.println("Item Descriptions");
        for(int i =0; i<cartItems.size(); i++){
            cartItems.get(i).printItemDescription();
        }
    }

}
