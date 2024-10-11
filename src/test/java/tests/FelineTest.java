package tests;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    private Feline feline; // Экземпляр класса Feline

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = new Feline(); // Инициализация экземпляра Feline
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat(); // Вызываем метод eatMeat
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод getFamily возвращает "Кошачьи"
        assertEquals("Кошачьи", feline.getFamily()); // Проверяем строку, которую нужно протестировать
    }

    @Test
    public void testGetKittens() {
        // Проверяем, что метод getKittens возвращает 1
        assertEquals(1, feline.getKittens()); // Проверяем строку, которую нужно протестировать
    }

    @Test
    public void testGetKittensWithCount() {
        // Проверяем, что метод getKittens(int) возвращает переданное значение
        assertEquals(5, feline.getKittens(5)); // Проверяем строку, которую нужно протестировать
    }
}