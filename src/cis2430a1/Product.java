/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2430a1;

/**
 *
 * @author dominickhera
 */
public class Product 
{
    private int productID;
    private String name;
    private String price;
    private int year;
 
        public Product (int productID, String name, String price, int year)
        {
            this.productID = productID;
            this.name = name;
            this.price = price;
            this.year = year;
        }
}
