package gui;

import javax.swing.JFrame; // for main window
import javax.swing.JOptionPane; // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar; // row of menu selections
import javax.swing.JMenu; // menu selection that offers another menu
import javax.swing.JMenuItem; // menu selection that does something
import javax.swing.JToolBar; // row of buttons under the menu
import javax.swing.JButton; // regular button
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton; // 2-state button
import javax.swing.BorderFactory; // manufacturers Border objects around buttons
import javax.swing.Box; // to create toolbar spacer
import javax.swing.UIManager; // to access default icons
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.events.Event;

import store.Computer;
import store.Customer;
import store.Option;
import store.Order;
import store.Store;

import javax.swing.JLabel; // text or image holder
import javax.swing.ImageIcon; // holds a custom icon
import javax.swing.SwingConstants; // useful values for Swing method calls

import javax.imageio.ImageIO; // loads an image from a file

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File; // opens a file
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // reports an error reading from a file
import java.util.ArrayList;
import java.awt.BorderLayout; // layout manager for main window
import java.awt.FlowLayout; // layout manager for About dialog

import java.awt.Color; // the color of widgets, text, or borders
import java.awt.Font; // rich text in a JLabel or similar widget
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem fnew = new JMenuItem("New");
        JMenuItem fopen = new JMenuItem("Open");
        JMenuItem fsave = new JMenuItem("Save");
        JMenuItem fsaveAs = new JMenuItem("Save As");
        JMenuItem fquit = new JMenuItem("Quit");

        JMenu insert = new JMenu("Insert");
        JMenuItem icustomer = new JMenuItem("Customer");
        JMenuItem ioption = new JMenuItem("Option");
        JMenuItem icomputer = new JMenuItem("Computer");
        JMenuItem iorder = new JMenuItem("Order");

        JMenu view = new JMenu("View");
        JMenuItem vcustomer = new JMenuItem("Customer");
        JMenuItem voption = new JMenuItem("Option");
        JMenuItem vcomputer = new JMenuItem("Computer");
        JMenuItem vorder = new JMenuItem("Order");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        fnew.addActionListener(event -> onNewClick());
        fopen.addActionListener(event -> {
            try {
                onOpenClick();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
        fsave.addActionListener(event -> {
            try {
                onSaveClick();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Unable to save: " + e, "Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
        fsaveAs.addActionListener(event -> {
            try {
                onSaveAsClick();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
        fquit.addActionListener(event -> onQuitClick());

        icustomer.addActionListener(event -> onInsertCustomerClick());
        ioption.addActionListener(event -> onInsertOptionClick());
        icomputer.addActionListener(event -> onInsertComputerClick());

        vcustomer.addActionListener(event -> onViewClick(Record.CUSTOMER));
        voption.addActionListener(event -> onViewClick(Record.OPTION));
        vcomputer.addActionListener(event -> onViewClick(Record.COMPUTER));

        about.addActionListener(event -> onAboutClick());

        file.add(fnew);
        file.add(fopen);
        file.add(fsave);
        file.add(fsaveAs);
        file.add(fquit);
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
            bAddCustomer.addActionListener(event -> onInsertCustomerClick());

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

        JButton bSaveStore = new JButton(new ImageIcon("gui/resources/save_store.png"));
            bSaveStore.setActionCommand("Save Store");
            bSaveStore.setToolTipText("Save Store to a File");
            toolbar.add(bSaveStore);
            bSaveStore.addActionListener(event -> {
                try {
                    onSaveAsClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        JButton bLoadStore = new JButton(new ImageIcon("gui/resources/load_store.png"));
            bLoadStore.setActionCommand("Load Store");
            bLoadStore.setToolTipText("Load a Previous Store saved to a file");
            toolbar.add(bLoadStore);
            bLoadStore.addActionListener(event -> {
                try {
                    onOpenClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        toolbar.add(Box.createHorizontalStrut(25));

        // Create the 3 buttons using the icons provided
        JButton bViewCustomers = new JButton(new ImageIcon("gui/resources/view_customers.png"));
            bViewCustomers.setActionCommand("View Customer");
            bViewCustomers.setToolTipText("View Customers");
            toolbar.add(bViewCustomers);
            bViewCustomers.addActionListener(event -> onViewClick(Record.CUSTOMER));

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
        JButton quitB = new JButton("X");
        quitB.setActionCommand("Quit");
        quitB.setToolTipText("Exit Store");
        quitB.setBorder(null);
        toolbar.add(quitB);
        quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        // /////////////////////////// ////////////////////////////////////////////
        // C O M P U T E R D I S P L A Y
        // Provide a text entry box to show the available Computers
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 14));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        // Make everything in the JFrame visible
        setVisible(true);

        store = new Store("ELSA");
    }

    // Listeners

    protected void onInsertCustomerClick() {
        try {
            String name = JOptionPane.showInputDialog(this, "Name of the new Customer!", "Input Name",
                    JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.equals("")) {
                throw new IllegalArgumentException("Error: We have to call you something");
            }
            String email = JOptionPane.showInputDialog(this, "Enter Customer's email address: ", "Input Email",
                    JOptionPane.QUESTION_MESSAGE);
            if (email == null || name.equals("")) {
                throw new IllegalArgumentException("Error: We need your email address");
            }
            store.add(new Customer(name, email));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertComputerClick() {
        try {
            Computer c = new Computer(
                    JOptionPane.showInputDialog(this, "Computer name",
                            "New Computer", JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(this, "Computer model",
                            "New Computer", JOptionPane.QUESTION_MESSAGE));

            JComboBox<Object> cb = new JComboBox<>(store.options());
            int optionsAdded = 0; // Don't add computers with no options
            while (true) {
                int button = JOptionPane.showConfirmDialog(this, cb,
                        "Another Option?", JOptionPane.YES_NO_OPTION);
                if (button != JOptionPane.YES_OPTION)
                    break;
                c.addOption((Option) cb.getSelectedItem());
                ++optionsAdded;
            }
            if (optionsAdded > 0) {
                store.add(c);
                onViewClick(Record.COMPUTER);
            } else {
                throw new NullPointerException("A working Computer need parts in it");
            }
        } catch (NullPointerException e) {
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Computer Not Created", JOptionPane.ERROR_MESSAGE);
        }

    }

    protected void onInsertOptionClick() {
        try {
            String name = JOptionPane.showInputDialog(this, "Enter a name for the Computer part: ",
                    "Input Computer Name", JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.equals("")) {
                throw new IllegalArgumentException("Error: This Option needs a name");
            }
            String price = JOptionPane.showInputDialog(this, "Enter the part's cost: ", "Input Computer Model",
                    JOptionPane.QUESTION_MESSAGE);
            long cost = (long) Double.parseDouble(price) * 100;
            if (price == null || price.equals("") || cost < 0) {
                throw new IllegalArgumentException("Error: Enter a valid cost!");
            }
            store.add(new store.Option(name, cost));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        for (Object i : list)
            sb.append("<li>" + i.toString().replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\n", "<br/>") + "</li>\n");
        sb.append("</ol></html>");
        display.setText(sb.toString());
    }

    protected void onAboutClick() { // Display About dialog
        Canvas logo = new Canvas("gui/resources/logo_base.png");
         
        JLabel title = new JLabel("<html>"
                + "<p><font size=+4>ELSA</font></p>"
                + "</html>",
                SwingConstants.CENTER);

        JLabel subtitle = new JLabel("<html>"
                + "<p>Exceptional Laptops and Supercomputers Always</p>"
                + "</html>",
                SwingConstants.CENTER);

        JLabel version = new JLabel("<html>"
                + "<p>Version 0.3</p>"
                + "</html>",
                SwingConstants.CENTER);
        JLabel artists = new JLabel("<html>"
                + "<br/><p>Copright 2023 by Trenton D. Laule</p>"
                + "<p>Licensed under GNU GPL 3.0</p><br/>"
                + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
                + "<p>Licensed under Gnu GPL 3.0</p><br/>"
                + "<br/><p>Add Customer icon based on work by Dreamstate per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/user_3114957</font></p>"

                + "<br/><p>View Customers icon based on work by Ilham Fitrotul Hayat per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/group_694642</font></p>"

                + "<br/><p>Add Option icon based on work by Freepik per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/quantum-computing_4103999</font></p>"

                + "<br/><p>View Options icon based on work by Freepik per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/edge_8002173</font></p>"

                + "<br/><p>Add Computer icon based on work by Freepik per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/laptop_689396</font></p>"

                + "<br/><p>View Computers icon based on work by Futuer per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/computer-networks_9672993</font></p>"

                + "<br/><p>Save Store icon based on work by surang per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/save_6078101</font></p>"

                + "<br/><p>Load Store icon based on work by Freepik per the Flaticon License</p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/loading_2209941</font></p>"

                + "</html>");

        JOptionPane.showMessageDialog(this,
                new Object[] { logo, title, subtitle, version, artists },
                "ELSA",
                JOptionPane.PLAIN_MESSAGE);
    }

    protected void onNewClick() {
        try{    
            String name = JOptionPane.showInputDialog(this, "Name of the new Store", "Input Name",
            JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.equals("")) 
                throw new IllegalArgumentException("Error: Your Store needs a Name");
            
            store = new Store(name);

        }catch(IllegalArgumentException i){
            JOptionPane.showMessageDialog(this, i.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onOpenClick() throws IOException {
        JFileChooser fc = new JFileChooser(filename);
        FileNameExtensionFilter elsaFilter = new FileNameExtensionFilter("ELSA files", "elsa");
        fc.addChoosableFileFilter(elsaFilter);
        fc.setFileFilter(elsaFilter);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                store = new Store(br.readLine());
                store.Store(br);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onSaveClick() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            store.save(bw);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onSaveAsClick() throws IOException {
        try {
            final JFileChooser fc = new JFileChooser(filename);
            FileNameExtensionFilter elsaFiles = new FileNameExtensionFilter("ELSA files", "elsa");
            fc.addChoosableFileFilter(elsaFiles);
            fc.setFileFilter(elsaFiles);

            int result = fc.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                filename = fc.getSelectedFile();
                if (!filename.getAbsolutePath().endsWith(".elsa"))
                    filename = new File(filename.getAbsolutePath() + ".elsa");
                onSaveClick();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onQuitClick() {
        System.exit(0);
    } // Exit the store

    private Store store;
    private JLabel display;
    private File filename;
    private BufferedImage image;
}
