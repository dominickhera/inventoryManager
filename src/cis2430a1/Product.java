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
    public int productID;
    public String name;
    public String price;
    public int year;
 
        public Product (int productID, String name, String price, int year)
        {
            this.productID = productID;
            this.name = name;
            this.price = price;
            this.year = year;
        }
        
        public int sendProdID()
        {
            return productID;
        }
        
        public String sendName()
        {
            return name;
        }
        
        public String sendPrice()
        {
            return price;
        }
        
        public int sendYear()
        {
            return year;
        }
        
        public String sendData()
        {
            String data;
            data = "hiya";
            
            return data;
        }
}
