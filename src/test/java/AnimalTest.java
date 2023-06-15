import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private Animal animal = new Animal();

    @Test
    public void getFoodTest() {
        try {
            animal.getFood("Всеядный");
        } catch (Exception UnknownAnimalKind) {
            String actualResult = UnknownAnimalKind.getMessage();
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", actualResult);
        }
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualResult = animal.getFamily();
        assertEquals(expectedResult, actualResult);
    }
}