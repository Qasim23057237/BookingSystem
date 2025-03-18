import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;


public class Patient {

    private int patientId;
    private String name;
    private String DOB;
    private String address;
    private String phone;
    private List<Appointment> appointments;


    public Patient(int patientId, String name, String DOB, String address, String phone) {
        this.patientId = patientId;
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.appointments = new ArrayList<Appointment>();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String bookappointments(Appointment appointment) {
        appointments.add(appointment);
        return "appoint added successfully for " + name;
    }
    public String cancelAppointment(Appointment appointment)
    {
        if (appointments.contains(appointment))
        {
            appointments.remove(appointment);
            return "appoint removed successfully for " + name;
        }
        else return "appoint not found for " + name;

    }

    public String getDetails() {
        return "Patient ID: " + patientId + "\n" +
                "Name: " + name + "\n" +
                "DOB: " + DOB + "\n" +
                "Address: " + address + "\n" +
                "Phone: " + phone;

    }

    public void savedatatocsv(Patient patient )
    {
        try (FileWriter writer = new FileWriter("Patients.csv", true)) {
            String line = patient.getPatientId() + "," + patient.getName() + "," +
                    patient.getDOB() + "," + patient.getAddress() + "," +
                    patient.getPhone() + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }


        }

        public static List<Patient> loadpatientsfromCSV()
        {
            List<Patient> patients = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("Patients.csv"))) {
                String line="";
                while ((line = br.readLine()) != null)
                {
                 String[] data = line.split(",");
                 if (data.length >= 5)
                 {
                  int patientId = Integer.parseInt(data[0]);
                  String name = data[1];
                  String DOB = data[4];
                  String address = data[2];
                  String phone = data[3];
                  patients.add(new Patient(patientId, name, DOB, address, phone));
                 }
                }
            } catch (IOException e) {
                    e.printStackTrace();
            }
            return patients;
        }
        public static void removePatient(int patientId)
        {
            List<Patient> patient = loadpatientsfromCSV();
            patient.removeIf(p -> p.patientId == patientId);
      try(FileWriter fileWriter = new FileWriter("Patients.csv"))
      {
          for(Patient p : patient){
              String line =  p.getPatientId() + "," + p.getName() + "," + p.getDOB() + "," + p.getAddress() + "," + p.getPhone() + "\n";
              fileWriter.write(line);

          }

      } catch (IOException e) {
          e.printStackTrace();
      }

        }

    }



