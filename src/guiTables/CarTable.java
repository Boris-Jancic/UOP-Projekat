package guiTables;

import carModels.Car;
import guiForms.CarForm;
import main.Access;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import utility.Checks;
import utility.WriteToFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarTable extends JFrame {
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");

    private Access access;
    private Person person;
    private ArrayList<Car> cars;
    public DefaultTableModel tableModel;
    private JTable carTable;

    public CarTable(Access access, Person person) {
        this.person = person;
        this.access = access;

        if (person instanceof Client) {
            this.cars = access.getClientCars(person.getId());
        } else {
            this.cars = access.getCars();
        }

        setTitle("Manipulisanje automobila");
        setSize(800, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu () {
        if (person instanceof Admin) {
            mainToolBar.setFloatable(false);
            mainToolBar.add(btnAdd);
            mainToolBar.add(btnEdit);
            mainToolBar.add(btnDelete);
            add(mainToolBar, BorderLayout.NORTH);
        }


        String[] carInfo = new String[] {"ID automobila", "Marka", "Model", "Gorivo",
                                            "Godiste", "Zapremina Motora", "Jacina Motora"};
        Object[][] content = new Object[cars.size()][carInfo.length];

        int i = 0;
        for (Car car : cars) {
            content[i][0] = car.getCarID();
            content[i][1] = car.getMark();
            content[i][2] = car.getModel();
            content[i][3] = car.getFuel();
            content[i][4] = car.getAge();
            content[i][5] = car.getEngineVolume();
            content[i][6] = car.getEnginePower();
            i++;
        }


        tableModel = new DefaultTableModel(content, carInfo);
        carTable = new JTable(tableModel);

        carTable.setRowSelectionAllowed(true);
        carTable.setColumnSelectionAllowed(false);
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carTable.setDefaultEditor(Object.class, null);
        carTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(carTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarForm carForm = new CarForm(access, null);
                carForm.setVisible(true);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = carTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String carID = tableModel.getValueAt(row, 0).toString();
                    Car car = Checks.findCar(carID, cars);

                    if (car == null) {
                        JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila !",
                                "Greska", JOptionPane.WARNING_MESSAGE);
                    } else {
                        CarForm carForm = new CarForm(access, car);
                        carForm.setVisible(true );
                    }
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = carTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String carID = tableModel.getValueAt(row, 0).toString();
                    Car car = Checks.findCar(carID, cars);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete automobil?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        car.setDeleted(true);
                        tableModel.removeRow(row);
                        WriteToFile.writeCars(cars);
                    }
                }
            }
        });
    }
}
