import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewPatients extends javax.swing.JFrame {
    private JPanel panel1;
    private JScrollPane Scrollpane;
    private JTable patientTable;
    public static void main(String[] args) {
        // Always start Swing apps on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create an instance of your form
            ViewPatients form = new ViewPatients();
            // Make it visible
            form.setVisible(true);
        });
    }


    public ViewPatients()
    {
        super("View Patients");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1 = new JPanel(new BorderLayout());

        String []  columnNames = {"Patient ID", "Name", "DOB", "Address" , "Phone" , "Remove"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames , 0);
        List<Patient> patients = Patient.loadpatientsfromCSV();

        patientTable = new JTable(tableModel);
        for (Patient patient : patients)
        {
            tableModel.addRow(new Object [] {
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getDOB(),
                    patient.getAddress(),
                    patient.getPhone(),
                    "Delete"

            });

        }
        patientTable = new JTable(tableModel);
        Scrollpane = new JScrollPane(patientTable);
        panel1.add(Scrollpane, BorderLayout.CENTER);

        setContentPane(panel1);


        pack();
        setLocationRelativeTo(null);

        patientTable.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

                int row = patientTable.rowAtPoint(e.getPoint());
                int col = patientTable.columnAtPoint(e.getPoint());
                if (col == 5 && row >=0 )
                {
                DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
                int patientId = Integer.parseInt(model.getValueAt(row, 0).toString());
                Patient.removePatient(patientId);
                model.removeRow(row);
//                model.setRowCount(0);
//                Patient.loadpatientsfromCSV();
//                    patientTable = new JTable(tableModel);
//                    for (Patient patient : patients)
//                    {
//                        tableModel.addRow(new Object [] {
//                                patient.getPatientId(),
//                                patient.getName(),
//                                patient.getDOB(),
//                                patient.getAddress(),
//                                patient.getPhone(),
//                                "Delete"
//
//                        });
//
//                    }
                    patientTable = new JTable(tableModel);
                    Scrollpane = new JScrollPane(patientTable);
                    panel1.add(Scrollpane, BorderLayout.CENTER);

                    setContentPane(panel1);


                    pack();
                    setLocationRelativeTo(null);

                }

            }
        });
    }




}
