import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.example.FelineInterface;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LionParameterizedTest {
        @Mock
        private FelineInterface mockFeline;
        private Lion lion;

    @BeforeEach
    void setUp() {
        mockFeline = mock(FelineInterface.class);
    }

    @ParameterizedTest
    @CsvSource({
            "3",
            "2",
            "0",
            "-1"
    })
    void getKittens(int kittens) throws Exception {
        FelineInterface felineMock = mock(FelineInterface.class);
        when(felineMock.getKittens()).thenReturn(kittens);

        Lion lion = new Lion("Самка", felineMock);
        assertEquals(kittens, lion.getKittens());
    }

    @ParameterizedTest
    @CsvSource({
            "'Животные, Птицы, Рыба'",
            "'Мясо'",
            "'Животные, Мясо, Рыба'",
            "'Трава, Различные растения'",
            "' '"
    })
    void getFood(String foodItems) throws Exception {
        List<String> foodList = List.of(foodItems);
        when(mockFeline.getFood("Хищник")).thenReturn(foodList);

        lion = new Lion("Самка", mockFeline);
        assertEquals(foodList, lion.getFood());
    }
}

