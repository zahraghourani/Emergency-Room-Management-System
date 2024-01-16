package erms;

public class Patient {
    private int patientId;
    private String name;
    private int conditionLevel;
    
    public Patient(){
        patientId++;
        name = " ";
        conditionLevel = 0;
    }
    
    public Patient(String name){
        patientId++;
        this.name = name;
    }
    
    public Patient(String name, int conditionLevel) {
        patientId++;
        this.name = name;
        this.conditionLevel = conditionLevel;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConditionLevel() {
        return conditionLevel;
    }

    public void setConditionLevel(int conditionLevel) {
        this.conditionLevel = conditionLevel;
    }
}