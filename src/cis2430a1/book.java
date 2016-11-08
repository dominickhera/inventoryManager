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
//		this.productID = productID;
//		this.name = name;
//		this.price = price;
//		this.year = year;
                super(productID,name,price,year);
		this.author = author;
		this.publisher = publisher;
        }
                
//	public int sendBProdID()
//	{
//		return productID;
//	}
//
//	public String sendStringBProdID()
//	{
//		String stringBYear;
//
//		stringBYear = Integer.toString(year);
//		return stringBYear;
//	}
//
//	public String sendBName()
//	{
//		return name;
//	}
//
//	public String sendBPrice()
//	{
//		return price;
//	}
//
//	public String sendBYear()
//	{
//		String stringBYear;
//
//		stringBYear = Integer.toString(year);
//		return stringBYear;
//	}
//
//	public String sendAuthor()
//	{
//		return author;
//	}
//
//	public String sendPublisher()
//	{
//		return publisher;
//	}
}
