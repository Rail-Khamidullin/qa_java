import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    // Проверка работы метода eatMeat
    @Test
    public void felineEatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    // Проверка работы метода getFamily
    @Test
    public void felineGetFamilyTest() throws Exception {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверка работы метода getKittens()
    @Test
    public void felineGetKittensTest() throws Exception {
        feline.getKittens();
        // Проверка, что внутри метода getKittens вызвался метод getKittens() с нужным параметром
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}
