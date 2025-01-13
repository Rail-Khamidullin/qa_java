import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Lion lion;

    @Test
    public void test() {

        lion.getKittens();
        try {
            lion.getFood();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        lion.

        lion.doesHaveMane();

    }

}
