package guiTables;

import guiForms.AdminForm;
import main.Access;
import userModels.Admin;
import utility.WriteToFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminTable extends JFrame {
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");

    private Access access;
    private ArrayList<Admin> admins;
    public DefaultTableModel tableModel;
    private JTable adminTable;

    public AdminTable(Access access) {
        this.access = access;
        this.admins = access.findAdmins();
        setTitle("Administratori");
        setSize(900,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu () {
        mainToolBar.setFloatable(false);
        mainToolBar.add(btnAdd);
        mainToolBar.add(btnEdit);
        mainToolBar.add(btnDelete);
        add(mainToolBar, BorderLayout.NORTH);

        String[] workerInfo = new String[] {"ID musterije", "Ime", "Prezime", "JMBG",
                "Pol", "Adresa", "Telefon", "Korisnicko ime", "Plata"};
        Object[][] content = new Object[admins.size()][workerInfo.length];

        int i = 0;
        for (Admin admin : admins) {
            content[i][0] = admin.getId();
            content[i][1] = admin.getName();
            content[i][2] = admin.getLastName();
            content[i][3] = admin.getJmbg();
            content[i][4] = admin.getGender();
            content[i][5] = admin.getAddress();
            content[i][6] = admin.getPhone();
            content[i][7] = admin.getUsername();
            content[i][8] = admin.getSalary();
            i++;
        }

        tableModel = new DefaultTableModel(content, workerInfo);
        adminTable = new JTable(tableModel);

        adminTable.setRowSelectionAllowed(true);
        adminTable.setColumnSelectionAllowed(false);
        adminTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        adminTable.setDefaultEditor(Object.class, null);
        adminTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(adminTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminForm adminForm = new AdminForm(access, null);
                adminForm.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String admintUsername = tableModel.getValueAt(row, 7).toString();
                    Admin admin = access.findAdmin(admintUsername);

                    if (admin == null) {
                        JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja radnika !",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    } else {
                        AdminForm adminForm = new AdminForm(access, admin);
                        adminForm.setVisible(true);
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String admintUsername = tableModel.getValueAt(row, 7).toString();
                    Admin admin = access.findAdmin(admintUsername);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete radnika?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        admin.setDeleted(true);
                        tableModel.removeRow(row);
                        WriteToFile.writeUsers(access.getPeople());
                    }
                }
            }
        });
    }
}