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
public class electronics extends Product
{
    
	private String maker;

	public electronics (int productID, String name, String price, int year, String maker)
	{
//		this.productID = productID;
//		this.name = name;
//		this.price = price;
//		this.year = year;
                super(productID,name,price,year);
		this.maker = maker;
	}

//	public int sendEProdID()
//	{
//		return productID;
//	}
//
//	public String sendStringEProdID()
//	{
//		String stringEProdID;
//
//		stringEProdID = Integer.toString(productID);
//
//		return stringEProdID;
//	}
//
//	public String sendEName()
//	{
//		return name;
//	}
//
//	public String sendEPrice()
//	{
//		return price;
//	}
//
//	public String sendEYear()
//	{
//		String stringEYear;
//
//		stringEYear = Integer.toString(year);
//		return stringEYear;
//	}
//
//	public String sendMaker()
//	{
//		return maker;
//	}
}