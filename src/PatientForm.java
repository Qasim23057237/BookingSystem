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
    addPatientButton.addActionListener(e -> {
        String name = txtname.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        String age = txtdob.getText();

        JOptionPane.showMessageDialog(rootPanel, name + " " + address + " " + phone + " " + age);
    });
    }

    public static void main(String[] args) {
        // Always run GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Patient Form");
            // Create an instance of your form
            PatientForm form = new PatientForm();
            // Set the content of the JFrame to your form's rootPanel
            frame.setContentPane(form.rootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }



}
