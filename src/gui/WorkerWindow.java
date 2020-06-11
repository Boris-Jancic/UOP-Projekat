package gui;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import enums.Gender;
import guiTables.CarTable;
import guiTables.PartTable;
import guiTables.ServiceTable;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Worker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkerWindow extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carMenu = new JMenu("Automobili");
    private JMenuItem carItem = new JMenuItem("Pregled");
    private JMenu partMenu = new JMenu("Delovi");
    private JMenuItem partItem = new JMenuItem("Pregled");
    private JMenu serviceMenu = new JMenu("Servisi");
    private JMenuItem serviceItem = new JMenuItem("Pregled");

    private JLabel lblName;
    private JLabel lblLastName;
    private JLabel lblJmbg;
    private JLabel lblPhone;
    private JLabel lblAddress;
    private JLabel lblUserName;
    JLabel lblMalePicture = new JLabel(new ImageIcon("src/pictures/worker-male.png"));
    JLabel lblFemalePicture = new JLabel(new ImageIcon("src/pictures/worker-female.png"));

    private Access access;
    private Worker worker;
    private ArrayList<Car> cars;
    private ArrayList<Part> parts;
    private ArrayList<Service> services;

    public WorkerWindow(Worker worker, Access access, int i) {
        this.access = access;
        this.worker = worker;
        this.cars = access.getCars();
        this.parts = access.getParts();
        this.services = access.getServices();
        setTitle("Radnik : " + worker.getName());
        setSize(400,420);
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

        MigLayout migLayout = new MigLayout("wrap 1", "10[][]");
        setLayout(migLayout);

        if(worker.getGender() == Gender.MALE) {
            add(lblMalePicture, "gapleft 70");
        } else {
            add(lblFemalePicture, "gapleft 70");
        }

        add(lblName = new JLabel("Ime : " + worker.getName()), "gapleft 80");
        add(lblLastName = new JLabel("Prezime : " + worker.getLastName()),"gapleft 80");
        add(lblJmbg = new JLabel("JMBG : " + worker.getJmbg()), "gapleft 80");
        add(lblPhone = new JLabel("Telefon : " + worker.getPhone()), "gapleft 80");
        add(lblAddress = new JLabel("Adresa : " + worker.getAddress()), "gapleft 80");
        add(lblUserName = new JLabel("Korisnicko ime : " + worker.getUsername()), "gapleft 80");
    }

    private void initActions() {
        carItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarTable carTable = new CarTable(access, 1);
                carTable.setVisible(true);
            }
        });
        partItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PartTable partTable = new PartTable(access, 1);
                partTable.setVisible(true);
            }
        });
        serviceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceTable serviceTable = new ServiceTable(access, worker);
                serviceTable.setVisible(true);
            }
        });
    }
}
