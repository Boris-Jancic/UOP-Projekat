package gui;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import guiTables.CarTable;
import guiTables.ServiceTable;
import main.Access;
import userModels.Worker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkerWindow extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carMenu = new JMenu("Automobili");
    private JMenuItem carItem = new JMenuItem("Manipulisanje");
    private JMenuItem serviceItem = new JMenuItem("Servisi");

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
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(carMenu);
        carMenu.add(carItem);
        mainMenu.add(serviceItem);
    }

    private void initActions() {
        carItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarTable carTable = new CarTable(access, 1);
                carTable.setVisible(true);
            }
        });
        serviceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceTable serviceWindow = new ServiceTable(access, 1);
                serviceWindow.setVisible(true);
            }
        });
    }
}
