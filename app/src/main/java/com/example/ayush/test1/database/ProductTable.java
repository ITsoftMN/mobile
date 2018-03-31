package com.example.ayush.test1.database;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ayush.test1.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductTable {

    public ProductTable() {
        Product Product = new Product();
    }

    public static String create(){
        return "CREATE TABLE "+ Product.TABLE_PRODUCTS+" (" +
                Product.PRODUCT_ID + " TEXT PRIMARY KEY," +
                Product.PRODUCT_NAME + " TEXT," +
                Product.PRODUCT_PRICE + " TEXT," +
                Product.PRODUCT_IMAGE + " TEXT);";
    }

    public void insert(Product product) {
        if (product == null) {
            return;
        }
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        if (db == null) {
            return;
        }
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put(Product.PRODUCT_ID, product.getId());
            cv.put(Product.PRODUCT_NAME, product.getName());
            cv.put(Product.PRODUCT_PRICE, product.getPrice());
            cv.put(Product.PRODUCT_IMAGE, product.getImage());
            db.insert(Product.TABLE_PRODUCTS, null, cv);
            db.setTransactionSuccessful();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            db.endTransaction();
            DatabaseManager.getInstance().closeDatabase();
        }
    }

    public Product select(int id) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        if (db == null) {
            return null;
        }
        Cursor cursor = db.query(Product.TABLE_PRODUCTS, new String[]{
                        Product.PRODUCT_ID,
                        Product.PRODUCT_NAME,
                        Product.PRODUCT_PRICE,
                        Product.PRODUCT_IMAGE
                }, Product.PRODUCT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (!cursor.moveToFirst()) {
            return null;
        }

        Product product = new Product();
        product.setId(cursor.getString(Product.PRODUCT_ID_INDEX));
        product.setName(cursor.getString(Product.PRODUCT_NAME_INDEX));
        product.setPrice(cursor.getString(Product.PRODUCT_PRICE_INDEX));
        product.setImage(cursor.getString(Product.PRODUCT_IMAGE_INDEX));
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return product;
    }

    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Product.TABLE_PRODUCTS;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Product Product = new Product();
                Product.setId(cursor.getString(Product.PRODUCT_ID_INDEX));
                Product.setName(cursor.getString(Product.PRODUCT_NAME_INDEX));
                Product.setPrice(cursor.getString(Product.PRODUCT_PRICE_INDEX));
                Product.setImage(cursor.getString(Product.PRODUCT_IMAGE_INDEX));
                products.add(Product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return products;
    }

    public int update(Product Product) {
        if (Product == null) {
            return -1;
        }
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        if (db == null) {
            return -1;
        }
        ContentValues cv = new ContentValues();
        cv.put(Product.PRODUCT_ID, Product.getId());
        cv.put(Product.PRODUCT_NAME, Product.getName());
        cv.put(Product.PRODUCT_PRICE, Product.getPrice());
        cv.put(Product.PRODUCT_IMAGE, Product.getImage());
        int rowCount = db.update(Product.TABLE_PRODUCTS, cv, Product.PRODUCT_ID + "=?",
                new String[]{String.valueOf(Product.getId())});
        DatabaseManager.getInstance().closeDatabase();
        return rowCount;
    }

    public void delete(Product Product) {
        if (Product == null) {
            return;
        }
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        if (db == null) {
            return;
        }
        db.delete(Product.TABLE_PRODUCTS, Product.PRODUCT_ID + "=?", new String[]{String.valueOf(Product.getId())});
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deleteAll() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Product.TABLE_PRODUCTS, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public int count() {
        String query = "SELECT * FROM  " + Product.TABLE_PRODUCTS;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return count;
    }
}