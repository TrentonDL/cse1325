import java.util.Arrays;

public class MyPets {
    public static void main(String[] args) {
        Pet[] pets = new Pet[4];

        pets[0] = new Pet("Kevin", 4.0, Type.SNAKE);
        pets[1] = new Pet("Jack", 15.0, Type.ALLIGATOR);
        pets[2] = new Pet("Lucy", 12.0, Type.LIZARD);
        pets[3] = new Pet("Leonardo", 15.0, Type.TURTLE);

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
