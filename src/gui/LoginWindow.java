package gui;

import main.Access;
import net.miginfocom.swing.MigLayout;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginWindow extends JFrame {
    private JLabel lblWelcome = new JLabel("Dobrodosli. Molimo da se prijavite.");
    private JLabel lblUsername = new JLabel("Korisnicko ime");
    private JTextField txtUsername = new JTextField(15);
    private JLabel lblPassword = new JLabel("Lozinka");
    private JPasswordField pfPassword = new JPasswordField(15);
    private JButton btnOk = new JButton("Uloguj se");
    private JButton btnCancel = new JButton("Otkazi");
    private Access access;

    public LoginWindow(Access access) {
        this.access = access;
        setTitle("Prijava korisnika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions(access);
        pack();

        getRootPane().setDefaultButton(btnOk);
    }

    private void initGUI() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        add(lblWelcome, "span 2");
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(pfPassword);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions(Access access) {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow.this.dispose();
                LoginWindow.this.setVisible(false);
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(pfPassword.getPassword()).trim();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke",
                                                    "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    Person person = Checks.Login(access.getPeople(), username, password);

                    if (person == null) {
                        JOptionPane.showMessageDialog(null, "Nevazeca sifra ili korisniko ime",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    }

                    if (person instanceof Client) {
                        LoginWindow.this.dispose();
                        LoginWindow.this.setVisible(false);
                        ClientWindow clientWindow = new ClientWindow(access, (Client) person);
                        clientWindow.setVisible(true);

                    } else if (person instanceof Worker) {
                        LoginWindow.this.dispose();
                        LoginWindow.this.setVisible(false);
                        WorkerWindow serviceWindow = new WorkerWindow((Worker) person, access, 1);
                        serviceWindow.setVisible(true);

                    } else if (person instanceof Admin) {
                        LoginWindow.this.dispose();
                        LoginWindow.this.setVisible(false);
                        AdminWindow adminWindow = null;
                        try {
                            adminWindow = new AdminWindow((Admin) person, access);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        adminWindow.setVisible(true);
                    }
                }
            }
        });}
}
