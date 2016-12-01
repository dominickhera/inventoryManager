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

	public book (int productID, String name, String price, int year, String author, String publisher) throws idTooShortException, yearTooOldException, emptyFieldException
	{
                super(productID,name,price,year);
                if(author == null)
                {
                    throw new emptyFieldException("author field is empty, please fill in all fields");
                }
                else
                {
		this.author = author;
                }
                
                if(publisher == null)
                {
                    throw new emptyFieldException("publisher field is empty, please fill in all fields");
                }
                else
                {
		this.publisher = publisher;
                }
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
        
         @Override 
        
        public String sendSearchData()
        {
            String searchData;
            searchData = ("product ID: " + productID + "\nName: " + name + "\nPrice : $" + price + "\nYear: " + year + "\nAuthor(s): " + author + "\nPublisher: " + publisher + "\n");
            
            return searchData;
        }
}
