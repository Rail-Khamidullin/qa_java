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
    // Возвращаемое значение в зависмотсти от выбора пола
    boolean bool;

    public LionTest(String sex, boolean bool) {
        this.sex = sex;
        this.bool = bool;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

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

        if (sex.equals("Самец") || sex.equals("Самка")) {


            Lion lion = new Lion(sex, feline);

            Boolean result = lion.doesHaveMane();
            assertEquals(bool, result);

            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");

            Mockito.when(feline.getKittens()).thenReturn(1);
            int kittensResult = lion.getKittens();
            assertEquals(1, kittensResult);
        } else {
            Exception exception = assertThrows(Exception.class, () -> {
                new Lion(sex, feline);
            });
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }
}
