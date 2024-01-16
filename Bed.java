package erms;

public class Bed {
    private int bedNumber;
    private boolean isOccupied;
    private Patient patientAssigned;

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.isOccupied = false;
    }
    
    public Bed(int bedNumber, boolean isOccupied, Patient patientAssigned){
        this.bedNumber = bedNumber;
        this.isOccupied = isOccupied;
        this.patientAssigned = patientAssigned;
    }

    public int getBedNumber() {
        return bedNumber;
    }
    
    public void setBedNumber(int bedNumber){
        this.bedNumber = bedNumber;
    }

    public boolean isOccupied() {
        return isOccupied == true;
    }

    public void occupy(Patient patientAssigned) {
        isOccupied = true;
        this.patientAssigned = patientAssigned;
    }

    public Patient release() {
        this.isOccupied = false;
        Patient p = patientAssigned;
        patientAssigned = null;
        return p;
    }

    public Patient getPatientAssigned() {
        return patientAssigned;
    }

    public void setPatientAssigned(Patient patientAssigned) {
        this.patientAssigned = patientAssigned;
    }
    
}