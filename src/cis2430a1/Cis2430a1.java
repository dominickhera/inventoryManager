/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2430a1;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author dominickhera
 */
public class Cis2430a1 extends JFrame
{
   JLabel welcome;
   JLabel addTitle;
   JLabel searchTitle;
   JLabel aTypeLabel;
   JLabel aProdIDLabel;
   JLabel aNameLabel;
   JLabel aPriceLabel;
   JLabel aYearLabel;
   JLabel aAuthorLabel;
   JLabel aPublisherLabel;
   private JPanel welcomePanel;
   private JPanel addPanel;
   private JPanel searchPanel;
    
    public Cis2430a1()
    {
        super();
        setTitle("eStore");
        setSize(750,500);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10,10));
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(1,3));
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridBagLayout());
//        addPanel.setSize(500,500);
        GridBagConstraints c = new GridBagConstraints();
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,3));
        String[] commandStrings = { "command", "add", "search", "quit" };
        JComboBox commandList = new JComboBox(commandStrings);
        
        String[] productStrings = {"book", "electronic"};
        JComboBox productType = new JComboBox(productStrings);
        addPanel.setVisible(false);
        addPanel.setEnabled(false);
        searchPanel.setVisible(false);
        searchPanel.setEnabled(false);
        commandList.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(commandList.getSelectedItem().toString().equals("add"))
                {
                    System.out.println("add");
                    welcomePanel.setEnabled(false);
                    welcomePanel.setVisible(false);
                    searchPanel.setEnabled(false);
                    searchPanel.setVisible(false);
                    remove(welcomePanel);
                    remove(searchPanel);
                    add(addPanel);
                    addPanel.setVisible(true);
                    addPanel.setEnabled(true);
                    
                }
                else if(commandList.getSelectedItem().toString().equals("search"))
                {
                    System.out.println("search");
                    welcomePanel.setEnabled(false);
                    welcomePanel.setVisible(false);
                    add(searchPanel);
                    remove(welcomePanel);
                    remove(addPanel);
                    searchPanel.setVisible(true);
                    searchPanel.setEnabled(true);
                }
                else if(commandList.getSelectedItem().toString().equals("quit"))
                {
                    System.exit(0);
                }
                else if(commandList.getSelectedItem().toString().equals("command"))
                {
                    remove(addPanel);
                    remove(searchPanel);
                    add(welcomePanel);
                    welcomePanel.setVisible(true);
                    welcomePanel.setEnabled(true);
                }
            }
        });
            
        
        productType.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(productType.getSelectedItem().toString().equals("book"))
                {
                    System.out.println("book");
                }
                else if(productType.getSelectedItem().toString().equals("electronic"))
                {
                    System.out.println("electronic");
                }
            }
        });
            
        
        welcome = new JLabel("<html><br><br>Welcome to eStore<br> Choose a command from the Commands menu above for <br> adding a product, searching products, or quitting the program.<br><br><br></html>");
        welcomePanel.add(welcome);
        
        addTitle = new JLabel("Adding a product");
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(addTitle, c);
        addPanel.revalidate();
        addPanel.repaint();
        
        aTypeLabel = new JLabel("Type:");
        c.gridx = 0;
        c.gridy = 2;
//        addPanel.revalidate();
//        addPanel.repaint();
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.revalidate();
        addPanel.repaint();
        addPanel.add(aTypeLabel, c);
        
        
//        addPanel.revalidate();
//        addPanel.repaint();
        c.gridx = 1;
        c.gridy = 2;
//        c.weightx = 0.5;
        c.weighty = 1;
//        addPanel.revalidate();
//        addPanel.repaint();
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.revalidate();
        addPanel.repaint();
//        c.ipady = 0;
        addPanel.add(productType, c);
        
        aProdIDLabel = new JLabel("Product ID:");
//        addPanel.revalidate();
//        addPanel.repaint();
        c.gridx = 0;
        c.gridy = 3;
//        addPanel.revalidate();
//        addPanel.repaint();
//        c.weightx = 0.5;

        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.revalidate();
        addPanel.repaint();
        addPanel.add(aProdIDLabel, c);
        
        aNameLabel = new JLabel("Name:");
//        addPanel.revalidate();
//        addPanel.repaint();
        c.gridx = 0;
        c.gridy = 4;
//        addPanel.revalidate();
//        addPanel.repaint();
//        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.revalidate();
        addPanel.repaint();
        addPanel.add(aNameLabel, c);
        
