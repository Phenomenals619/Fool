
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author theam
 */
public class cartBean {
     public Vector<Product> cart = new Vector<Product>();

    public String addTocart(String pid, String name, String price) {
        for (Product product : cart) {
            if (product.getPid().equals(pid)) {
                return "Product is already in cart";
            }
        }
        Product pr = new Product(pid, name, price);
        cart.add(pr);
        return "Product Added";

    }

    public String showcart() {
        String allproduct = "";
        for (Product product : cart) {
            allproduct += product.getPid() + ":" + product.getName() + ":" + product.getPrice() + ";";
        }
        return allproduct;
    }


}

class Product {

    String pid;
    String name;
    String price;

    public Product(String pid, String name, String price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}


