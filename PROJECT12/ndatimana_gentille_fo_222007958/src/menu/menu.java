package menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import myform.customerform;
import myform.menuform;
import myform.orderform;
import myform.paymentform;
import myform.restaurantform;

public class menu extends JFrame implements ActionListener {
    JFrame frame;

    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu customermenu;
    private JMenu menumenu;
    private JMenu ordermenu;
    private JMenu paymentmenu;
    private JMenu restaurantmenu;
    private JMenu Logoutmenu;

    public menu() {
        // TODO Auto-generated constructor stub
    }

    private JMenuItem customerItem;
    private JMenuItem menuItem;
    private JMenuItem orderItem;
    private JMenuItem paymentItem;
    private JMenuItem restaurantItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        customermenu = new JMenu("Customer");
        menumenu = new JMenu("Menu");
        ordermenu = new JMenu("Order");
        paymentmenu = new JMenu("Payment");
        restaurantmenu = new JMenu("Restaurant");
        Logoutmenu = new JMenu("Logout");

        // Create menu items
        customerItem = new JMenuItem("customer form");
        customerItem.addActionListener(this);

        menuItem = new JMenuItem("menuform");
        menuItem.addActionListener(this);

        orderItem = new JMenuItem("order form");
        orderItem.addActionListener(this);

        paymentItem = new JMenuItem("payment form");
        paymentItem.addActionListener(this);

        restaurantItem = new JMenuItem("restaurant form");
        restaurantItem.addActionListener(this);

        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        customermenu.add(customerItem);
        menumenu.add(menuItem);
        ordermenu.add(orderItem);
        paymentmenu.add(paymentItem);
        restaurantmenu.add(restaurantItem);

        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(customermenu);
        menuBar.add(menumenu);
        menuBar.add(ordermenu);
        menuBar.add(paymentmenu);
        menuBar.add(restaurantmenu);
        menuBar.add(Logoutmenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerItem) {
            new customerform();
        } else if (e.getSource() == menuItem) {
            new menuform();
        } else if (e.getSource() == orderItem) {
            new orderform();
        } else if (e.getSource() == paymentItem) {
            new paymentform();
        } else if (e.getSource() == restaurantItem) {
            new restaurantform();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] argStrings) {
        SwingUtilities.invokeLater(() -> new menu("ndatimana_gentille_fo_222007958"));
    }
}
