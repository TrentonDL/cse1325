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
import java.util.ArrayList;
import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        
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
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("ELSA Controls");

        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        JButton bAddCustomer = new JButton(new ImageIcon("gui/resources/add_customer.png"));
            bAddCustomer.setActionCommand("Insert Customer");
            bAddCustomer.setToolTipText("Insert Customer");
            toolbar.add(bAddCustomer);
            bAddCustomer.addActionListener(event ->onInsertCustomerClick());

        JButton bAddOption = new JButton(new ImageIcon("gui/resources/add_option.png"));
            bAddOption.setActionCommand("Insert Option");
            bAddOption.setToolTipText("Insert Option");
            toolbar.add(bAddOption);
            bAddOption.addActionListener(event -> onInsertOptionClick());

        JButton bAddComputer = new JButton(new ImageIcon("gui/resources/add_computer.png"));
            bAddComputer.setActionCommand("Insert Computer");
            bAddComputer.setToolTipText("Insert Computer");
            toolbar.add(bAddComputer);
            bAddComputer.addActionListener(event -> onInsertComputerClick());
        
        toolbar.add(Box.createHorizontalStrut(25));

        // Create the 3 buttons using the icons provided
        JButton bViewCustomers = new JButton(new ImageIcon("gui/resources/view_customers.png"));
            bViewCustomers.setActionCommand("View Customer");
            bViewCustomers.setToolTipText("View Customers");
            toolbar.add(bViewCustomers);
            bViewCustomers.addActionListener(event ->onViewClick(Record.CUSTOMER));

        JButton bViewOptions = new JButton(new ImageIcon("gui/resources/view_options.png"));
            bViewOptions.setActionCommand("View Options");
            bViewOptions.setToolTipText("View Options");
            toolbar.add(bViewOptions);
            bViewOptions.addActionListener(event -> onViewClick(Record.OPTION));

        JButton bViewComputers = new JButton(new ImageIcon("gui/resources/view_computers.png"));
            bViewComputers.setActionCommand("View Computers");
            bViewComputers.setToolTipText("View Computers");
            toolbar.add(bViewComputers);
            bViewComputers.addActionListener(event -> onViewClick(Record.COMPUTER));
        
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
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
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // C O M P U T E R  D I S P L A Y
        // Provide a text entry box to show the available Computers
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 14));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);
        
        // Make everything in the JFrame visible
        setVisible(true);
        
    }
    
    // Listeners
    
    protected void onInsertCustomerClick() {
        try{
            String name = JOptionPane.showInputDialog(this, "Name of the new Customer!","Input Name", JOptionPane.QUESTION_MESSAGE);
            if(name == null || name.equals("")){
                throw new IllegalArgumentException("Error: We have to call you something");
            }
            String email = JOptionPane.showInputDialog(this, "Enter Customer's email address: ", "Input Email", JOptionPane.QUESTION_MESSAGE);
            if(email == null || name.equals("")){
                throw new IllegalArgumentException("Error: We need your email address");
            }
            store.add(new Customer(name, email));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertComputerClick() {
        try{
            String name = JOptionPane.showInputDialog(this, "Name of the new Computer: ","Input Computer Name", JOptionPane.QUESTION_MESSAGE);
            if(name == null || name.equals("")){
                throw new IllegalArgumentException("Error: Every Computer needs a name");
            }
            String model = JOptionPane.showInputDialog(this, "Enter the computer's model name: ", "Input Computer Model", JOptionPane.QUESTION_MESSAGE);
            if(model == null || model.equals("")){
                throw new IllegalArgumentException("Error: Gotta have a model Number");
            }
            store.add(new Computer(name, model));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    protected void onInsertOptionClick() {
        try{
            String name = JOptionPane.showInputDialog(this, "Enter a name for the Computer part: ","Input Computer Name", JOptionPane.QUESTION_MESSAGE);
            if(name == null || name.equals("")){
                throw new IllegalArgumentException("Error: This Option needs a name");
            }
            String price = JOptionPane.showInputDialog(this, "Enter the part's cost: ", "Input Computer Model", JOptionPane.QUESTION_MESSAGE);
            long cost = (long) Double.parseDouble(price) * 100;
            if(price == null || price.equals("") || cost < 0){
                throw new IllegalArgumentException("Error: Enter a valid cost!");
            }
            store.add(new store.Option(name, cost));
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void onViewClick(Record record) {
        String header = null;
        Object[] list = null;
        switch (record) {
            case CUSTOMER:
                header = "Our Beloved Customers";
                list = store.customers();
                break;
            case COMPUTER:
                header = "Computers for Sale - Cheap!";
                list = store.computers();
                break;
            case OPTION:
                header = "Options for our SuperComputers";
                list = store.options();
                break;
            case ORDER:
                header = "Orders Placed to Date";
                list = store.orders();
                break;
            default:
                break;
        }

        StringBuilder sb = new StringBuilder("<html><p><font size=+2>" 
                                + header + "</font></p><br/>\n<ol>\n");
        for(Object i : list) sb.append("<li>" + i.toString().replaceAll("<","&lt;")
                                        .replaceAll(">", "&gt;")
                                        .replaceAll("\n", "<br/>") + "</li>\n");
        sb.append("</ol></html>");
        display.setText(sb.toString());
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

    private Store store;
    private JLabel display;
}
