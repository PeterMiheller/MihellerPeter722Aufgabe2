import Modelle.Mrdikanemte;
import Modelle.Patienten;
import Repo.MedikamenteRepo;
import Repo.PatientenRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        PatientenRepo patientenRepo = new PatientenRepo();
        MedikamenteRepo medikamenteRepo = new MedikamenteRepo();
        Mrdikanemte p1 = new Mrdikanemte("A","Aspirin",10);
        Mrdikanemte p2 = new Mrdikanemte("B","Aspirin 2",10);
        medikamenteRepo.add(p1);
        medikamenteRepo.add(p2);
        patientenRepo.add(new Patienten(1,"Ana",20, "Fractura", new ArrayList<>(Arrays.asList(p1,p2))));
        patientenRepo.add(new Patienten(2,"Bogdan",20, "Fractura", new ArrayList<>(Arrays.asList(p1,p2))));
        Service service = new Service(medikamenteRepo, patientenRepo);

        UI ui = new UI(service);
        ui.start();
    }

}