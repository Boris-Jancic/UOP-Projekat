package guiForms;

import carModels.Service;
import enums.Status;
import main.Access;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ServiceForm extends JFrame {
    private JLabel lblCar = new JLabel("ID Automobila");
    private TextField txtCar = new TextField(10);
    private JLabel lblWorker = new JLabel("Radnik");
    private TextField txtWorker = new TextField(10);
    private JLabel lblDate = new JLabel("Datum");
    private TextField txtDate = new TextField(10);
    private JLabel lblDescription = new JLabel("Opis");
    private TextField txtDescription = new TextField(20);
    private JLabel lblStatus = new JLabel("Stanje");
    private JComboBox<Status> cbStatus = new JComboBox<>(Status.values());

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel= new JButton("Otkazi");

    private Access access;
    private Service service;

    public ServiceForm(Access access, Service service) {
        this.access = access;
        this.service = service;

        setLocationRelativeTo(null);
        setTitle("Unos servisa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (service != null) {
            fillBlanks();
        }

        add(lblCar);add(txtCar);
        add(lblWorker);add(txtWorker);
        add(lblDate);add(txtDate);
        add(lblDescription);add(txtDescription);
        add(lblStatus);add(cbStatus);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void fillBlanks() {
        txtCar.setText(service.getCar().getCarID());
        txtWorker.setText(service.getWorker().getUsername());
        txtDate.setText(service.getReservation().toString());
        txtDescription.setText(service.getDescription());
        cbStatus.setSelectedItem(service.getStatus());
    }

    private void initActions() {
    }
}
