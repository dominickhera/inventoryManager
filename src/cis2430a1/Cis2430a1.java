/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2430a1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author dominickhera
 */
public class Cis2430a1 
{

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{

		Scanner scannerObj = new Scanner(System.in);
		Scanner scannerString = new Scanner(System.in);

                //declares arraylists
//		ArrayList<book> books = new ArrayList<book>();
//		ArrayList<electronics> electronic = new ArrayList<electronics>();
                ArrayList<Product> products = new ArrayList<Product>();

		String userInput = "";
		int itemCount = 0;
		int bookCount = 0;
		int electronicCount = 0;

		while (!"quit".equals(userInput))
		{
			System.out.println("eStore Options:\n\nadd\nsearch\nsave\nload\nquit\n");
			userInput = scannerObj.nextLine();
			switch(userInput.toLowerCase())
			{
				case "add":
					System.out.println("Is this item a book or an electronic?\n");
					String itemChoice = scannerString.nextLine();
					if("book".equals(itemChoice.toLowerCase()) || "books".equals(itemChoice.toLowerCase()))
					{
                                                //asks for user input to add data for a book, if the user puts say a character into an integer spot, it will boot them back to main menu
						try
						{
							System.out.print("Product ID: ");
							int bProdID = scannerString.nextInt();
							scannerString.nextLine();

//							for (int i = 0; i < electronicCount; i++)
//							{
//								while(bProdID == electronic.get(i).sendEProdID())
//								{
//									System.out.print("That product ID already exists, please enter a new product ID: ");
//									bProdID = scannerString.nextInt();
//									scannerString.nextLine();
//								}
//							}
//							for (int i = 0; i < bookCount; i++)
//							{
//								while(bProdID == books.get(i).sendBProdID())
//								{
//									System.out.print("That product ID already exists, please enter a new product ID: ");
//									bProdID = scannerString.nextInt();
//									scannerString.nextLine();
//								}
//							}
							String bProdIDLength = Integer.toString(bProdID);
							while(bProdIDLength.length() != 6)
							{
								bProdID = 0;
								System.out.print("Please enter a Product ID that is 6 numbers long: ");
								bProdID = scannerString.nextInt();
								scannerString.nextLine();
								bProdIDLength = Integer.toString(bProdID);
							}
							System.out.print("Title: ");
							String bTitle = scannerString.nextLine();
							System.out.print("Cost: $");
							String bCost = scannerString.nextLine();
							System.out.print("Year Published: ");
							int bYear = scannerString.nextInt();
							scannerString.nextLine();
                                                        //checks to make sure the year is between 1000 and 9999
							while (bYear < 1000 || bYear > 9999)
							{
								System.out.print("Please enter a year between 1000-9999: ");
								bYear = scannerString.nextInt();
								scannerString.nextLine();
							}
							System.out.print("Author(s): ");
							String bAuthor = scannerString.nextLine();
							System.out.print("Publisher: ");
							String bPublisher = scannerString.nextLine();
                                                        
                                                        //adds the data into the arrayList
							products.add(new book(bProdID, bTitle, bCost, bYear, bAuthor, bPublisher));
							itemCount++;
							bookCount++;

						}
						catch(InputMismatchException exception)
						{
                                                        //if the user inputs an invalid answer, the program will boot them back to main menu
							System.out.println("\nInvalid Product ID\nReturning to main menu...\n");
						}
					}
					else if("electronic".equals(itemChoice.toLowerCase()) || "electronics".equals(itemChoice.toLowerCase()))
					{
						try{
                                                    //prompts user for multiple fields same as book except with less fields
							System.out.print("Product ID: ");
							int eProdID = scannerString.nextInt();
							scannerString.nextLine();
//							for (int i = 0; i < electronicCount; i++)
//							{
//								while(eProdID == electronic.get(i).sendEProdID())
//								{
//									System.out.print("That product ID already exists, please enter a new product ID: ");
//									eProdID = scannerString.nextInt();
//									scannerString.nextLine();
//								}
//							}
//							for (int i = 0; i < bookCount; i++)
//							{
//								while(eProdID == books.get(i).sendBProdID())
//								{
//									System.out.print("That product ID already exists, please enter a new product ID: ");
//									eProdID = scannerString.nextInt();
//									scannerString.nextLine();
//								}
//							}

							String eProdIDLength = Integer.toString(eProdID);
							while(eProdIDLength.length() != 6)
							{
								eProdID = 0;
								System.out.print("Please enter a Product ID that is 6 numbers long: ");
								eProdID = scannerString.nextInt();
								scannerString.nextLine();
								eProdIDLength = Integer.toString(eProdID);
							}
							System.out.print("Name: ");
							String eTitle = scannerString.nextLine();
							System.out.print("Cost: $");
							String eCost = scannerString.nextLine();
							System.out.print("Year: ");
							int eYear = scannerString.nextInt();
							scannerString.nextLine();
							while (eYear < 1000 || eYear > 9999)
							{
								System.out.print("Please enter a year between 1000-9999: ");
								eYear = scannerString.nextInt();
								scannerString.nextLine();
							}
							System.out.print("Company: ");
							String eCompany = scannerString.nextLine();
							products.add(new electronics(eProdID, eTitle, eCost, eYear, eCompany));
							itemCount++;
							electronicCount++;
						}
						catch(InputMismatchException exception)
						{         
                                                        //boots user to main menu if they invoke a inputMismatchException
							System.out.println("\nInvalid Product ID\nReturning to main menu...\n");
						}  
					}
					else
					{
                                                //boots the user back to main menu if their answer is neither a book or electronic
						System.out.println("User input is neither book or electronic, returning to main menu...\n");
					}
					break;
				case "search":

					if(itemCount == 0)
					{
						System.out.println("No data is entered, please enter some items.\n");
						break;
					}

                                         //turns whatever the user enters into an array of strings that the program will compare against the currently entered data and print out the information relating to it
					System.out.print("enter a keyword for the product you're searching for: ");
					String keywords = scannerString.nextLine(); 

					String[] keywordSearch = keywords.split("[ ]+");
					System.out.print("\n");

//					for (int i = 0; i < bookCount; i++)
//					{
//
//						for(int j = 0; j < keywordSearch.length; j++)
//						{
//							if(books.get(i).sendBName().contains(keywordSearch[j]) || books.get(i).sendBPrice().contains(keywordSearch[j]) || books.get(i).sendAuthor().contains(keywordSearch[j]) || books.get(i).sendPublisher().contains(keywordSearch[j]) || books.get(i).sendBYear().contains(keywordSearch[j]) || books.get(i).sendStringBProdID().contains(keywordSearch[j]))
//							{
//								System.out.println("found " + keywords);
//								System.out.print("Product ID: " + books.get(i).sendBProdID() + "\nTitle: " + books.get(i).sendBName() + "\nCost: $" + books.get(i).sendBPrice() + "\nYear: " + books.get(i).sendBYear() + "\nAuthor: " + books.get(i).sendAuthor() + "\nPublisher: " + books.get(i).sendPublisher() + "\n\n");
//							}
//						}
//					}
//					for(int i = 0; i < electronicCount; i++)
//					{
//						for(int j = 0; j < keywordSearch.length; j++)
//						{
//							if(electronic.get(i).sendEName().contains(keywordSearch[j]) || electronic.get(i).sendEPrice().contains(keywordSearch[j]) || electronic.get(i).sendStringEProdID().contains(keywordSearch[j]) || electronic.get(i).sendMaker().contains(keywordSearch[j]))
//							{
//								System.out.print("Product ID: " + electronic.get(i).sendEProdID() + "\nTitle: " + electronic.get(i).sendEName() + "\nCost: $" + electronic.get(i).sendEPrice() + "\nYear: " + electronic.get(i).sendEYear() + "\nMaker: " + electronic.get(i).sendMaker() + "\n");
//							}
//						}
//					}


					System.out.print("\n");
					break;
				case "quit":
                                        //nicely says farewell as you quit.
					System.out.println("goodbye\n");
					System.exit(0);
                                case "print":
                                        System.out.println("prints shit");
                                        System.out.println(products.get(0).sendProdID());
                                        System.out.println(products.get(0).sendAuthor());
                                        break;
				default:
                                        //the prompt you'll recieve if you dont enter one of the three stated menu options
					System.out.println("please enter one of the previously stated options\n");
					break;
			}

		}

	}

}
