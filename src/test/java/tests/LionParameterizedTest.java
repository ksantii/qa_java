package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    private String sex;
    private String expectedMessage;

    public LionParameterizedTest(String sex, String expectedMessage) {
        this.sex = sex;
        this.expectedMessage = expectedMessage;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", null}, // Ожидается, что исключение не будет выброшено
                {"Самка", null}, // Ожидается, что исключение не будет выброшено
                {"Неизвестный", "Используйте допустимые значения пола животного - самец или самка"},
                {"Неправильный", "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void testLionSex() throws Exception {
        if (expectedMessage == null) {
            // Если ожидаемое сообщение null, создаем Lion без исключений
            Lion lion = new Lion(sex, feline);
        } else {
            // Проверяем, что при передаче некорректного пола выбрасывается исключение
            Exception exception = assertThrows(Exception.class, () -> {
                new Lion(sex, feline);
            });
            // Проверяем сообщение исключения
            assertEquals(expectedMessage, exception.getMessage());
        }
    }
}