import Modelle.*;
import Repo.MedikamenteRepo;
import Repo.PatientenRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A service class that provides the business logic for the system.
 */
public class Service {
    private final MedikamenteRepo medikamenteRepo;
    private final PatientenRepo patientenRepo;

    /**
     * Constructs a new Service with the given repositories.
     *
     * @param medikamenteRepo The repository for courses.
     * @param patientenRepo   The repository for students.
     */
    public Service(MedikamenteRepo medikamenteRepo, PatientenRepo patientenRepo) {
        this.medikamenteRepo = medikamenteRepo;
        this.patientenRepo = patientenRepo;
    }

    public void addMedikament(Mrdikanemte medikament) {
        medikamenteRepo.add(medikament);
    }

    public void addPatient(Patienten patient) {
        patientenRepo.add(patient);
    }

    public void removeMedikament(String name) {
        medikamenteRepo.remove(name);
    }

    public void removePatient(int id) {
        patientenRepo.remove(id);
    }

    /**
     * Displays an object by its unique identifier
     *
     * @param id The unique identifier of the object to display.
     * @return an object by its unique identifier
     */
    public Patienten getPatientById(int id) {
        return patientenRepo.get(id);
    }

    /**
     * Displays an object by its name
     *
     * @param name The name of the object to display.
     * @return an object by its name
     */
    public Mrdikanemte getMedikamentByName(String name) {
        return medikamenteRepo.get(name);
    }

    public void updatePatient(Patienten patient) {
        Patienten existingPatient = patientenRepo.get(patient.getId());
        existingPatient.setName(patient.getName());
        existingPatient.setDisease(patient.getDisease());
        existingPatient.setAge(patient.getAge());
        existingPatient.setMedikamentList(patient.getMedikamentList());
        patientenRepo.update(existingPatient);
    }

    public void updateMedikament(Mrdikanemte medikament) {
        Mrdikanemte existingMedikament = medikamenteRepo.get(medikament.getName());
        existingMedikament.setName(medikament.getName());
        existingMedikament.setPrice(medikament.getPrice());
        existingMedikament.setKrankheit(medikament.getKrankheit());
        medikamenteRepo.update(existingMedikament);
    }

    /**
     * Retrieves all patients.
     *
     * @return A list of all available patients.
     */
    public List<Patienten> getAllPatiens() {
        return patientenRepo.getAll();
    }

    /**
     * Retrieves all medicaments.
     *
     * @return A list of all available medicaments.
     */
    public List<Mrdikanemte> getAllMedikamente() {
        return medikamenteRepo.getAll();
    }


}
