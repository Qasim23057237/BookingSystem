import javax.swing.*;

public class PatientForm {
    private JPanel rootPanel;
    private JTextField txtname;
    private JTextField txtdob;
    private JTextField txtaddress;
    private JTextField txtphone;
    private JButton addPatientButton;

    public PatientForm()
    {
    addPatientButton.addActionListener(e ->
    {
        int patientID = Utility.getnextid("Patients.csv");
        if(patientID == 0)
        {
            patientID = 1;
        }
        else
        {
            patientID = Utility.getnextid("Patients.csv") ;
        }

        String name = txtname.getText().trim();
        String address = txtaddress.getText().trim();
        String phone = txtphone.getText().trim();
        String age = txtdob.getText().trim();
        if(name.isEmpty() || address.isEmpty() || phone.isEmpty() || age.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPanel, "Please fill all the fields");
        }
        else {
            //
            Patient newpatient = new Patient(patientID, name, address, phone, age);
            newpatient.savedatatocsv(newpatient);
            JOptionPane.showMessageDialog(rootPanel, "Patient " + name + "Saved");
            txtname.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            txtdob.setText("");
        }
    });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Patient Form");
            PatientForm form = new PatientForm();
            frame.setContentPane(form.rootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }



}
