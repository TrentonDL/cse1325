import java.util.Arrays;
import java.util.Arrays;

public class MyPets {
    public static void main(String[] args) {
        Pet[] pets = new Pet[4];

        pets[0] = new Pet("Kevin", 4.0, Type.Snake);
        pets[1] = new Pet("Jack", 15.0, Type.Alligator);
        pets[2] = new Pet("Lucy", 12.0, Type.Lizard);
        pets[3] = new Pet("Leonardo", 15.0, Type.Turtle);

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
