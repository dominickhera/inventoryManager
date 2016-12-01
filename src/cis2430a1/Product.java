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
 
        public Product (int productID, String name, String price, int year) throws idTooShortException, yearTooOldException, emptyFieldException
        {
            if(Integer.toString(productID).length() != 6)
            {
                throw new idTooShortException(" ID needs to be 6 numbers long");
            }
            else
            {
                this.productID = productID;
            }
            if(name == null)
            {
                throw new emptyFieldException("title field is empty, please enter all fields");
            }
            else
            {
            this.name = name;
            }
            
            if(price == null)
            {
                throw new emptyFieldException("price field is empty, please enter all fields");
            }
            else
            {
            this.price = price;
            }
            
            if(year < 1000 || year > 9999)
            {
                throw new yearTooOldException("Year is not between 1000-9999");
            }
            else
            {
                this.year = year;
            }
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
        
        public String sendSearchData()
        {
            String searchData;
            searchData = "hullo";
            
            return searchData;
        }
}
