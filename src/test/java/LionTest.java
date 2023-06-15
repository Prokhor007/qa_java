import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        int expectedResult = 1;
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testExceptionLionSex() {
        try {
            Lion lionSex = new Lion("Оно", feline);
            System.out.println(lionSex);
        } catch (Exception UnknownSexName) {
            String actualResult = UnknownSexName.getMessage();
            assertEquals("Используйте допустимые значения пола животного - самец или самка", actualResult);
        }
    }
}
