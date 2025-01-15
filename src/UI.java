import Modelle.Mrdikanemte;
import Modelle.Patienten;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main console application class that provides a command-line interface for interacting with the system.
 */
public class UI {
    private final Service service;
    /**
     * Constructs a new UI with the given Service.
     *
     * @param service The service that handles the business logic for the system.
     */
    public UI(Service service) {
        this.service = service;
    }

    /**
     * Starts the console application, displaying a menu and handling user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("""
                    Select an option:

                    1. Add Patient
                    2. Remove Patient
                    3. Get Patient by Id
                    4. Update Patient
                    5. Get all Patients
                    6. Add Medicament
                    7. Remove Medicament
                    8. Get Medicament by Id
                    9. Update Medicament
                    10. Get all Medicament
                    11. Filter Patienten nach Diagnose
                    12. Filter Patientsn nach Medikament für ein Krankheit 
                    13. Sort Medikamente  von bestimmten Patient

                    0. Exit
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":
                    service.addPatient(addPatient(scanner));
                    break;
                case "2":
                    service.removePatient(readPatientId(scanner));
                    break;
                case "3":
                    service.getPatientById(readPatientId(scanner));
                    break;
                case "4":
                    service.updatePatient(updatePatients(scanner));
                    break;
                case "5":
                    service.getAllPatiens1();
                    break;
                case "6":
                    service.addMedikament(addMedicament(scanner));
                    break;
                case "7":
                    service.removeMedikament(readProduktName(scanner));
                    break;
                case "8":
                    service.getMedikamentByName(readProduktName(scanner));
                    break;
                case "9":
                    service.updateMedikament(updateMedikament(scanner));
                    break;
                case "10":
                    service.getAllMedikamente1();
                    break;
                case "11":
                    service.filterPatiensByDisease(scanner.nextLine());
                    break;
                case "12":
                    service.viewPatientenByKrankheit(scanner.nextLine());
                    break;
                case "13":
                    Patienten patient = service.getPatientById(readPatientId(scanner));
                    service.sortProducts(patient,readSorter(scanner));
                    break;
                default:
            }
        }
    }
    /**
     * Creates a new Kunde instance by collecting details from user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A new Kunde instance populated with the provided data.
     */
    public Patienten addPatient(Scanner scanner){
        int id = readPatientId(scanner);
        System.out.println("Enter Patient name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patient age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patient Disease: ");
        String disease = scanner.nextLine();
        List<Mrdikanemte> produkts = new ArrayList<>();
        while (true){
            System.out.println("Enter Patient medicaments: ");
            String produkt = scanner.nextLine();
            if(produkt.isEmpty()){
                break;
            }
            else {
                produkts.add(service.findMedicament(produkt));
            }
        }
        return new Patienten(id,name,age,disease,produkts);

    }
    /**
     * Updates an existing object by collecting updated details from user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return An updated object instance populated with the new data.
     */
    public Patienten updatePatients(Scanner scanner) {
        System.out.println("Enter Patient id you want to update: ");
        int id = readPatientId(scanner);
        System.out.println("Enter new Patient name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patient age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new Patient Disease: ");
        String disease = scanner.nextLine();
        List<Mrdikanemte> produkts = new ArrayList<>();
        while (true) {
            System.out.println("Enter new Patient Medikaments (leave empty to finish): ");
            String produkt = scanner.nextLine();
            if (produkt.isEmpty()) {
                break;
            } else {
                produkts.add(service.findMedicament(produkt));
            }
        }
        return new Patienten(id,name,age,disease,produkts);
    }
    /**
     * Creates a new Produkt instance by collecting details from user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A new Produkt instance populated with the provided data.
     */
    public Mrdikanemte addMedicament(Scanner scanner) {
        String name = readProduktName(scanner);
        System.out.println("Enter Medicment preis: ");
        int preis = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Medicment For what disease it is: ");
        String krankheit = scanner.nextLine();
        return new Mrdikanemte(name,krankheit, preis);
    }
    /**
     * Updates an existing object by collecting updated details from user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return An updated Mrdikanemte instance populated with the new data.
     */
    public Mrdikanemte updateMedikament(Scanner scanner) {
        System.out.println("Enter Medikament name you want to update: ");
        String name = readProduktName(scanner);
        System.out.println("Enter new Medikament preis: ");
        int preis = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new Medikament Disease: ");
        String krankheit = scanner.nextLine();
        return new Mrdikanemte(name,krankheit, preis);
    }

    /**
     * Reads an object sorter type from the user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The object sorter type entered by the user.
     */
    public String readSorter(Scanner scanner){
        System.out.println("Enter aufsteigend oder absteigend: ");
        String sort = scanner.nextLine();
        return sort;
    }
    /**
     * Reads an object ID from the user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The object ID entered by the user.
     */
    public Integer readPatientId(Scanner scanner) {
        System.out.println("Enter Patient id: ");
        return Integer.parseInt(scanner.nextLine());
    }
    /**
     * Reads an object name from the user input.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The object name entered by the user.
     */
    public String readProduktName(Scanner scanner) {
        System.out.println("Enter Medicament name: ");
        return scanner.nextLine();
    }
}
