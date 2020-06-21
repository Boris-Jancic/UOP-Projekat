package gui;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import enums.Gender;
import guiTables.*;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AdminWindow extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carMenu = new JMenu("Automobili");
    private JMenuItem carItem = new JMenuItem("Pregled");
    private JMenu partMenu = new JMenu("Delovi");
    private JMenuItem partItem = new JMenuItem("Pregled");
    private JMenu serviceMenu = new JMenu("Servisi");
    private JMenuItem serviceItem = new JMenuItem("Pregled");
    private JMenu userMenu = new JMenu("Korisnici");

    private JMenuItem clientItem = new JMenuItem("Musterije");
    private JMenuItem workerItem = new JMenuItem("Radnici");
    private JMenuItem adminItem = new JMenuItem("Administratori");

    JLabel lblMalePicture = new JLabel(new ImageIcon("src/pictures/admin-male.png"));
    JLabel lblFemalePicture = new JLabel(new ImageIcon("src/pictures/admin-female.png"));

    private Access access;
    private Admin admin;

    public AdminWindow(Admin admin, Access access) {
        this.access = access;
        this.admin = admin;
        ArrayList<Car> cars = access.getCars();
        ArrayList<Part> parts = access.getParts();
        ArrayList<Service> services = access.getServices();
        setTitle("Administrator : " + admin.getName());
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(carMenu);carMenu.add(carItem);
        mainMenu.add(partMenu);partMenu.add(partItem);
        mainMenu.add(serviceMenu);serviceMenu.add(serviceItem);
        mainMenu.add(userMenu);
        userMenu.add(clientItem);
        userMenu.add(workerItem);
        userMenu.add(adminItem);

        MigLayout migLayout = new MigLayout("wrap 1", "10[][]");
        setLayout(migLayout);

        if(admin.getGender() == Gender.MALE) {
            add(lblMalePicture, "gapleft 80");
        } else {
            add(lblFemalePicture, "gapleft 80");
        }
        JLabel lblName;
        add(lblName = new JLabel("Ime : " + admin.getName()), "gapleft 90");
        JLabel lblLastName;
        add(lblLastName = new JLabel("Prezime : " + admin.getLastName()),"gapleft 90");
        JLabel lblJmbg;
        add(lblJmbg = new JLabel("JMBG : " + admin.getJmbg()), "gapleft 90");
        JLabel lblPhone;
        add(lblPhone = new JLabel("Telefon : " + admin.getPhone()), "gapleft 90");
        JLabel lblAddress;
        add(lblAddress = new JLabel("Adresa : " + admin.getAddress()), "gapleft 90");
        JLabel lblUserName;
        add(lblUserName = new JLabel("Korisnicko ime : " + admin.getUsername()), "gapleft 90");
    }

    private void initActions() {
        carItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarTable carTable = new CarTable(access, admin);
                carTable.setVisible(true);
            }
        });

        partItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PartTable partWindow = new PartTable(access, admin);
                partWindow.setVisible(true);
            }
        });

        serviceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceTable serviceWindow = new ServiceTable(access, admin);
                serviceWindow.setVisible(true);
            }
        });

        clientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientTable clientTable = new ClientTable(access);
                clientTable.setVisible(true);
            }
        });

        workerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkerTable workerTable = new WorkerTable(access);
                workerTable.setVisible(true);
            }
        });

        adminItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminTable adminTable = new AdminTable(access);
                adminTable.setVisible(true);
            }
        });
    }
}