//        aPriceLabel = new JLabel("Price:");
//        c.gridx = 0;
//        c.gridy = 4;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        addPanel.add(aPriceLabel);
//        
//        aYearLabel = new JLabel("Year:");
//        c.gridx = 0;
//        c.gridy = 5;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        addPanel.add(aYearLabel,c);
//        
//        aAuthorLabel = new JLabel("Authors");
//        c.gridx = 0;
//        c.gridy = 6;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        addPanel.add(aAuthorLabel, c);
//        
//        aPublisherLabel = new JLabel("Publisher");
//        c.gridx = 0;
//        c.gridy = 7;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        addPanel.add(aPublisherLabel,c);
        
        searchTitle = new JLabel("Searching products");
        searchPanel.add(searchTitle);
        
//        addPanel.add(productType);
        add(commandList);
        add(welcomePanel);
        add(addPanel);
        add(searchPanel);        
        
        
    }

    public static void main(String[] args) 
    {
        Scanner scannerObj = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        String fileName = "";
        
//        if (args.length == 0)
//        {
//            System.out.println("not enough arguements, please enter a filename : ");
//            
//            fileName = scannerString.nextLine();
//        }
//        else
//        {
//            fileName = args[0];
//            System.out.println("found file, opening " + fileName);
//        }
        
        Cis2430a1 win = new Cis2430a1();
        win.setVisible(true);
        //declares arraylists
        ArrayList<Product> products = new ArrayList<Product>();
        HashMap <String, Product> map = new HashMap<>();

        String userInput = "";
        int itemCount = 0;

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

                            for (int i = 0; i < itemCount; i++)
                            {
                                while(bProdID == products.get(i).sendProdID())
                                {
                                    System.out.print("That product ID already exists, please enter a new product ID: ");
                                    bProdID = scannerString.nextInt();
                                    scannerString.nextLine();
                                }
                            }
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
                            map.put(bTitle, new book(bProdID, bTitle, bCost, bYear, bAuthor, bPublisher));
//                            String value = (String)map.get("harry potter");
//                            System.out.println("title" + map.get("harry potter"));
                            itemCount++;

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
                            for (int i = 0; i < itemCount; i++)
                            {
                                while(eProdID == products.get(i).sendProdID())
                                {
                                    System.out.print("That product ID already exists, please enter a new product ID: ");
                                    eProdID = scannerString.nextInt();
                                    scannerString.nextLine();
                                }
                            }

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

                    int searchChoice = 0;

                    while(searchChoice != 5)
                    {


                        System.out.println("what kind of search do you want to do?\n\n");
                        System.out.println("(1) ProductID Match\n(2) Keyword Match\n(3) Time Period Match\n(4) Combined Search\n(5) Return to main menu\n");
                        searchChoice = scannerString.nextInt();
                        scannerString.nextLine();

                        switch(searchChoice)
                        {
                            case 1:
                                System.out.print("enter the product ID of the product you're searching for: ");
                                int idProdSearch = scannerString.nextInt();
                                scannerString.nextLine();
                                for (int i = 0; i < itemCount; i++)
                                {
                                if(idProdSearch == products.get(i).sendProdID())
                                {
                                    System.out.print("Found this item matching you're search:\n\n");
                                    System.out.println(products.get(i).sendSearchData());
                                    
                                }
                                
                                }
                                break;
                            case 2:
                                //turns whatever the user enters into an array of strings that the program will compare against the currently entered data and print out the information relating to it
                                System.out.print("enter a keyword for the product you're searching for: ");
                                String keywords = scannerString.nextLine(); 

                                String[] keywordSearch = keywords.split("[ ]+");
                                System.out.print("\n");

                                //                    					for (int i = 0; i < bookCount; i++)
                                //                    					{
                                //                    
                                //                    						for(int j = 0; j < keywordSearch.length; j++)
                                //                    						{
                                //                    							if(books.get(i).sendBName().contains(keywordSearch[j]) || books.get(i).sendBPrice().contains(keywordSearch[j]) || books.get(i).sendAuthor().contains(keywordSearch[j]) || books.get(i).sendPublisher().contains(keywordSearch[j]) || books.get(i).sendBYear().contains(keywordSearch[j]) || books.get(i).sendStringBProdID().contains(keywordSearch[j]))
                                //                    							{
                                //                    								System.out.println("found " + keywords);
                                //                    								System.out.print("Product ID: " + books.get(i).sendBProdID() + "\nTitle: " + books.get(i).sendBName() + "\nCost: $" + books.get(i).sendBPrice() + "\nYear: " + books.get(i).sendBYear() + "\nAuthor: " + books.get(i).sendAuthor() + "\nPublisher: " + books.get(i).sendPublisher() + "\n\n");
                                //                    							}
                                //                    						}
                                //                    					}
                                //                    					for(int i = 0; i < electronicCount; i++)
                                //                    					{
                                //                    						for(int j = 0; j < keywordSearch.length; j++)
                                //                    						{
                                //                    							if(electronic.get(i).sendEName().contains(keywordSearch[j]) || electronic.get(i).sendEPrice().contains(keywordSearch[j]) || electronic.get(i).sendStringEProdID().contains(keywordSearch[j]) || electronic.get(i).sendMaker().contains(keywordSearch[j]))
                                //                    							{
                                //                    								System.out.print("Product ID: " + electronic.get(i).sendEProdID() + "\nTitle: " + electronic.get(i).sendEName() + "\nCost: $" + electronic.get(i).sendEPrice() + "\nYear: " + electronic.get(i).sendEYear() + "\nMaker: " + electronic.get(i).sendMaker() + "\n");
                                //                    							}
                                //                    						}
                                //                    					}

                                break;
                            case 3:
                                System.out.println("still no idea how to do this but running out of time so...");
//                                for (String key : map.keySet())
//                                {
//                                    System.out.println("this is the key " + key);
//                                }
                                break;
                            case 4:
                                System.out.printf("enter keywords in title to search: ");
                                String searchTerms = scannerString.nextLine();
//                                Object key = null;
                                
//                                for (String key : map.keySet())
//                                {
//                                    System.out.println("this is the key " + key);
//                                }
                                
//                                for(Map.Entry entry: map.entrySet())
//                                {
//                                 if(searchTerms.equals(entry.getValue()))
//                                 {
//                                     key = entry.getKey();
//                                     break;
//                                 }
//                                }
//                                System.out.printf("key is" + key);
                                break;
                            case 5:
                                searchChoice = 5;
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Please choose an option between 1-5");
                                break;
                        }
                        System.out.print("\n");
                    }
                    break;
                case "save":
                    try
                    {
                        PrintWriter fileDump = new PrintWriter(fileName);
                        if(itemCount == 0)
                        {
                            System.out.println("No items entered. Can't Save anything.");
                            break;
                        }
                        for(int i = 0; i < itemCount; i++)
                        {
                            fileDump.print(products.get(i).sendData());
                        }
                        fileDump.close();
                        System.out.println("File Saved Successfully");
                    }
                    catch(Exception ex) 
                    {
                        System.out.println("could not write to data file");
                    }
                    break;
                case "load":
                    try
                    {
                        int loadNum = 0;
                        int testCount = 0;
                        String [] testString = new String[1000];
                        File f = new File(fileName);
                        Scanner scanner = new Scanner(f);
                        while (scanner.hasNextLine())
                        {
                            String test =  scanner.nextLine();
                            String newTest;
                            if (test.isEmpty())
                            {
                                if("book".equals(testString[0]))
                                {

                                    int parsedYear = Integer.parseInt(testString[4]);
                                    int parsedProductID = Integer.parseInt(testString[1]);
                                    products.add(new book(parsedProductID, testString[2], testString[3], parsedYear, testString[5], testString[6]));
                                    parsedYear = 0;
                                    parsedProductID = 0;
                                    testCount = 0;
                                    itemCount++;
                                }
                                else if("electronic".equals(testString[0]))
                                {

                                    int parsedYear = Integer.parseInt(testString[4]);
                                    int parsedProductID = Integer.parseInt(testString[1]);
                                    products.add(new electronics(parsedProductID, testString[2], testString[3], parsedYear, testString[5]));
                                    parsedYear = 0;
                                    parsedProductID = 0;
                                    testCount = 0;
                                    itemCount++;
                                }
                            }
                            else
                            {
                                newTest = test.substring(test.indexOf("(") + 1, test.indexOf(")"));
                                testString[testCount] = newTest;
                                testCount++;
                            }
                            loadNum++;

                        }
                        if(testString[0].isEmpty())
                        {
                            System.out.println("File is Empty, returning to main menu...");
                            break;
                        }
                        System.out.println("\nLoaded Successfully\n");
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Could not open file");
                    }
                    break;
                case "quit":
                    //nicely says farewell as you quit.
                    System.out.println("goodbye\n");
                    System.exit(0);
                default:
                    //the prompt you'll recieve if you dont enter one of the three stated menu options
                    System.out.println("please enter one of the previously stated options\n");
                    break;
            }

        }

    }

}
