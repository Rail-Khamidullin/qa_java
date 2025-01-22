import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterLionTest {

    // Пол
    private String sex;
    // Возвращаемое значение в зависмости от выбора пола
    private boolean returnValue;

    public ParameterLionTest(String sex, boolean bool) {
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
                {"Самка", false}
        };
    }

    // Для полов Самец и Самка
    @Test
    public void lionTest() throws Exception {
            // Экземпляр класса
            Lion lion = new Lion(sex, feline);

            // Поле для сохранения результата
            boolean result = lion.doesHaveMane();
            assertEquals(returnValue, result);
    }
}
