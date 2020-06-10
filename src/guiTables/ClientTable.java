package gui;

import guiForms.ClientForm;
import main.Access;
import userModels.Client;
import utility.WriteToFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientTable extends JFrame {
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");

    private Access access;
    private ArrayList<Client> clients;
    public DefaultTableModel tableModel;
    private JTable clientTable;

    public ClientTable(Access access) {
        this.access = access;
        this.clients = access.findClients();
        setTitle("Musterije");
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

        String[] clientInfo = new String[] {"ID musterije", "Ime", "Prezime", "JMBG",
                "Pol", "Adresa", "Telefon", "Korisnicko ime", "Poeni"};
        Object[][] content = new Object[clients.size()][clientInfo.length];

        int i = 0;
        for (Client client : clients) {
            content[i][0] = client.getId();
            content[i][1] = client.getName();
            content[i][2] = client.getLastName();
            content[i][3] = client.getJmbg();
            content[i][4] = client.getGender();
            content[i][5] = client.getAddress();
            content[i][6] = client.getPhone();
            content[i][7] = client.getUsername();
            content[i][8] = client.getPoints();
            i++;
        }

        tableModel = new DefaultTableModel(content, clientInfo);
        clientTable = new JTable(tableModel);

        clientTable.setRowSelectionAllowed(true);
        clientTable.setColumnSelectionAllowed(false);
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clientTable.setDefaultEditor(Object.class, null);
        clientTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(clientTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientForm clientForm = new ClientForm(access, null);
                clientForm.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = clientTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String clientUsername = tableModel.getValueAt(row, 7).toString();
                    Client client = access.findClient(clientUsername);

                    if (client == null) {
                        JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja klijetna !",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    } else {
                        ClientForm clientForm = new ClientForm(access, client);
                        clientForm.setVisible(true);
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = clientTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String clientUserName = tableModel.getValueAt(row, 7).toString();
                    Client client = access.findClient(clientUserName);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete automobil?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        client.setDeleted(true);
                        tableModel.removeRow(row);
                        WriteToFile.writeUsers(access.getPeople());
                    }
                }
            }
        });
    }
}