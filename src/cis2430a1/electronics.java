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
                super(productID,name,price,year);
		this.maker = maker;
	}
        
        @Override
        
        public String sendData()
        {
            String data;
            data = ("type = (electronic)\nproductID = (" + productID + ")\nname = (" + name + ")\nprice = (" + price + ")\nyear = (" + year + ")\nmaker = (" + maker + ")\n\n" );
            
            return data;
        }
        
        @Override 
        
        public String sendSearchData()
        {
            String searchData;
            searchData = ("product ID: " + productID + "\nname: " + name + "\nprice: $" + price + "\nyear: " + year + "\nmaker: " + maker + "\n");
            
            return searchData;
        }

}