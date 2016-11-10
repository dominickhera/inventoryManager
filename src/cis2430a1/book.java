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
public class book extends Product
{

	private String author;
	private String publisher;

	public book (int productID, String name, String price, int year, String author, String publisher)
	{
                super(productID,name,price,year);
		this.author = author;
		this.publisher = publisher;
        }
                
	public String sendAuthor()
	{
		return author;
	}

	public String sendPublisher()
	{
		return publisher;
	}
        
        @Override
        
        public String sendData()
        {
            String data;
            data = ("type = (book)\nproductID = (" + productID + ")\nname = (" + name + ")\nprice = (" + price + ")\nyear = (" + year + ")\nauthors = (" + author + ")\npublisher = (" + publisher + ")\n\n" );
            
            return data;
        }
}
