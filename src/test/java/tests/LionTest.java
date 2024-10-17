package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;

// Указываем, что тесты будут выполняться с использованием MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    // Создаем мок объекта Feline с помощью аннотации @Mock
    @Mock
    private Feline feline;

    // Метод инициализации, который будет вызываться перед каждым тестом
    @Before
    public void init() {
        // Инициализация моков
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLionHasMane() throws Exception {
        // Создаем экземпляр Lion с полом "Самец"
        Lion lion = new Lion("Самец", feline);
        // Проверяем, что Lion имеет гриву
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionThrowsExceptionForInvalidSex() {
        // Проверяем, что при передаче некорректного пола выбрасывается исключение
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный", feline);
        });
        // Проверяем сообщение исключения
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
    @Test
    public void testGetKittens() throws Exception {
        // Настраиваем поведение мока
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        // Проверяем, что метод getKittens возвращает 3
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем поведение мока
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));
        Lion lion = new Lion("Самец", feline);
        // Проверяем, что метод getFood возвращает ожидаемые значения
        List<String> food = lion.getFood();
        assertEquals(2, food.size());
        assertEquals("Животные", food.get(0));
    }

    @Test
    public void testLionessDoesNotHaveMane() throws Exception {
        // Создаем экземпляр Lion с полом "Самка"
        Lion lioness = new Lion("Самка", feline);
        // Проверяем, что львица не имеет гривы
        assertEquals(false, lioness.doesHaveMane());
    }
}
