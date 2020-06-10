package guiTables;

import guiForms.ClientForm;
import guiForms.WorkerForm;
import main.Access;
import userModels.Client;
import userModels.Worker;
import utility.WriteToFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkerTable extends JFrame {
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");

    private Access access;
    private ArrayList<Worker> workers;
    public DefaultTableModel tableModel;
    private JTable workerTable;

    public WorkerTable(Access access) {
        this.access = access;
        this.workers = access.findWorkers();
        setTitle("Radnici");
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
                "Pol", "Adresa", "Telefon", "Korisnicko ime", "Specijalizacija", "Plata"};
        Object[][] content = new Object[workers.size()][workerInfo.length];

        int i = 0;
        for (Worker worker : workers) {
            content[i][0] = worker.getId();
            content[i][1] = worker.getName();
            content[i][2] = worker.getLastName();
            content[i][3] = worker.getJmbg();
            content[i][4] = worker.getGender();
            content[i][5] = worker.getAddress();
            content[i][6] = worker.getPhone();
            content[i][7] = worker.getUsername();
            content[i][8] = worker.getSpecialization();
            content[i][9] = worker.getSalary();
            i++;
        }

        tableModel = new DefaultTableModel(content, workerInfo);
        workerTable = new JTable(tableModel);

        workerTable.setRowSelectionAllowed(true);
        workerTable.setColumnSelectionAllowed(false);
        workerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        workerTable.setDefaultEditor(Object.class, null);
        workerTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(workerTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkerForm workerForm = new WorkerForm(access, null);
                workerForm.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = workerTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String workertUsername = tableModel.getValueAt(row, 7).toString();
                    Worker worker = access.findWorker(workertUsername);

                    if (worker == null) {
                        JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja radnika !",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    } else {
                        WorkerForm workerForm = new WorkerForm(access, worker);
                        workerForm.setVisible(true);
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = workerTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String workerUserName = tableModel.getValueAt(row, 7).toString();
                    Worker worker = access.findWorker(workerUserName);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete radnika?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        worker.setDeleted(true);
                        tableModel.removeRow(row);
                        WriteToFile.writeUsers(access.getPeople());
                    }
                }
            }
        });
    }
}