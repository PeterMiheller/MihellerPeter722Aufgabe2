package Repo;

import Modelle.Patienten;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientenRepo {
    Map<Integer, Patienten> data= new HashMap<>();

    /**
     * Creates a new object in the repository.
     *
     * @param obj The object to create.
     */
    public void add(Patienten obj) {
        data.put(obj.getId(), obj);
    }

    /**
     * Deletes an object from the repository by its ID.
     *
     * @param id The unique identifier of the object to delete.
     */
    public void remove(Integer id) {
        data.remove(id);
    }

    /**
     * Updates an existing object in the repository.
     *
     * @param obj The object to update.
     */
    public void update(Patienten obj) {
        data.replace(obj.getId(), obj);
    }

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param getId The unique identifier of the object to retrieve.
     * @return The object with the specified ID, or null if not found.
     */
    public Patienten get(Integer getId) {
        return data.get(getId);
    }

    /**
     * Retrieves all objects from the repository.
     *
     * @return A list of all objects in the repository.
     */
    public List<Patienten> getAll(){
        return data.values().stream().toList();
    }
}
