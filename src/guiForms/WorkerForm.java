package guiForms;

import enums.Gender;
import enums.Specialization;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Client;
import userModels.Worker;
import utility.WriteToFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class WorkerForm extends JFrame {
    private JLabel lblName = new JLabel("Ime");
    private TextField txtName = new TextField(15);
    private JLabel lblLastName = new JLabel("Prezime");
    private TextField txtLastName = new TextField(15);
    private JLabel lblJmbg = new JLabel("Jmbg");
    private TextField txtJmbg = new TextField(15);
    private JLabel lblGender = new JLabel("Pol");
    private JComboBox<Gender> cbGender = new JComboBox<>(Gender.values());
    private JLabel lblAddress = new JLabel("Adresa");
    private TextField txtAddress = new TextField(15);
    private JLabel lblPhone = new JLabel("Telefon");
    private TextField txtPhone = new TextField(15);
    private JLabel lblUsername = new JLabel("Korisnicko ime");
    private TextField txtUsername = new TextField(15);
    private JLabel lblPassword = new JLabel("Lozinka");
    private TextField txtPassword = new TextField(15);
    private JLabel lblSpecialization = new JLabel("Specijalizacija");
    private JComboBox<Specialization> cbSpecialization = new JComboBox<>(Specialization.values());
    private JLabel lblSalary = new JLabel("Plata");
    private TextField txtSalary = new TextField(15);

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Otkazi");

    private Access access;
    private Worker worker;

    public WorkerForm(Access access, Worker worker) {
        this.access = access;
        this.worker = worker;
        setLocationRelativeTo(null);
        setTitle("Unos musterije");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (worker != null) {
            fillBlanks();
        }

        add(lblName);add(txtName);
        add(lblLastName);add(txtLastName);
        add(lblJmbg);add(txtJmbg);
        add(lblGender);add(cbGender);
        add(lblAddress);add(txtAddress);
        add(lblPhone);add(txtPhone);
        add(lblUsername);add(txtUsername);
        add(lblPassword);add(txtPassword);
        add(lblSpecialization);add(cbSpecialization);
        add(lblSalary);add(txtSalary);
        add(new JLabel());
        add(btnOk, "split 2");add(btnCancel);

    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation()) {
                    String name = txtName.getText();
                    String lastName = txtLastName.getText();
                    String jmbg = txtJmbg.getText();
                    Gender gender = (Gender) cbGender.getSelectedItem();
                    String address = txtAddress.getText();
                    String phone = txtPhone.getText();
                    String username = txtUsername.getText();
                    String password = txtPassword.getText();
                    Specialization specialization = (Specialization) cbSpecialization.getSelectedItem();
                    Double sallary = Double.parseDouble(txtSalary.getText());

                    if (worker == null) {
                        Random r = new Random();
                        int randomID = r.nextInt(999999);
                        worker = new Worker(name, lastName, jmbg, gender, address,
                                phone, username, password, Integer.toString(randomID),
                                sallary, specialization, false);
                        access.addWorker(worker);
                    } else {
                        worker.setName(name);
                        worker.setLastName(lastName);
                        worker.setJmbg(jmbg);
                        worker.setGender(gender);
                        worker.setAddress(address);
                        worker.setPhone(phone);
                        worker.setUsername(username);
                        worker.setPassword(password);
                        worker.setSpecialization(specialization);
                        worker.setSalary(sallary);
                    }
                    WriteToFile.writeUsers(access.getPeople());
                    WorkerForm.this.dispose();
                    WorkerForm.this.setVisible(false);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkerForm.this.dispose();
                WorkerForm.this.setVisible(false);
            }
        });
    }

    private void fillBlanks() {
        txtName.setText(worker.getName());
        txtLastName.setText(worker.getLastName());
        txtJmbg.setText(worker.getJmbg());
        cbGender.setSelectedItem(worker.getGender());
        txtAddress.setText(worker.getAddress());
        txtPhone.setText(worker.getPhone());
        txtUsername.setText(worker.getUsername());
        txtPassword.setText(worker.getPassword());
        cbSpecialization.setSelectedItem(worker.getSpecialization());
        txtSalary.setText(Double.toString(worker.getSalary()));
    }

    private boolean validation() {
        boolean ok = true;
        String message = "Molimo vas da popravite sledece podatke : \n";

        if (txtName.getText().trim().isEmpty()) {
            message += "- Unesite ime radnika\n";
            ok = false;
        }
        if (txtLastName.getText().trim().isEmpty()) {
            message += "- Unesite prezime radnika\n";
            ok = false;
        }

        String jmbg = txtJmbg.getText();
        if (jmbg.trim().isEmpty()) {
            message += "- Unesite jmbg radnika\n";
            ok = false;
        } else if (jmbg.trim().length() != 13 || !jmbg.trim().matches("[0-9]+")) {
            message += "- Jmbg radnika nije ispravnog formata\n";
            ok = false;
        }

        if (txtAddress.getText().trim().isEmpty()) {
            message += "- Unesite adresu radnika\n";
            ok = false;
        }

        if (txtPhone.getText().trim().isEmpty()) {
            message += "- Unesite telefon radnika\n";
            ok = false;
        } else if (!txtPhone.getText().trim().matches("[0-9]+")) {
            message += "- Telefon musterije nije ispravnog radnika\n";
            ok = false;
        }

        if (txtUsername.getText().trim().isEmpty()) {
            message += "- Unesite korisnicko ime radnika\n";
            ok = false;
        }

        if (txtPassword.getText().trim().isEmpty()) {
            message += "- Unesite lozinku radnika\n";
            ok = false;
        }

        if (txtSalary.getText().trim().isEmpty()) {
            message += "- Unesite platu radnika\n";
            ok = false;
        }

        if (ok == false) {
            JOptionPane.showMessageDialog(null, message, "Greska !", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}
