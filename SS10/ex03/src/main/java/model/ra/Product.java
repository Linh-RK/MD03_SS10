package model.ra;

public class Product {
    private int id;
    private String name;
    private String img;
    private double price;
    private int stock;

    public Product() {
    }

    public Product(int id, String name, String img, double price, int stock) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
