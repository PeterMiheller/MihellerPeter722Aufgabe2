package Modelle;

import java.util.List;

public class Patienten {
    private int id;
    private String name;
    private int age;
    private String disease;
    private List<Mrdikanemte> medikamentList;

    public Patienten(int id, String name, int age, String disease, List<Mrdikanemte> medikamentList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.medikamentList = medikamentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<Mrdikanemte> getMedikamentList() {
        return medikamentList;
    }

    public void setMedikamentList(List<Mrdikanemte> medikamentList) {
        this.medikamentList = medikamentList;
    }

    @Override
    public String toString() {
        return "Patienten{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", disease='" + disease + '\'' +
                ", medikamentList=" + medikamentList +
                '}';
    }
}
