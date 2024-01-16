package erms;

import java.util.ArrayList;
import java.util.List;

public class EmergencyRoom extends PriorityQueue{
    public PriorityQueue emergencyQueue;
    public Bed[] beds;
    public static final int CRITICAL_LEVEL = 5;

    public EmergencyRoom(int numBeds) {
        emergencyQueue = new PriorityQueue();
        beds = new Bed[numBeds];
        for(int i=0;i<numBeds;i++) {
            beds[i] = new Bed(i+1);
        }
    }
    
    public boolean isEmpty(){
        return super.isEmpty();
    }

    public void addPatient(Patient patient, int priority) {
        emergencyQueue.enqueue(patient, priority);
    }

    public void assignBed(Patient patient) {
        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                bed.occupy(patient);
                System.out.println("Treating patient "+patient.getName());
                break;
            }
            else{
                emergencyQueue.enqueue(patient, patient.getConditionLevel()+1);
            }
        }
    }

    public void treatNextPatient() {
        if (!emergencyQueue.isEmpty()) {
            Node nextPatient = emergencyQueue.dequeue();
            Patient d = nextPatient.data;
            if (nextPatient != null) {
                boolean bedFound = false;
                for (Bed bed : beds){
                    if(!bed.isOccupied()){
                        bed.occupy(d);
                        bedFound = true;
                        System.out.println("Treating patient "+d.getName());
                        break;
                    }
                }
                if(!bedFound){
                    // No available beds, return the patient to the queue with an updated condition level
                    emergencyQueue.enqueue(d, (d.getConditionLevel()+1));
                    System.out.println("Can't treat patient. No beds available at this time.");
                }
            }
        }
        else{
            System.out.println("No patients in the emergency queue.");
        }
    }
    
    public void releaseBed(int bedNumber){
        if (bedNumber >= 1 && bedNumber <= beds.length) {
            for(Bed bed : beds){
                if(!bed.isOccupied() && bed.getBedNumber()==(bedNumber)){
                    System.out.println("Bed is already released");
                }
                else if(bed.isOccupied() && bed.getBedNumber()==(bedNumber)){
                    beds[bedNumber - 1].release();
                    System.out.println("Bed " + bedNumber + " has been released.");
                }
                else{
                    
                }
            }
            
        } else {
            System.out.println("Invalid bed number.");
        }
    }
    
    public void showAvailableBeds() {
        System.out.println("Available Beds:");
        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                System.out.println("Bed " + bed.getBedNumber() + " is available");
            }
        }
    }
    
    public void showWaitingList() {
    if (emergencyQueue.isEmpty()) {
        System.out.println("Waiting List is empty.");
    } else {
        System.out.println("Waiting List:");
        PriorityQueue tempQueue = new PriorityQueue();
        
        // Copy patients from the emergency queue to a list
        while (!emergencyQueue.isEmpty()) {
            Node temp = emergencyQueue.dequeue();
            Patient d = temp.data;
            System.out.println(d.getName() + " - Level " + d.getConditionLevel());
            tempQueue.enqueue(d, d.getConditionLevel());
        }

        // Re-queue the patients back to the emergency queue
        while (!tempQueue.isEmpty()) {
            Node temp = tempQueue.dequeue();
            Patient t = temp.data;
            emergencyQueue.enqueue(t, t.getConditionLevel());
        }
    }
    }

    public void notifyStaffCritical() {
        boolean criticalFound = false;

        // Iterate through the emergency queue to check for critical conditions
        for (Patient patient : this.getPatients()) {
            if (patient.getConditionLevel() == CRITICAL_LEVEL) {
                criticalFound = true;
                break;
            }
        }
    
        // Notify staff if critical condition is found
        if (criticalFound) {
            System.out.println("Critical condition detected! Notifying staff...");
            // Add your notification mechanism here
        }
        else{
            System.out.println("No critical conditions detected.");
        }
    }

    public List<Patient> getPatients(){
        List<Patient> patientList = new ArrayList<>();

        // Copy patients from the priority queue to the list
        PriorityQueue tempQueue = new PriorityQueue();
        while (!emergencyQueue.isEmpty()) {
            Node temp = emergencyQueue.dequeue();
            Patient d = temp.data;
            tempQueue.enqueue(d, d.getConditionLevel());
            patientList.add(d);
        }

        // Restore patients back to the priority queue
        while (!tempQueue.isEmpty()) {
            Node temp = tempQueue.dequeue();
            Patient t = temp.data;
            emergencyQueue.enqueue(t, t.getConditionLevel());
        }

        return patientList;
    }
    
}