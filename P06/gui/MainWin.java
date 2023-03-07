package gui;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons

import org.w3c.dom.events.Event;

import store.Computer;
import store.Customer;
import store.Store;

import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file        = new JMenu("File");
        JMenuItem quit        = new JMenuItem("Quit");
        JMenu     insert      = new JMenu("Insert");
        JMenuItem icustomer   = new JMenuItem("Customer");
        JMenuItem ioption     = new JMenuItem("Option");
        JMenuItem icomputer   = new JMenuItem("Computer");
        JMenuItem iorder      = new JMenuItem("Order");
        JMenu     view        = new JMenu("View");
        JMenuItem vcustomer   = new JMenuItem("Customer");
        JMenuItem voption     = new JMenuItem("Option");
        JMenuItem vcomputer   = new JMenuItem("Computer");
        JMenuItem vorder      = new JMenuItem("Order");
        JMenu     help        = new JMenu("Help");
        JMenuItem about       = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        icustomer.addActionListener(event -> onInsertCustomerClick());
        ioption.addActionListener(event -> onInsertOptionClick());
        icomputer.addActionListener(event -> onInsertComputerClick());
        vcustomer.addActionListener(event -> onViewClick(Record.CUSTOMER));
        voption.addActionListener(event -> onViewClick(Record.OPTION));
        vcomputer.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());

        
        
        file.add(quit);
        insert.add(icustomer);
        insert.add(ioption);
        insert.add(icomputer);
        insert.add(iorder);
        view.add(vcustomer);
        view.add(voption);
        view.add(vcomputer);
        view.add(vorder);
        help.add(about);
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        setJMenuBar(menubar);
        /* 
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Nim Controls");

        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        
        // Create a toggle button to enable or disable the computer player
        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());
        
        // Create a custom Quit button (not available in Swing stock icons)
        JButton quitB  = new JButton("X");
          quitB.setActionCommand("Quit");
          quitB.setToolTipText("Exit Store");
          quitB.setBorder(null);
          toolbar.add(quitB);
          quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        */
        
        // /////////////////////////// ////////////////////////////////////////////
        // C O M P U T E R  D I S P L A Y
        // Provide a text entry box to show the available Computers
        computers = new JLabel();
        computers.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(computers, BorderLayout.CENTER);

        customers = new JLabel();
        customers.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(customers, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
   
        
        // Make everything in the JFrame visible
        setVisible(true);
        
    }
    
    // Listeners
    
    protected void onInsertCustomerClick() {
        try{
            Customer newbieCustomer;
            String email;

            String name = JOptionPane.showInputDialog(this, "Name of the new Customer!","Input Name", JOptionPane.QUESTION_MESSAGE);
            if(name == null){
                throw new IllegalArgumentException("Error: We have to call you something");
            }
            email = JOptionPane.showInputDialog(this, "Enter Customer's email address: ", "Input Email", JOptionPane.QUESTION_MESSAGE);
            if(email == null){
                throw new IllegalArgumentException("Error: We need your email address");
            }
            Store.add(new store.Customer(name, email));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"ERROR",e.getMessage(), JOptionPane.ERROR_MESSAGE);
            onInsertCustomerClick();
        }
    }

    protected void onInsertComputerClick() {
        try{
            Computer newComputer;
            String name;
            String model;
            JButton
        }
    }
    protected void onInsertOptionClick() {

    }
    protected void onViewClick(Record record) {

    }

    protected void onAboutClick() {                 // Display About dialog
        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "<p>Version 1.4J</p>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, artists},
             "The Game of Nim",
             JOptionPane.PLAIN_MESSAGE
        );
    }

/*
    // This is an alternate About dialog using JDialog instead of JOptionPane
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("The Game of Nim");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.4J</p>"
          + "<p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
    }
    */
    protected void onQuitClick() {System.exit(0);}   // Exit the store

    private JLabel computers;
    private JLabel customers;
}
