import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kata {
    public int countSetBits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number & (number - 1);
        }

        return count;
    }

    public List<Integer> sortArrayBySetBits(int[] data) {
        ArrayList<NumberWithSetBit> list = new ArrayList<>();

        for (int datum : data) {
            list.add(new NumberWithSetBit(datum, countSetBits(datum)));
        }

        list.sort(new NumberWithSetBitComparator());

        ArrayList<Integer> values = new ArrayList<>();
        for (NumberWithSetBit number: list) {
            values.add(number.originalNumber);
        }

        return values;
    }
}

class NumberWithSetBit {
    int originalNumber;
    int setBit;

    public NumberWithSetBit(int n, int bitSet) {
        originalNumber = n;
        setBit = bitSet;
    }
}

// creates the comparator for comparing stock value
class NumberWithSetBitComparator implements Comparator<NumberWithSetBit> {

    // override the compare() method
    public int compare(NumberWithSetBit s1, NumberWithSetBit s2)
    {
        if (s1.setBit == s2.setBit) {
            if (s1.originalNumber == s2.originalNumber) {
                return 0;
            } else if (s1.originalNumber > s2.originalNumber) {
                return 1;
            } else {
                return -1;
            }
        }
        else if (s1.setBit > s2.setBit)
            return 1;
        else
            return -1;
    }
}