package gui;

import carModels.Service;
import guiForms.ServiceForm;
import main.Access;
import utility.Checks;
import utility.WriteToFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ServiceTable extends JFrame {
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");
    public DefaultTableModel tableModel;
    private JTable serviceTable;

    private Access access;
    private ArrayList<Service> services;
    int option;

    public ServiceTable(Access access, int option) {
        this.access = access;
        this.services = access.getServices();
        this.option = option;
        setTitle("Servisi");
        setSize(800,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu(option);
        initActions();
    }

    private void initMenu(Integer option) {
        if (option == 1) {
            mainToolBar.setFloatable(false);
            mainToolBar.add(btnAdd);
            mainToolBar.add(btnEdit);
            mainToolBar.add(btnDelete);
            add(mainToolBar, BorderLayout.NORTH);
        }

        String[] serviceInfo = new String[] {"ID automobila", "ID Radnika", "Datum", "Opis",
                "ID iskoriscenih delova", "Status"};
        Object[][] content = new Object[services.size()][serviceInfo.length];

        int i = 0;
        for (Service service : services) {
            content[i][0] = service.getCar().getCarID();
            content[i][1] = service.getWorker().getId();
            content[i][2] = Checks.dateToString(service.getReservation());
            content[i][3] = service.getDescription();
            content[i][4] = service.printParts();
            content[i][5] = service.getStatus();
            i++;
        }

        tableModel = new DefaultTableModel(content, serviceInfo);
        serviceTable = new JTable(tableModel);

        serviceTable.setRowSelectionAllowed(true);
        serviceTable.setColumnSelectionAllowed(false);
        serviceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serviceTable.setDefaultEditor(Object.class, null);
        serviceTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(serviceTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceForm serviceForm = new ServiceForm(access, null);
                serviceForm.setVisible(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = serviceTable.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String serviceID = tableModel.getValueAt(row, 0).toString();
                    Service service = Checks.findService(serviceID, services);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete servis?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) { // TODO : servisne knjizice sinhronisi
                        service.setDeleted(true);           // TODO : sa klijentima i automobilima
                        tableModel.removeRow(row);
                        WriteToFile.writeService(services);
                    }
                }
            }
        });
    }
}
