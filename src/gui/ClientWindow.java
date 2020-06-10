package gui;

import guiTables.CarTable;
import guiTables.ServiceTable;
import main.Access;
import userModels.Client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carMenu = new JMenu("Automobili");
    private JMenuItem carItem = new JMenuItem("Manipulisanje");
    private JMenuItem serviceItem = new JMenuItem("Servisi");

    private Access access;
    private Client client;

    public DefaultTableModel tableModel;
    private JTable carTable;
    private JTable serviceTable;

    public ClientWindow(Access access, Client client) {
        this.access = access;
        this.client = client;
        setTitle("Musterija : " + client.getName());
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu () {
        setJMenuBar(mainMenu);
        mainMenu.add(carMenu);
        carMenu.add(carItem);
        mainMenu.add(serviceItem);
    }

    private void initActions () {
        carItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarTable carTable = new CarTable(access, 0);
                carTable.setVisible(true);
            }
        });
        serviceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceTable serviceWindow = new ServiceTable(access, 0);
                serviceWindow.setVisible(true);
            }
        });
    }
}
