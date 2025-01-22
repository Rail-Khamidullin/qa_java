import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    //    Feline feline;
    @Mock
    Feline feline;

    // Проверка метода getKittens
    @Test
    public void lionGetKittensTest() throws Exception {
        // Экземпляр класса
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittensResult = lion.getKittens();
        assertEquals(1, kittensResult);
    }

    // Проверка работы метода getFood
    @Test
    public void lionGetFoodTest() throws Exception {
        // Экземпляр класса
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    // В случае, если пол будет иной, выбросит исключение
    @Test
    public void lionExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Самурай", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
