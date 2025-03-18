import java.util.ArrayList;
import java.util.List;

public class physiotherapist {

private int physioid;
private String doctorname;
private String doctoraddress;
private String doctorphone;
private List<String> expertises;
private List<String> timetable;
public physiotherapist(int physioid, String doctorname , String doctoraddress, String doctorphone )
{
this.physioid = 1; //physioid;
this.doctorname = doctorname;
this.doctoraddress = doctoraddress;
this.doctorphone = doctorphone;
this.expertises = new ArrayList<String>();
this.timetable = new ArrayList<>();
}

    public int getPhysioid() {
            return physioid;
    }
    public  String getDoctorname()
    {
        return doctorname;
    }

    public String getDoctoraddress() {
        return doctoraddress;
    }
    public String getDoctorphone() {
    return doctorphone;
    }
    public List<String> getExpertises() {
    return expertises;
    }
    public List<String> getTimetable() {
    return timetable;
    }
    public void addExpertise(String expertise)
    {
        expertises.add(expertise);
    }

    public void addTreatmentSlot(String Slot)
    {
        timetable.add(Slot);
    }

    public String getDetails()
    {
      return doctorname + " " + doctorphone + " " + expertises;
    }


}
