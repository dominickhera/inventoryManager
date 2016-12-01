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
   JLabel aMakerLabel;
   JLabel sProdIDLabel;
   JLabel sKeywordLabel;
   JLabel sStartYearLabel;
   JLabel sEndYearLabel;
   JTextField aProdIDField;
   JTextField aNameField;
   JTextField aPriceField;
   JTextField aYearField;
   JTextField aAuthorField;
   JTextField aPublisherField;
   JTextField aMakerField;
   JTextField sProdIDField;
   JTextField sKeywordField;
   JTextField sStartYearField;
   JTextField sEndYearField;
   JTextArea addTextMessage;
   JScrollPane addScroll;
   JScrollPane addHScroll;
   JTextArea searchTextMessage;
   JScrollPane searchScroll;
   JScrollPane SearchHScroll;
   ArrayList<Product> products = new ArrayList<Product>();
   HashMap <String, Product> map = new HashMap<>();
   private String fileName;
   private JPanel welcomePanel;
   private JPanel addPanel;
   private JPanel searchPanel;
    
    public Cis2430a1()
    {
        super();
        ArrayList<Product> products = new ArrayList<Product>();
        HashMap <String, Product> map = new HashMap<>();
        setTitle("eStore");
        setSize(750,1000);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,10));
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(1,3));
        addPanel = new JPanel();
        addPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints();
        String[] commandStrings = { "command", "add", "search", "quit" };
        JComboBox commandList = new JComboBox(commandStrings);
        String[] productStrings = {"book", "electronic"};
        JComboBox productType = new JComboBox(productStrings);
         Scanner scannerString = new Scanner(System.in);
        addPanel.setVisible(false);
        addPanel.setEnabled(false);
        searchPanel.setVisible(false);
        searchPanel.setEnabled(false);
        
        
        System.out.println("enter file name: ");
        fileName = scannerString.nextLine();
        
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
//                                    products.add(new book(parsedProductID, testString[2], testString[3], parsedYear, testString[5], testString[6]));
                                    
                                     String [] mapKey = new String[256];
                                     mapKey = testString[2].split("[ ]+");

                                    Product tempBook = new book(parsedProductID, testString[2], testString[3], parsedYear, testString[5], testString[6]);
                                    products.add(tempBook);
                                    for(int i = 0; i < mapKey.length; i++)
                                    {
                                      map.put(mapKey[i], tempBook);  
                                    }
                                    parsedYear = 0;
                                    parsedProductID = 0;
                                    testCount = 0;
//                                    itemCount++;
                                }
                                else if("electronic".equals(testString[0]))
                                {

                                    int parsedYear = Integer.parseInt(testString[4]);
                                    int parsedProductID = Integer.parseInt(testString[1]);
                                    products.add(new electronics(parsedProductID, testString[2], testString[3], parsedYear, testString[5]));
                                    
                                    String [] mapKey = new String[256];
                                    mapKey = testString[2].split("[ ]+");

                                    Product tempElectronic = new electronics(parsedProductID, testString[2], testString[3], parsedYear, testString[5]);
                                    products.add(tempElectronic);
                                    for(int i = 0; i < mapKey.length; i++)
                                    {
                                      map.put(mapKey[i], tempElectronic);  
                                    }
                                    
                                    parsedYear = 0;
                                    parsedProductID = 0;
                                    testCount = 0;
//                                    itemCount++;
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
//                            break;
                        }
                        System.out.println("\nLoaded Successfully\n");
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Could not open file");
                    }
        
        
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
                   try
                    {
                        PrintWriter fileDump = new PrintWriter(fileName);
                        if(products.size() == 0)
                        {
                            System.out.println("No items entered. Can't Save anything.");
                        }
                        else
                        {
                        for(int i = 0; i < products.size(); i++)
                        {
                            fileDump.print(products.get(i).sendData());
                        }
                        fileDump.close();
                        System.out.println("File Saved Successfully");
                        System.exit(0);
                        }
                        }
                    catch(Exception ex) 
                    {
                        System.out.println("could not write to data file");
                    }
