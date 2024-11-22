package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Controller;

public class SplashAdmin implements Viewable {
    private JFrame frame;
    private JButton addPatient;
    private JButton editPatient;
    private JButton viewPatientRecords;
    private JButton viewPrescriptions;
    private JButton addPrescription;
    private JButton addMP;
    private JButton deletePatient;
    private JButton deleteMP;
    private JPanel pane;

    private void initialize() {
        frame = new JFrame("Medicin");
        pane = new JPanel(new FlowLayout());
        frame.add(pane);
        frame.setSize(640, 800);
        pane.add(addPatient = new JButton("Add a Patient"));
        pane.add(editPatient = new JButton("Edit a Patient"));
        pane.add(viewPatientRecords = new JButton("View Patient Records"));
        pane.add(viewPrescriptions = new JButton("View Prescriptions"));
        pane.add(addPrescription = new JButton("Add Prescription"));
        pane.add(addMP = new JButton("Add a MP"));
        pane.add(deletePatient = new JButton("Delete a Patient"));
        pane.add(deleteMP = new JButton("Delete a MP"));

        ActionListener addPListener;
        addPListener = new ActionListener() {
            PatientPanel pane = new PatientPanel();

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, pane,
                        "Please input patient data", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Controller.getController().addPatient(pane.cprField.getText(),
                            pane.nameField.getText(), pane.adressField.getText());
                }
            }
        };

        ActionListener editPListener;
        editPListener = new ActionListener() {
            PatientPanel patientPane = new PatientPanel();
            ArrayList<String> list = new ArrayList<String>();

            @Override
            public void actionPerformed(ActionEvent e) {
                String cpr = (String) JOptionPane.showInputDialog(null,
                        "Please enter the CPR number\n"
                                + "of the patient you wish to edit",
                        "Enter CPR", JOptionPane.PLAIN_MESSAGE, null, null, "cpr");
                list = Controller.getController().getPatient(cpr);

                patientPane.cprField.setText(list.get(0));
                patientPane.nameField.setText(list.get(1));
                patientPane.adressField.setText(list.get(2));

                int result = JOptionPane.showConfirmDialog(null, patientPane,
                        "Please input patient data", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Controller.getController().editPatient(
                            patientPane.cprField.getText(),
                            patientPane.nameField.getText(),
                            patientPane.adressField.getText());
                }
            }
        };

        ActionListener viewRListener;
        viewRListener = new ActionListener() {
            RecordsPanel recordsPanel;

            @Override
            public void actionPerformed(ActionEvent e) {
                String cpr = (String) JOptionPane.showInputDialog(null,
                        "Please enter the CPR number\n"
                                + "of the patient you wish to edit",
                        "Enter CPR", JOptionPane.PLAIN_MESSAGE, null, null, "cpr");

                recordsPanel = new RecordsPanel(
                        Controller.getController().getRecords(cpr));

                JOptionPane.showConfirmDialog(null, recordsPanel.pane, "Records",
                        JOptionPane.OK_CANCEL_OPTION);

            }

        };

        ActionListener viewPRListener;
        viewPRListener = new ActionListener() {
            PrescriptionPanel prescriptionPanel;

            @Override
            public void actionPerformed(ActionEvent e) {
                String cpr = (String) JOptionPane.showInputDialog(null,
                        "Please enter the CPR number\n"
                                + "of the patient you wish to edit",
                        "Enter CPR", JOptionPane.PLAIN_MESSAGE, null, null, "cpr");
                prescriptionPanel = new PrescriptionPanel(
                        Controller.getController().getPrescriptions(cpr));

                JOptionPane.showConfirmDialog(null, prescriptionPanel.pane,
                        "Prescriptions", JOptionPane.OK_CANCEL_OPTION);
            }
        };

        ActionListener addPRListener;
        addPRListener = new ActionListener() {
            AddPrescriptionsPanel pane = new AddPrescriptionsPanel();

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, pane,
                        "Please input prescription data",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Controller.getController().addPrescription(
                            pane.cprField.getText(), pane.medicinField.getText(),
                            Integer.parseInt(pane.renewalField.getText()),
                            pane.continousField.isSelected(),
                            pane.diseaseField.getText());
                }
            }
        };

        ActionListener addMPListener = new ActionListener() {
            AddMPPanel pane = new AddMPPanel();

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, pane,
                        "Please input prescription data",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Controller.getController().addMp(pane.name.getText(), pane.specialization.getText(), pane.id.getText());
                }
            }
        };

        ActionListener deletePListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cpr = (String) JOptionPane.showInputDialog(null,
                        "Please enter the CPR number\n"
                                + "of the patient you wish to Delete",
                        "Enter CPR", JOptionPane.PLAIN_MESSAGE, null, null, "cpr");
                Controller.getController().deletePatient(cpr);
            }
        };

        ActionListener deleteMPListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cpr = (String) JOptionPane.showInputDialog(null,
                        "Please enter the CPR number\n"
                                + "of the MP you wish to Delete",
                        "Enter CPR", JOptionPane.PLAIN_MESSAGE, null, null, "cpr");
                Controller.getController().deleteMP(cpr);
            }
        };

        addPatient.addActionListener(addPListener);
        editPatient.addActionListener(editPListener);
        viewPatientRecords.addActionListener(viewPRListener);
        viewPrescriptions.addActionListener(viewRListener);
        addPrescription.addActionListener(addPRListener);
        deleteMP.addActionListener(deleteMPListener);
        deletePatient.addActionListener(deletePListener);
        addMP.addActionListener(addMPListener);
    }

    @Override
    public void open() {
        frame.setVisible(true);
    }

    @Override
    public void close() {
        frame.setVisible(false);
    }

    public SplashAdmin() {
        initialize();
        open();
    }

    private class PatientPanel extends JPanel {
        private JLabel cprLabel;
        private JTextField cprField;
        private JLabel nameLabel;
        private JTextField nameField;
        private JLabel adressLabel;
        private JTextField adressField;

        private PatientPanel() {
            this.add(cprLabel = new JLabel("CPR:"));
            this.add(cprField = new JTextField(20));
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(nameLabel = new JLabel("Name:"));
            this.add(nameField = new JTextField(20));
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(adressLabel = new JLabel("Address:"));
            this.add(adressField = new JTextField(20));

        }
    }

    private class RecordsPanel extends JPanel {
        private JScrollPane pane;
        private JTable table;
        private final String[] col = {"Doctor", "Treated for", "Date"};

        private RecordsPanel(ArrayList<ArrayList<String>> arrayList) {
            String[][] data = new String[arrayList.size()][arrayList.get(0).size()];
            for (int i = 0; i < arrayList.size(); i++) {
                for (int j = 0; j < arrayList.get(0).size(); j++)
                    data[i][j] = (String) arrayList.get(i).get(j);
            }
            table = new JTable(data, col);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            pane = new JScrollPane(table);

        }

    }

    private class AddPrescriptionsPanel extends JPanel {

        private JTextField cprField;
        private JTextField medicinField;
        private JTextField renewalField;
        private JCheckBox continousField;
        private JTextField diseaseField;

        private AddPrescriptionsPanel() {
            this.add(new JLabel("CPR:"));
            this.add(cprField = new JTextField(20));
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(new JLabel("Medicin Name:"));
            this.add(medicinField = new JTextField(20));
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(new JLabel("Renewal Amount:"));
            this.add(renewalField = new JTextField(5));
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(new JLabel("Continuous?"));
            this.add(continousField = new JCheckBox());
            this.add(Box.createHorizontalStrut(WIDTH));
            this.add(new JLabel("Disease Name"));
            this.add(diseaseField = new JTextField(20));
            this.add(Box.createHorizontalStrut(WIDTH));
        }

    }

    private class PrescriptionPanel extends JPanel {
        private JScrollPane pane;
        private JTable table;
        private final String[] col = {"Medicine name", "Renewals", "Continuous",
                "Date Prescribed", "Prescriber", "Disease"};

        private PrescriptionPanel(ArrayList<ArrayList<String>> arrayList) {
            String[][] data = new String[arrayList.size()][arrayList.get(0).size()];
            for (int i = 0; i < arrayList.size(); i++) {
                for (int j = 0; j < arrayList.get(0).size(); j++)
                    data[i][j] = (String) arrayList.get(i).get(j);
            }
            table = new JTable(data, col);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            pane = new JScrollPane(table);

        }

    }

    private class AddMPPanel extends JPanel {
        private JTextField name;
        private JTextField specialization;
        private JTextField id;
        private final int LENGTH = 10;

        AddMPPanel() {
            this.add(new JLabel("Name:"));
            this.add(name = new JTextField(LENGTH));
            this.add(Box.createHorizontalStrut(LENGTH));
            this.add(new JLabel("Specialization:"));
            this.add(specialization = new JTextField(LENGTH));
            this.add(Box.createHorizontalStrut(LENGTH));
            this.add(new JLabel("ID:"));
            this.add(id = new JTextField(LENGTH));
        }
    }

}
