import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {

    // Пол
    String sex;
    // Возвращаемое значение в зависмости от выбора пола
    boolean returnValue;

    public LionTest(String sex, boolean bool) {
        this.sex = sex;
        this.returnValue = bool;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    // Проверим работу класса с разными входными данными
    @Parameterized.Parameters
    public static Object[][] setSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Самурай", true}
        };
    }

    @Test
    public void lionTest() throws Exception {

        // Для полов Самец и Самка
        if (sex.equals("Самец") || sex.equals("Самка")) {

            // Экземпляр класса
            Lion lion = new Lion(sex, feline);

            // Поле для сохранения результата
            boolean result = lion.doesHaveMane();
            assertEquals(returnValue, result);

            // Проверка работы метода getFood
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");

            // Проверка метода getKittens
            Mockito.when(feline.getKittens()).thenReturn(1);
            int kittensResult = lion.getKittens();
            assertEquals(1, kittensResult);

            // В случае, если пол будет иной выбросит исключение
        } else {
            Exception exception = assertThrows(Exception.class, () -> {
                new Lion(sex, feline);
            });
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }
}
