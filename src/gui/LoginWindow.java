package gui;

import net.miginfocom.swing.MigLayout;
import userModels.Client;
import userModels.Person;
import utility.Checks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class LoginWindow extends JFrame {
    private JLabel lblWelcome = new JLabel("Dobrodosli. Molimo da se prijavite.");
    private JLabel lblUsername = new JLabel("Korisnicko ime");
    private JTextField txtUsername = new JTextField(20);
    private JLabel lblPassword = new JLabel("Lozinka");
    private JPasswordField pfPassword = new JPasswordField(20);

    private JButton btnOk = new JButton("Uloguj se");
    private JButton btnCancel = new JButton("Otkazi");

    private Set<Person> people;

    public LoginWindow(Set<Person> people) {
        this.people = people;
        setTitle("Prijava korisnika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
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

    private void initActions() {
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
                    Person person = Checks.Login(people, username, password);

                    if (person == null) {
                        JOptionPane.showMessageDialog(null, "Nevazeca sifra ili korisniko ime",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    }

                    if (person instanceof Client) {
                        LoginWindow.this.dispose();
                        LoginWindow.this.setVisible(false);
                        System.out.println(person);
                        ClientWindow clientWindow = new ClientWindow((Client) person);
                        clientWindow.setVisible(true);
                    }
                }
            }
        });}
}
