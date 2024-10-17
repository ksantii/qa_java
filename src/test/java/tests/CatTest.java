package tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем поведение мока
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));

        // Создаем экземпляр Cat с мокированным Feline
        Cat cat = new Cat(feline);
        // Вызываем метод getFood
        List<String> food = cat.getFood();
        // Проверяем, что возвращаемый список содержит ожидаемые значения
        assertEquals(2, food.size());
        assertEquals("Животные", food.get(0));
    }

    @Test
    public void testGetSound() {
        // Проверяем, что метод getSound возвращает "Мяу"
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
}