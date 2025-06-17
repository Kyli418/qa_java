import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    private Feline mockFeline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    void getSound() {
        assertEquals("Мяу", cat.getSound());
    }
}
