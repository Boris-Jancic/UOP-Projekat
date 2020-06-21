package guiForms;

import enums.*;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Admin;
import utility.WriteToFile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdminForm extends JFrame {
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
    private JLabel lblSalary = new JLabel("Plata");
    private TextField txtSalary = new TextField(15);

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Otkazi");

    private Access access;
    private Admin admin;

    public AdminForm(Access access, Admin admin) {
        this.access = access;
        this.admin = admin;
        setLocationRelativeTo(null);
        setTitle("Unos administratora");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (admin != null) {
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
                    double sallary = Double.parseDouble(txtSalary.getText());

                    if (admin == null) {
                        Random r = new Random();
                        int randomID = r.nextInt(999999);
                        admin = new Admin(name, lastName, jmbg, gender, address, phone, username,
                                password, sallary,Integer.toString(randomID), false);
                        access.addAdmin(admin);
                    } else {
                        admin.setName(name);
                        admin.setLastName(lastName);
                        admin.setJmbg(jmbg);
                        admin.setGender(gender);
                        admin.setAddress(address);
                        admin.setPhone(phone);
                        admin.setUsername(username);
                        admin.setPassword(password);
                        admin.setSalary(sallary);
                    }
                    WriteToFile.writeUsers(access.getPeople());
                    AdminForm.this.dispose();
                    AdminForm.this.setVisible(false);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminForm.this.dispose();
                AdminForm.this.setVisible(false);
            }
        });
    }

    private void fillBlanks() {
        txtName.setText(admin.getName());
        txtLastName.setText(admin.getLastName());
        txtJmbg.setText(admin.getJmbg());
        cbGender.setSelectedItem(admin.getGender());
        txtAddress.setText(admin.getAddress());
        txtPhone.setText(admin.getPhone());
        txtUsername.setText(admin.getUsername());
        txtPassword.setText(admin.getPassword());
        txtSalary.setText(Double.toString(admin.getSalary()));
    }

    private boolean validation() {
        boolean ok = true;
        String message = "Molimo vas da popravite sledece podatke : \n";

        if (txtName.getText().trim().isEmpty()) {
            message += "- Unesite ime administratora\n";
            ok = false;
        }
        if (txtLastName.getText().trim().isEmpty()) {
            message += "- Unesite prezime administratora\n";
            ok = false;
        }

        String jmbg = txtJmbg.getText();
        if (jmbg.trim().isEmpty()) {
            message += "- Unesite jmbg administratora\n";
            ok = false;
        } else if (jmbg.trim().length() != 13 || !jmbg.trim().matches("[0-9]+")) {
            message += "- Jmbg radnika nije ispravnog formata\n";
            ok = false;
        }

        if (txtAddress.getText().trim().isEmpty()) {
            message += "- Unesite adresu administratora\n";
            ok = false;
        }

        if (txtPhone.getText().trim().isEmpty()) {
            message += "- Unesite telefon administratora\n";
            ok = false;
        } else if (!txtPhone.getText().trim().matches("[0-9]+")) {
            message += "- Telefon musterije nije ispravnog administratora\n";
            ok = false;
        }

        if (txtUsername.getText().trim().isEmpty()) {
            message += "- Unesite korisnicko ime administratora\n";
            ok = false;
        }

        if (txtPassword.getText().trim().isEmpty()) {
            message += "- Unesite lozinku administratora\n";
            ok = false;
        }

        if (txtSalary.getText().trim().isEmpty()) {
            message += "- Unesite platu administratora\n";
            ok = false;
        }

        if (!ok) {
            JOptionPane.showMessageDialog(null, message, "Greska !", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}