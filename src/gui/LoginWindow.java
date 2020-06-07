package gui;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class login extends JFrame {
    private JLabel lblWelcome = new JLabel("Dobrodosli. Molimo da se prijavite.");
    private JLabel lblUsername = new JLabel("Korisnicko ime");
    private JTextField txtUsername = new JTextField(20);
    private JLabel lblPassword = new JLabel("Lozinka");
    private JPasswordField pfPassword = new JPasswordField(20);

    private JButton btnOk = new JButton("Uloguj se");
    private JButton btnCancel = new JButton("Otkazi");

    public login() {
        setTitle("Prijava korisnika");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
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

    }
}
