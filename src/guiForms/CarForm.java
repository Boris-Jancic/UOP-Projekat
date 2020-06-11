package guiForms;

import carModels.Car;
import enums.Fuel;
import enums.Mark;
import enums.Model;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Client;
import utility.WriteToFile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

public class CarForm extends JFrame {
    private JLabel lblClient = new JLabel("Klijent");
    private JTextField txtClient = new JTextField(10);
    private JLabel lblMark = new JLabel("Marka");
    private JComboBox<Mark> cbMark =new JComboBox<>(Mark.values());
    private JLabel lblModel = new JLabel("Model");
    private JComboBox<Model> cbModel =new JComboBox<>(Model.values());
    private JLabel lblFuel = new JLabel("Gorivo");
    private JComboBox<Fuel> cbFuel =new JComboBox<>(Fuel.values());
    private JLabel lblAge = new JLabel("Godiste");
    private JTextField txtAge = new JTextField(10);
    private JLabel lblEngineVol = new JLabel("Zapremina motora");
    private JTextField txtEngineVol = new JTextField(10);
    private JLabel lblEnginePow = new JLabel("Jacina motora");
    private JTextField txtEnginePow = new JTextField(10);

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Otkazi");
    private Car car;
    private Access access;

    public CarForm(Access access, Car car) {
        this.access = access;
        this.car = car;
        setLocationRelativeTo(null);
        setTitle("Unos automobila");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (car != null) {
            fillBlanks();
        }

        add(lblClient);add(txtClient);
        add(lblMark);add(cbMark);
        add(lblModel);add(cbModel);
        add(lblFuel);add(cbFuel);
        add(lblAge);add(txtAge);
        add(lblEngineVol);add(txtEngineVol);
        add(lblEnginePow);add(txtEnginePow);
        add(new JLabel());
        add(btnOk, "split 2");add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation()) {
                    String clientUsername = txtClient.getText().trim();
                    Client client = access.findClient(clientUsername);
                    Mark carMark = (Mark) cbMark.getSelectedItem();
                    Model carModel = (Model) cbModel.getSelectedItem();
                    Fuel carFuel = (Fuel) cbFuel.getSelectedItem();
                    String age = txtAge.getText().trim();
                    float engineVol = Float.parseFloat(txtEngineVol.getText().trim());
                    int enginePow = Integer.parseInt(txtEnginePow.getText().trim());

                    if (car == null) {
                        Random r = new Random();
                        int randomID = r.nextInt(999999);
                        car = new Car(client, Integer.toString(randomID), carMark,
                                carModel, carFuel, age, engineVol, enginePow, false);
                        access.addCar(car);
                    } else {
                        car.setClient(client);
                        car.setMark(carMark);
                        car.setModel(carModel);
                        car.setFuel(carFuel);
                        car.setAge(age);
                        car.setEngineVolume(enginePow);
                        car.setEnginePower(enginePow);
                    }
                    WriteToFile.writeCars(access.getCars());
                    CarForm.this.dispose();
                    CarForm.this.setVisible(false);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarForm.this.dispose();
                CarForm.this.setVisible(false);
            }
        });
    }

    private void fillBlanks() {
        txtClient.setText(car.getClient().getUsername());
        cbMark.setSelectedItem(car.getMark());
        cbModel.setSelectedItem(car.getModel());
        cbFuel.setSelectedItem(car.getFuel());
        cbMark.setSelectedItem(car.getMark());
        txtAge.setText(car.getAge());
        txtEngineVol.setText(Float.toString(car.getEngineVolume()));
        txtEnginePow.setText(Integer.toString(car.getEnginePower()));
    }

    private boolean validation() {
        boolean ok = true;
        String message = "Molimo vas da popravite sledece podatke : \n";

        if (txtClient.getText().trim().isEmpty()) {
            message += "- Unesite musteriju\n";
            ok = false;
        } else if(!txtClient.getText().trim().isEmpty()) {
            Client client = access.findClient(txtClient.getText());
            if (client == null) {
                message += "- Muskterija sa takvim korisnickim imenom ne postoji\n";
                ok = false;
            }
        }

        String age = txtAge.getText().trim();
        if (age.isEmpty()) {
            message += "- Unesite godiste automobila\n";
            ok = false;
        } else if(!age.isEmpty() && age.matches("[0-9]+") && age.length() == 4) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int setYear = Integer.parseInt(txtAge.getText().trim());
            if (currentYear < setYear || setYear < 1970) {
                message += "- Unesite pravilno godiste automobila\n";

                ok = false;
            }
        }

        if (txtEnginePow.getText().trim().isEmpty()) {
            message += "- Unesite zapreminu motora\n";
            ok = false;
        }

        if (txtEnginePow.getText().trim().isEmpty()) {
            message += "- Unesite Jacinu motora\n";
            ok = false;
        }

        if (ok == false) {
            JOptionPane.showMessageDialog(null, message,
                        "Greska !", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}
