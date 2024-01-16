package erms;

import java.util.Scanner;

public class ERMS {
    public static void main(String[] args) {
        EmergencyRoom emergencyQueue = new EmergencyRoom(4);

        Patient patient1 = new Patient("John", 4);
        Patient patient2 = new Patient("Sarah", 3);
        Patient patient3 = new Patient("Emma", 2);
        Patient patient4 = new Patient("Michael", 1);
        Patient patient5 = new Patient("Sophia", 3);
        Patient patient6 = new Patient("William", 2);
        Patient patient7 = new Patient("Olivia", 4);
        Patient patient8 = new Patient("Liam", 1);
        Patient patient9 = new Patient("Emma", 5);
        Patient patient10 = new Patient("Noah", 3);
        Patient patient11 = new Patient("Ava", 4);
        Patient patient12 = new Patient("James", 2);
        Patient patient13 = new Patient("Isabella", 2);
        Patient patient14 = new Patient("Ethan", 5);


        emergencyQueue.addPatient(patient1, patient1.getConditionLevel());
        emergencyQueue.addPatient(patient2, patient2.getConditionLevel());
        emergencyQueue.addPatient(patient3, patient3.getConditionLevel());
        emergencyQueue.addPatient(patient4, patient4.getConditionLevel());
        emergencyQueue.addPatient(patient5, patient5.getConditionLevel());
        emergencyQueue.addPatient(patient6, patient6.getConditionLevel());
        emergencyQueue.addPatient(patient7, patient7.getConditionLevel());
        emergencyQueue.addPatient(patient8, patient8.getConditionLevel());
        emergencyQueue.addPatient(patient9, patient9.getConditionLevel());
        emergencyQueue.addPatient(patient10, patient10.getConditionLevel());
        emergencyQueue.addPatient(patient11, patient11.getConditionLevel());
        emergencyQueue.addPatient(patient12, patient12.getConditionLevel());
        emergencyQueue.addPatient(patient13, patient13.getConditionLevel());
        emergencyQueue.addPatient(patient14, patient14.getConditionLevel());


        // Simulating treating patients
        while (!emergencyQueue.isEmpty()) {
            emergencyQueue.treatNextPatient();
        }
        
        Scanner sc = new Scanner(System.in);
        int n, bedNum;
        boolean validnum = false;
        while(!validnum){
            validnum = false;
            do{
                System.out.println("========================");
                System.out.println("Emergency Room System");
                System.out.println("========================");
                System.out.println("Please choose an option:");
                System.out.println("1. Admit patient");
                System.out.println("2. Treat patient");
                System.out.println("3. Discharge patient");
                System.out.println("4. Manage beds");
                System.out.println("5. Handle waiting list");
                System.out.println("6. Notify staff about critical conditions");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                try{
                    n = Integer.parseInt(sc.nextLine());
                    switch(n){
                        case 0:
                            validnum = true;
                            break;
                        case 1:// Admit patient
                            System.out.print("Enter patient name: ");
                            String name = sc.nextLine();
                            System.out.println("Triage system has five levels:");
                            System.out.println("Level 5: Immediate");
                            System.out.println("Level 4: Emergency");
                            System.out.println("Level 3: Urgent");
                            System.out.println("Level 2: Semi-urgent");
                            System.out.println("Level 1: Non-urgent");
                            System.out.print("Enter triage level: ");
                            boolean validTriageLevel = false;
                            while(!validTriageLevel){
                                try{
                                    int triageLevel = Integer.parseInt(sc.nextLine());
                                    Patient newPatient = new Patient(name, triageLevel);
                                    emergencyQueue.addPatient(newPatient, triageLevel);
                                    validTriageLevel = true;

                                }catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a number from 1 to 5.");
                                    validTriageLevel = false;
                                }
                            }
                            break;
                        case 2:// Treat patient
                            emergencyQueue.treatNextPatient();
                            break;
                        case 3:// Discharge patient
                            System.out.print("Enter the bed number you want to release: ");
                            boolean validbedNum = false;
                            while(!validbedNum){
                                try{
                                    bedNum = Integer.parseInt(sc.nextLine());
                                    validbedNum = true;
                                    emergencyQueue.releaseBed(bedNum);
                                    
                                }catch(NumberFormatException e){
                                    System.out.println("Invalid input. Please enter a valid bed number.");
                                    validbedNum = false;
                                }
                            }
                            break;
                        case 4:// Manage beds
                            emergencyQueue.showAvailableBeds();
                            break;
                        case 5:// Handle waiting list
                            emergencyQueue.showWaitingList();
                            break;
                        case 6:// Notify staff about critical conditions
                            emergencyQueue.notifyStaffCritical();
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number from 0 to 6.");
                            break;
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number from 0 to 6.");
                    validnum = false;
                    break;
                }   
            }while(n!=0);
        }
    }
}