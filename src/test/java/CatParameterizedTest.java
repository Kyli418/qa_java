import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class CatParameterizedTest {
    @Mock
    private Feline mockFeline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @ParameterizedTest
    @CsvSource({
            "'Животные, Птицы, Рыба'",
            "'Мясо'",
            "'Рыба, Мясо, Падаль'",
            "'Трава, Различные растения'"
    })
    void testGetFood_ReturnsExpectedFoodList(String foodItems) throws Exception {
        List<String> expectedFood = List.of(foodItems);
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).eatMeat();
    }
}

