package guiForms;

import enums.Gender;
import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Client;
import utility.WriteToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ClientForm extends JFrame {
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

    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Otkazi");

    private Access access;
    private Client client;

    public ClientForm(Access access, Client client) {
        this.access = access;
        this.client = client;
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

        if (client != null) {
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

                    if (client == null) {
                        Random r = new Random();
                        int randomID = r.nextInt(999999);
                        client = new Client(name, lastName, jmbg, gender, address,
                                phone, username, password, Integer.toString(randomID), 0, false);
                        access.addClient(client);
                    } else {
                        client.setName(name);
                        client.setLastName(lastName);
                        client.setJmbg(jmbg);
                        client.setGender(gender);
                        client.setAddress(address);
                        client.setPhone(phone);
                        client.setUsername(username);
                        client.setPassword(password);
                    }
                    WriteToFile.writeUsers(access.getPeople());
                    ClientForm.this.dispose();
                    ClientForm.this.setVisible(false);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientForm.this.dispose();
                ClientForm.this.setVisible(false);
            }
        });
    }

    private void fillBlanks() {
        txtName.setText(client.getName());
        txtLastName.setText(client.getLastName());
        txtJmbg.setText(client.getJmbg());
        cbGender.setSelectedItem(client.getGender());
        txtAddress.setText(client.getAddress());
        txtPhone.setText(client.getPhone());
        txtUsername.setText(client.getUsername());
        txtPassword.setText(client.getPassword());
    }

    private boolean validation() {
        boolean ok = true;
        String message = "Molimo vas da popravite sledece podatke : \n";

        if (txtName.getText().trim().isEmpty()) {
            message += "- Unesite ime musterije\n";
            ok = false;
        }
        if (txtLastName.getText().trim().isEmpty()) {
            message += "- Unesite prezime musterije\n";
            ok = false;
        }

        String jmbg = txtJmbg.getText();
        if (jmbg.trim().isEmpty()) {
            message += "- Unesite jmbg musterije\n";
            ok = false;
        } else if (jmbg.trim().length() != 13 || !jmbg.trim().matches("[0-9]+")) {
            message += "- Jmbg musterije nije ispravnog formata\n";
            ok = false;
        }

        if (txtAddress.getText().trim().isEmpty()) {
            message += "- Unesite adresu musterije\n";
            ok = false;
        }

        if (txtPhone.getText().trim().isEmpty()) {
            message += "- Unesite telefon musterije\n";
            ok = false;
        } else if (!txtPhone.getText().trim().matches("[0-9]+")) {
            message += "- Telefon musterije nije ispravnog formata\n";
            ok = false;
        }

        if (txtUsername.getText().trim().isEmpty()) {
            message += "- Unesite korisnicko ime musterije\n";
            ok = false;
        }

        if (txtPassword.getText().trim().isEmpty()) {
            message += "- Unesite lozinku musterije\n";
            ok = false;
        }

        if (!ok) {
            JOptionPane.showMessageDialog(null, message, "Greska !", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}
