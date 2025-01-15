package Repo;

import Modelle.Mrdikanemte;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedikamenteRepo {
    Map<String, Mrdikanemte> data= new HashMap<>();

    /**
     * Creates a new object in the repository.
     *
     * @param obj The object to create.
     */
    public void add(Mrdikanemte obj) {
        data.put(obj.getName(), obj);
    }

    /**
     * Deletes an object from the repository by its ID.
     *
     * @param name The unique identifier of the object to delete.
     */
    public void remove(String name) {
        data.remove(name);
    }

    /**
     * Updates an existing object in the repository.
     *
     * @param obj The object to update.
     */
    public void update(Mrdikanemte obj) {
        data.replace(obj.getName(), obj);
    }

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param name The unique identifier of the object to retrieve.
     * @return The object with the specified ID, or null if not found.
     */
    public Mrdikanemte get(String name) {
        return data.get(name);
    }

    /**
     * Retrieves all objects from the repository.
     *
     * @return A list of all objects in the repository.
     */
    public List<Mrdikanemte> getAll(){
        return data.values().stream().toList();
    }
}
