package guiForms;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import enums.Status;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import utility.WriteToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class ServiceForm extends JFrame {
    private JLabel lblCar = new JLabel("ID Automobila");
    private JComboBox<String> cbCar = new JComboBox();
    private JLabel lblWorker = new JLabel("Korisnicko Ime radnika");
    private TextField txtWorker = new TextField(20);
    private JLabel lblDate = new JLabel("Datum");
    private TextField txtDate = new TextField(20);
    private JLabel lblDescription = new JLabel("Opis");
    private TextField txtDescription = new TextField(20);
    private JLabel lblParts = new JLabel("delovi");
    private TextField txtParts = new TextField(20);
    private JLabel lblStatus = new JLabel("Stanje");
    private JComboBox<Status> cbStatus = new JComboBox<>(Status.values());

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel= new JButton("Otkazi");

    private Access access;
    private Person person;
    private Service service;

    public ServiceForm(Access access, Person person, Service service) {
        this.access = access;
        this.service = service;
        this.person = person;

        setLocationRelativeTo(null);
        setTitle("Unos servisa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        ArrayList<Car> cars = new ArrayList<>();
        if (person instanceof Client) {
            cars = access.getClientCars(person.getId());
        } else {
            cars = access.getCars();
        }

        for (Car car : cars) {
            cbCar.addItem(car.getCarID());
        }

        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (service != null) {
            fillBlanks();
        }

        if (person instanceof Client) {
            add(lblCar);add(cbCar);
            add(lblDescription);add(txtDescription);
        } else if (person instanceof Worker) {
            add(lblCar);add(cbCar);
            add(lblDescription);add(txtDescription);
            add(lblDate);add(txtDate);
            add(lblParts);add(txtParts);
        } else if (person instanceof Admin) {
            add(lblWorker);add(txtWorker);
            add(lblCar);add(cbCar);
            add(lblDescription);add(txtDescription);
            add(lblDate);add(txtDate);
            add(lblParts);add(txtParts);
            add(lblStatus);add(cbStatus);
        }

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void fillBlanks() {
        cbCar.setSelectedItem(service.getCar().getCarID());
        txtDescription.setText(service.getDescription());
        cbStatus.setSelectedItem(service.getStatus());

        if (service.getWorker() != null) {
            txtWorker.setText(service.getWorker().getUsername());
            txtDate.setText(Checks.dateToString(service.getReservation()));
            txtParts.setText(service.printParts());
        }
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation()) {
                    Car car = access.findCar(cbCar.getSelectedItem().toString());
                    Worker worker = access.findWorker(txtWorker.getText());
                    GregorianCalendar date = Checks.stringToDate(txtDate.getText());
                    String description = txtDescription.getText();
                    ArrayList<Part> parts = access.findParts(txtParts.getText().split(";"));
                    Status status = (Status) cbStatus.getSelectedItem();

                    if (service == null) {
                        Random r = new Random();
                        int randomID = r.nextInt(999999);

                        if (person instanceof Client) {
                            service = new Service(car, description, Status.ZAKAZAN, Integer.toString(randomID), false);
                        } else {
                            service = new Service(car, worker, date, description,
                                    parts, status, Integer.toString(randomID), false);
                        }

                        access.addService(service);
                    } else {
                        service.setCar(car);
                        service.setWorker(worker);
                        service.setReservation(date);
                        service.setDescription(description);
                        service.setUsedParts(parts);
                        service.setStatus(status);
                    }
                    access.updateCarBooks();
                    WriteToFile.writeCarBook(access.getCarBooks());
                    WriteToFile.writeService(access.getServices());
                    ServiceForm.this.dispose();
                    ServiceForm.this.setVisible(false);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceForm.this.dispose();
                ServiceForm.this.setVisible(false);
            }
        });
    }

    private boolean validation() {
        String message = "Molimo vas da uradite sledece stvari : \n";
        boolean ok = true;

        if (!(person instanceof Client)) {
            if (txtWorker.getText().isEmpty()) {
                message += "- Unesite korisnicko ime za radinika\n";
            } else if (!txtWorker.getText().trim().isEmpty()) {
                Worker worker = access.findWorker(txtWorker.getText());
                if (worker == null) {
                    message += "- Radnik sa takvim korisnickim imenom ne postoji\n";
                    ok = false;
                }
            }
            if (txtParts.getText().isEmpty()) {
                message += "- Unesite delove za servis\n";
                ok = false;
            } else if (!txtParts.getText().isEmpty()) {
                String[] partIDs = txtParts.getText().split(";");
                ArrayList<Part> parts = access.findParts(partIDs);

                if (parts.isEmpty()) {
                    message += "- Unesite ispravne ID-jeve delova za servis\n";
                    ok = false;
                }
            }
        }

        if (txtDescription.getText().isEmpty()) {
            message += "- Unesite opis servisa\n";
            ok = false;
        }

        if (ok == false) {
            JOptionPane.showMessageDialog(null, message,
                    "Greska !", JOptionPane.WARNING_MESSAGE);
        }
        return ok;
    }
}
