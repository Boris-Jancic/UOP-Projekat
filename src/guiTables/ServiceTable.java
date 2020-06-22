package guiTables;

import carModels.Service;
import enums.Status;
import guiForms.ServiceForm;
import main.Access;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
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
    private JButton btnFinish = new JButton("Zavrsi servis");
    public DefaultTableModel tableModel;
    private JTable serviceTable;

    private Access access;
    private Person person;
    private ArrayList<Service> services;

    public ServiceTable(Access access, Person person) {
        this.access = access;
        this.person = person;

        if (person instanceof Client) {
            this.services = access.getClientServices((Client) person);
        } else if (person instanceof Worker) {
            this.services = access.getWorkerServices((Worker) person);
        } else if (person instanceof Admin) {
            this.services = access.getServices();
        }

        setTitle("Servisi");
        setSize(800,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        add(mainToolBar, BorderLayout.NORTH);
        mainToolBar.setFloatable(false);
        mainToolBar.add(btnAdd);
        if (person instanceof Admin) {
            mainToolBar.add(btnEdit);
            mainToolBar.add(btnDelete);
        }
        if (person instanceof Worker) {
            mainToolBar.add(btnFinish);
        }

        String[] serviceInfo = new String[] {"ID automobila", "ID Radnika", "Datum", "Opis",
                "ID iskoriscenih delova", "Status", "ID servisa"};
        Object[][] content = new Object[services.size()][serviceInfo.length];

        int i = 0;
        for (Service service : services) {
            content[i][0] = service.getCar().getCarID();
            content[i][3] = service.getDescription();
            content[i][5] = service.getStatus();
            content[i][6] = service.getId();

            if (service.getWorker() != null) {
                content[i][1] = service.getWorker().getId();
                content[i][2] = Checks.dateToString(service.getReservation());
                content[i][4] = service.printParts();
            }
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceForm serviceForm = new ServiceForm(access, person, null);
                serviceForm.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = serviceTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String serviceID = tableModel.getValueAt(row, 6).toString();
                    Service service = access.findService(serviceID);

                    if (service != null) {
                        ServiceForm serviceForm = new ServiceForm(access, person, service);
                        serviceForm.setVisible(true);
                    }
                }
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
                    String serviceID = tableModel.getValueAt(row, 6).toString();
                    Service service = access.findService(serviceID);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete servis?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) { // TODO : servisne knjizice sinhronisi
                        service.setDeleted(true);           // TODO : sa klijentima i automobilima
                        tableModel.removeRow(row);
                        access.updateCarBooks();
                        WriteToFile.writeService(services);
                        WriteToFile.writeCarBook(access.getCarBooks());
                    }
                }
            }
        });
        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = serviceTable.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String serviceID = tableModel.getValueAt(row, 6).toString();
                    Service service = access.findService(serviceID);
                    Client client = access.findClient(service.getCar().getClient().getUsername());

                    if (service.getStatus() == Status.ZAVRSEN) {
                        JOptionPane.showMessageDialog(null,
                                ("Ovaj servis je vec zavrsen"),
                                "Greska", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    if (client != null) {
                        int points = service.getCar().getClient().getPoints();
                        double price = service.getPrice();
                        double discountedPrice = price * (1 - (points * 0.02));
                        String message = "Originalna cena : " + price + "\n" + "Cena sa popustom : " + discountedPrice;

                        if (client.getPoints() > 0) {
                            int pointOption = JOptionPane.showConfirmDialog(null,
                                    "Da li zelite da uracunate bodove od musterije?\n" +
                                            "- Bodovi musterije : " + points + "\n" + message,
                                    "Bodovi", JOptionPane.YES_NO_OPTION);
                            if (pointOption == JOptionPane.YES_OPTION) {
                                price = Math.round(price);
                                client.setPoints(0);
                            }
                        }

                        int endOption = JOptionPane.showConfirmDialog(null,
                                "Da li ste sigurni da zelite da zavrsite servis?",
                                "Zavrsi servis", JOptionPane.YES_NO_OPTION);

                        if (endOption == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null,
                                    ("Cena servisa je : " + price),
                                    "Konacna cena", JOptionPane.INFORMATION_MESSAGE);
                            service.setStatus(Status.ZAVRSEN);
                            WriteToFile.writeUsers(access.getPeople());
                            WriteToFile.writeService(services);
                        }
                    }
                }
            }
        });
    }
}