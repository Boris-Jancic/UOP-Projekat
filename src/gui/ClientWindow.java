package gui;

import enums.Gender;
import guiTables.CarTable;
import guiTables.ServiceTable;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Client;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carMenu = new JMenu("Automobili");
    private JMenuItem carItem = new JMenuItem("Manipulisanje");
    private JMenuItem serviceItem = new JMenuItem("Servisi");


    JLabel lblMalePicture = new JLabel(new ImageIcon("src/pictures/client-male.png"));
    JLabel lblFemalePicture = new JLabel(new ImageIcon("src/pictures/client-female.png"));

    private Access access;
    private Client client;

    public ClientWindow(Access access, Client client) {
        this.access = access;
        this.client = client;
        setTitle("Musterija : " + client.getName());
        setSize(380,400);
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


        MigLayout migLayout = new MigLayout("wrap 1", "10[][]");
        setLayout(migLayout);

        if(client.getGender() == Gender.MALE) {
            add(lblMalePicture, "gapleft 70");
        } else {
            add(lblFemalePicture, "gapleft 70");
        }
        JLabel lblName;
        add(lblName = new JLabel("Ime : " + client.getName()), "gapleft 90");
        JLabel lblLastName;
        add(lblLastName = new JLabel("Prezime : " + client.getLastName()),"gapleft 90");
        JLabel lblJmbg;
        add(lblJmbg = new JLabel("JMBG : " + client.getJmbg()), "gapleft 90");
        JLabel lblPhone;
        add(lblPhone = new JLabel("Telefon : " + client.getPhone()), "gapleft 90");
        JLabel lblAddress;
        add(lblAddress = new JLabel("Adresa : " + client.getAddress()), "gapleft 90");
        JLabel lblUserName;
        add(lblUserName = new JLabel("Korisnicko ime : " + client.getUsername()), "gapleft 90");
    }

    private void initActions () {
        carItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarTable carTable = new CarTable(access, client);
                carTable.setVisible(true);
            }
        });
        serviceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceTable serviceWindow = new ServiceTable(access, client);
                serviceWindow.setVisible(true);
            }
        });
    }
}