//                    System.exit(0);
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
                    aPublisherLabel.setVisible(true);
                    aAuthorLabel.setVisible(true);
                     aPublisherField.setVisible(true);
                    aAuthorField.setVisible(true);
                    aPublisherField.setEnabled(true);
                    aAuthorField.setEnabled(true);
                    aMakerField.setVisible(false);
                    aMakerField.setEnabled(false);
                    aMakerLabel.setVisible(false);
                    
                }
                else if(productType.getSelectedItem().toString().equals("electronic"))
                {
                    System.out.println("electronic");
                    aPublisherLabel.setVisible(false);
                    aAuthorLabel.setVisible(false);
                    aPublisherField.setVisible(false);
                    aAuthorField.setVisible(false);
                    aPublisherField.setEnabled(false);
                    aAuthorField.setEnabled(false);
                    aMakerField.setVisible(true);
                    aMakerField.setEnabled(true);
                    aMakerLabel.setVisible(true);
                }
            }
        });
            
        
        welcome = new JLabel("<html><br><br>Welcome to eStore<br> Choose a command from the Commands menu above for <br> adding a product, searching products, or quitting the program.<br><br><br></html>");
        welcomePanel.add(welcome);
        
        
        //////add begins here ///////
        
        
        addTitle = new JLabel("Adding a product");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(addTitle, c);
        
        aTypeLabel = new JLabel("Type:");
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aTypeLabel, c);
        
        c.gridx = 1;
        c.gridy = 2;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(productType, c);
        
        aProdIDLabel = new JLabel("Product ID:");
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aProdIDLabel, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aProdIDField = new JTextField(15);
        addPanel.add(aProdIDField, c);
        
        JButton aResetButton = new JButton("Reset");
        c.gridx = 2;
        c.gridy = 3;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aResetButton,c);
        aResetButton.addActionListener(new ActionListener ()
        {
           public void actionPerformed(ActionEvent e)
           {
               aProdIDField.setText("");
               aNameField.setText("");
               aPriceField.setText("");
               aYearField.setText("");
               aAuthorField.setText("");
               aPublisherField.setText("");
               aMakerField.setText("");
           }
            
        });
        
        JButton aAddButton = new JButton("Add");
        c.gridx = 2;
        c.gridy = 6;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aAddButton,c);
        aAddButton.addActionListener(new ActionListener ()
        {
           public void actionPerformed(ActionEvent e)
           {
             if(productType.getSelectedItem().toString().equals("book"))
                {   
                    try
                    {
                        if("".equals(aNameField.getText()) | "".equals(aProdIDField.getText()) | "".equals(aPriceField.getText()) | "".equals(aYearField.getText()) | "".equals(aPublisherField.getText()) | "".equals(aAuthorField.getText()))
                        {
                            throw new emptyFieldException("Missing information, please enter all text fields.");
                        }
                        else
                        {
                            String productID = aProdIDField.getText();
                            int productIDFinal = Integer.parseInt(productID);
                            String name = aNameField.getText();
                            String price = aPriceField.getText();
                            String year = aYearField.getText();
                            int yearFinal = Integer.parseInt(year);
                            String publisher = aPublisherField.getText();
                            String author = aAuthorField.getText();
                            
                             String [] mapKey = new String[256];
                            mapKey = name.split("[ ]+");

                            Product tempBook = new book(productIDFinal, name, price, yearFinal, author, publisher);
                            products.add(tempBook);
                            for(int i = 0; i < mapKey.length; i++)
                            {
                              map.put(mapKey[i], tempBook);  
                            }

                            addTextMessage.append( name + " has successfully been added\n");
                            aProdIDField.setText("");
                            aNameField.setText("");
                            aPriceField.setText("");
                            aYearField.setText("");
                            aAuthorField.setText("");
                            aPublisherField.setText("");
                            aMakerField.setText("");
                        }
                    }
                    catch(idTooShortException | yearTooOldException | emptyFieldException | idDuplicateException m)
                    {
                        addTextMessage.append((m.getMessage()) + "\n");
                        
                    }
                    
                }
                else if(productType.getSelectedItem().toString().equals("electronic"))
                {
                    try
                    {
                        if("".equals(aNameField.getText()) | "".equals(aProdIDField.getText()) | "".equals(aPriceField.getText()) | "".equals(aYearField.getText()) | "".equals(aMakerField.getText()))
                        {
                            throw new emptyFieldException("Missing information, please enter all text fields.");
                        }
                        else
                        {
                            String productID = aProdIDField.getText();
                            int productIDFinal = Integer.parseInt(productID);
                            String name = aNameField.getText();
                            String price = aPriceField.getText();
                            String year = aYearField.getText();
                            int yearFinal = Integer.parseInt(year);
                            String maker = aMakerField.getText();
                            String [] mapKey = new String[256];
                            mapKey = name.split("[ ]+");

                            Product tempElectronic = new electronics(productIDFinal, name, price, yearFinal, maker);
                            products.add(tempElectronic);
                            for(int i = 0; i < mapKey.length; i++)
                            {
                              map.put(mapKey[i], tempElectronic);  
                            }
                            addTextMessage.append( name + " has successfully been added\n");
                            aProdIDField.setText("");
                            aNameField.setText("");
                            aPriceField.setText("");
                            aYearField.setText("");
                            aAuthorField.setText("");
                            aPublisherField.setText("");
                            aMakerField.setText("");
                        }
                    }
                    catch(idTooShortException | yearTooOldException | emptyFieldException | idDuplicateException m)
                    {
                        addTextMessage.append((m.getMessage()) + "\n");
                    }
                    
                }  
           }
            
        });
        
        aNameLabel = new JLabel("Name:");
        c.gridx = 0;
        c.gridy = 4;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aNameLabel, c);
        
        c.gridx = 1;
        c.gridy = 4;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aNameField = new JTextField(20);
        addPanel.add(aNameField, c);
        
        aPriceLabel = new JLabel("Price:");
        c.gridx = 0;
        c.gridy = 5;
        c.weighty = 0.5;
        
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aPriceLabel, c);
        
        c.gridx = 1;
        c.gridy = 5;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aPriceField = new JTextField(10);
        addPanel.add(aPriceField, c);
        
        aYearLabel = new JLabel("Year:");
        c.gridx = 0;
        c.gridy = 6;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aYearLabel,c);
        
        c.gridx = 1;
        c.gridy = 6;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aYearField = new JTextField(10);
        addPanel.add(aYearField, c);
        
        aAuthorLabel = new JLabel("Authors:");
        c.gridx = 0;
        c.gridy = 7;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aAuthorLabel, c);
        
        c.gridx = 1;
        c.gridy = 7;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aAuthorField = new JTextField(20);
        addPanel.add(aAuthorField, c);
        
        aPublisherLabel = new JLabel("Publisher");
        c.gridx = 0;
        c.gridy = 8;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aPublisherLabel,c);
        
        c.gridx = 1;
        c.gridy = 8;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aPublisherField = new JTextField(20);
        addPanel.add(aPublisherField, c);
        
        aMakerLabel = new JLabel("Maker:");
        c.gridx = 0;
        c.gridy = 8;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(aMakerLabel,c);
        
        c.gridx = 1;
        c.gridy = 8;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        aMakerField = new JTextField(20);
        addPanel.add(aMakerField, c);
       
        c.ipady = 40;     
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 9;
        addTextMessage = new JTextArea(10,20);
        addScroll = new JScrollPane(addTextMessage);
        addScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        addTextMessage.setLineWrap(true);
        addPanel.add(addScroll,c);

        
        aMakerLabel.setVisible(false);
        aMakerField.setVisible(false);
        aMakerField.setEnabled(false);
        
        //////// search begins here//////
        
        
        searchTitle = new JLabel("Searching products");
        s.gridx = 0;
        s.gridy = 0;
        s.weightx = 0.5;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(searchTitle, s);
        
        
        sProdIDLabel = new JLabel("Product ID:");
        s.gridx = 0;
        s.gridy = 2;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sProdIDLabel, s);
        
        s.gridx = 1;
        s.gridy = 2;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        sProdIDField = new JTextField(15);
        searchPanel.add(sProdIDField, s);
        
        JButton sResetButton = new JButton("Reset");
        s.gridx = 2;
        s.gridy = 2;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sResetButton, s);
        sResetButton.addActionListener(new ActionListener ()
        {
           public void actionPerformed(ActionEvent e)
           {
               sProdIDField.setText("");
               sKeywordField.setText("");
               sStartYearField.setText("");
               sEndYearField.setText("");
           }
            
        });
        
        JButton sSearchButton = new JButton("Search");
        s.gridx = 2;
        s.gridy = 4;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sSearchButton, s);
        sSearchButton.addActionListener(new ActionListener ()
        {
           public void actionPerformed(ActionEvent e)
           {
               
               if(!"".equals(sKeywordField.getText()))
               {
               String [] searchKey = new String[256];
               searchKey = sKeywordField.getText().split("[ ]+");
               
               for(int i = 0; i < searchKey.length; i++)
               {
                   if(map.containsKey(searchKey[i].toLowerCase()))
                   {
                       searchTextMessage.append(map.get(searchKey[i]).sendSearchData() + "\n");
                   }
               }
               }
               else if(!"".equals(sProdIDField.getText()))
               {
                    int tempSize = products.size();
                    int tempID = Integer.parseInt(sProdIDField.getText());
                    for(int i = 0; i < tempSize; i++)
                    {
                        if(tempID == products.get(i).sendProdID())
                        {
                            searchTextMessage.append(products.get(i).sendSearchData() + "\n");
                        }
                    }
               }
               else if(!"".equals(sStartYearField.getText()) && !"".equals(sEndYearField.getText()))
               {
                   int tempStart = Integer.parseInt(sStartYearField.getText());
                   int tempEnd = Integer.parseInt(sEndYearField.getText());
                   int tempSize = products.size();
                   
                   for(int i = 0; i < tempSize; i++)
                   {
                       if(products.get(i).sendYear() > tempStart && products.get(i).sendYear() < tempEnd)
                       {
                           searchTextMessage.append(products.get(i).sendSearchData() + "\n");
                       }
                   }
               
               }
               else
               {
                   searchTextMessage.append("All fields empty, please enter a search term into any of the fields\n");
               }
               
           }
            
        });
        
        sKeywordLabel = new JLabel("Name/Keywords :");
        s.gridx = 0;
        s.gridy = 3;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sKeywordLabel, s);
        
        s.gridx = 1;
        s.gridy = 3;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        sKeywordField = new JTextField(20);
        searchPanel.add(sKeywordField, s);
        
        sStartYearLabel = new JLabel("Start Year:");
        s.gridx = 0;
        s.gridy = 4;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sStartYearLabel, s);
        
        s.gridx = 1;
        s.gridy = 4;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        sStartYearField = new JTextField(10);
        searchPanel.add(sStartYearField, s);
        
        sEndYearLabel = new JLabel("End Year:");
        s.gridx = 0;
        s.gridy = 5;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(sEndYearLabel, s);
        
        s.gridx = 1;
        s.gridy = 5;
        s.weighty = 0.5;
        s.fill = GridBagConstraints.HORIZONTAL;
        sEndYearField = new JTextField(10);
        searchPanel.add(sEndYearField, s);
        
       
        s.ipady = 40;
        s.weightx = 0.0;
        s.gridwidth = 3;
        s.gridx = 0;
        s.gridy = 6;
        searchTextMessage = new JTextArea(10,20);
        s.fill = GridBagConstraints.HORIZONTAL;
        searchScroll = new JScrollPane(searchTextMessage);
        searchScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        searchPanel.add(searchScroll,s);
//        searchPanel.add(searchTextMessage, s);
        

        add(commandList);
        add(welcomePanel);
        add(addPanel);
        add(searchPanel);        
        

    }

    public static void main(String[] args) 
    {        
        Cis2430a1 win = new Cis2430a1();
        win.setVisible(true);
    }

}
