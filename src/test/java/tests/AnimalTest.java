package tests;

import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    public void testGetFoodHerbivore() throws Exception {
        // Проверяем, что метод возвращает правильный список для травоядного
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        // Проверяем, что метод возвращает правильный список для хищника
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFoodUnknown() {
        // Проверяем, что метод выбрасывает исключение для неизвестного вида животного
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестный");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод возвращает правильную строку
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}