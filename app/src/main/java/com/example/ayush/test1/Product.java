package com.example.ayush.test1;

public class Product {

    public static final String TABLE_PRODUCTS       = "products";
    public static final String PRODUCT_ID          = "id";
    public static final String PRODUCT_NAME        = "name";
    public static final String PRODUCT_PRICE        = "price";
    public static final String PRODUCT_IMAGE       = "image";

    public static final int PRODUCT_ID_INDEX         = 0;
    public static final int PRODUCT_NAME_INDEX       = 1;
    public static final int PRODUCT_PRICE_INDEX       = 2;
    public static final int PRODUCT_IMAGE_INDEX      = 3;
    
    public String id;
    public String name;
    public String price;
    public String image;

    public Product() {

    }

    public Product(String id, String name, String price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
