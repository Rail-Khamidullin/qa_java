import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Cat cat = new Cat(new Feline());

    @Test
    public void catTest() throws Exception {

        String catSay = cat.getSound();
        Mockito.verify(cat).getSound();
        assertEquals("Мяу", catSay);

        cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
