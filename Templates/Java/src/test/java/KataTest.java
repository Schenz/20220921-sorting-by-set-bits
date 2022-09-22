import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {
    private Kata fixture;

    @BeforeEach
    public void setUp() {
        fixture = new Kata();
    }

    @Test
    void countSetBitsForNumberEquals10() {
        Integer count = 2;
        assertEquals(count, fixture.countSetBits(10));
    }

    @Test
    void orderArrayOfNumbersBySetBits() {
        // Test data: [3, 8, 3, 6, 5, 7, 9, 1] => [1, 8, 3, 3, 5, 6, 9, 7]
        int[] testData = {3, 8, 3, 6, 5, 7, 9, 1};
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 8, 3, 3, 5, 6, 9, 7));
        assertEquals(expectedResult, fixture.sortArrayBySetBits(testData));
    }

}
