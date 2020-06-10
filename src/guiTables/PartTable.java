package gui;

import carModels.Part;
import carModels.Service;
import guiForms.PartForm;
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

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PartTable extends JFrame{
    private JToolBar mainToolBar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Izbrisi");
    public DefaultTableModel tableModel;
    private JTable partTable;

    private Access access;
    private ArrayList<Part> parts;
    int option;

    public PartTable(Access access, int option) {
        this.access = access;
        this.parts = access.getParts();
        setTitle("Delovi");
        setSize(800,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        mainToolBar.setFloatable(false);
        mainToolBar.add(btnAdd);
        mainToolBar.add(btnEdit);
        mainToolBar.add(btnDelete);
        add(mainToolBar, BorderLayout.NORTH);


        String[] partInfo = new String[] {"Marka", "Model", "Ime dela", "Cena",
                "ID dela"};
        Object[][] content = new Object[parts.size()][partInfo.length];

        int i = 0;
        for (Part part : parts) {
            content[i][0] = part.getMark();
            content[i][1] = part.getModel();
            content[i][2] = part.getName();
            content[i][3] = part.getPrice();
            content[i][4] = part.getId();
            i++;
        }

        tableModel = new DefaultTableModel(content, partInfo);
        partTable = new JTable(tableModel);

        partTable.setRowSelectionAllowed(true);
        partTable.setColumnSelectionAllowed(false);
        partTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        partTable.setDefaultEditor(Object.class, null);
        partTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(partTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PartForm partForm = new PartForm(access, null);
                partForm.setVisible(true);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = partTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String partID = tableModel.getValueAt(row,4).toString();
                    Part part = access.findPart(partID);
                    PartForm partForm = new PartForm(access, part);
                    partForm.setVisible(true);
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = partTable.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String partID = tableModel.getValueAt(row, 4).toString();
                    Part part = access.findPart(partID);

                    int option = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete servis?",
                            "Potvrda brisanja", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        part.setDeleted(true);
                        tableModel.removeRow(row);
                        WriteToFile.writeParts(parts);
                    }
                }
            }
        });
    }
}