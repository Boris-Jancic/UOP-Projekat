package guiForms;

import carModels.Part;
import enums.Mark;
import enums.Model;
import main.Access;
import net.miginfocom.swing.MigLayout;
import utility.WriteToFile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PartForm extends JFrame {
    private JLabel lblMark = new JLabel("Marka");
    private JComboBox<Mark> cbMark = new JComboBox<>(Mark.values());
    private JLabel lblModel = new JLabel("Model");
    private JComboBox<Model> cbModel = new JComboBox<>(Model.values());
    private JLabel lblName = new JLabel("Ime");
    private TextField txtName = new TextField(10);
    private JLabel lblPrice = new JLabel("Cena");
    private TextField txtPrice = new TextField(10);
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Otkazi");


    private Access access;
    private Part part;

    public PartForm(Access access, Part part) {
        this.access = access;
        this.part = part;
        setLocationRelativeTo(null);
        setTitle("Unos dela");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
        pack();
    }

    private void initMenu() {
        MigLayout migLayout = new MigLayout("wrap 2", "[]10[][]10[]");
        setLayout(migLayout);

        if (part != null) {
            fillBlanks();
        }

        add(lblMark);add(cbMark);
        add(lblModel);add(cbModel);
        add(lblName);add(txtName);
        add(lblPrice);add(txtPrice);
        add(new JLabel());
        add(btnOk, "split 2");add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation()) {
                    Mark mark = (Mark) cbMark.getSelectedItem();
                    Model model = (Model) cbModel.getSelectedItem();
                    String name = txtName.getText();
                    Double price = Double.parseDouble(txtPrice.getText());

                    if (part == null) {
                        Random r = new Random();
                        int partID = r.nextInt(999999);
                        part = new Part(mark, model, name, price, Integer.toString(partID), false);
                        access.addPart(part);
                    } else {
                        part.setMark(mark);
                        part.setModel(model);
                        part.setName(name);
                        part.setPrice(price);
                    }

                    WriteToFile.writeParts(access.getParts());
                    PartForm.this.dispose();
                    PartForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PartForm.this.dispose();
                PartForm.this.setVisible(false);
            }
        });

    }

    private void fillBlanks() {
        cbMark.setSelectedItem(part.getMark());
        cbModel.setSelectedItem(part.getModel());
        txtName.setText(part.getName());
        txtPrice.setText(Double.toString(part.getPrice()));
    }

    private boolean validation() {
        boolean ok = true;
        String message = "Molimo popravite sledece podatke : \n";

        if (txtName.getText().trim().isEmpty()) {
            message += "- Unesite ime dela\n";
            ok = false;
        }
        if (txtPrice.getText().trim().isEmpty() && txtPrice.getText().trim().matches("[0-9]+")) {
            message += "- Unesite cenu dela\n";
            ok = false;
        }

        if (ok == false) {
            JOptionPane.showMessageDialog(null, message, "Greska !", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}