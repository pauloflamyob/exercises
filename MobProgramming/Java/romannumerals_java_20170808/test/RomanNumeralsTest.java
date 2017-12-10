import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {
  private static Map<Integer, String> romanMap = new HashMap<>();
  static {
    romanMap.put(1, "I");
    romanMap.put(2, "II");
    romanMap.put(3, "III");
    romanMap.put(4, "IV");
    romanMap.put(5, "V");
    romanMap.put(6, "VI");
    romanMap.put(7, "VII");
    romanMap.put(8, "VIII");
    romanMap.put(9, "IX");
    romanMap.put(10, "X");
    romanMap.put(11, "XI");
    romanMap.put(12, "XII");
    romanMap.put(13, "XIII");
    romanMap.put(14, "XIV");
    romanMap.put(15, "XV");
    romanMap.put(16, "XVI");
    romanMap.put(17, "XVII");
    romanMap.put(18, "XVIII");
    romanMap.put(19, "XIX");
    romanMap.put(20, "XX");
    romanMap.put(21, "XXI");
    romanMap.put(22, "XXII");
    romanMap.put(23, "XXIII");
    romanMap.put(24, "XXIV");
    romanMap.put(40, "XL");
    romanMap.put(41, "XLI");
    romanMap.put(42, "XLII");
    romanMap.put(43, "XLIII");
    romanMap.put(50, "L");
    romanMap.put(51, "LI");
    romanMap.put(90, "XC");
    romanMap.put(100, "C");
  }

  RomanNumerals romanNumerals = new RomanNumerals();

  private void assertRomanNumeralConversion(String expected, int actual) {
    assertEquals(expected, romanNumerals.convertToRomanNumerals(actual));
  }

  @Test
  public void shouldReturnRomanNumerals() {
    for (Integer key: romanMap.keySet()) {
      assertRomanNumeralConversion(romanMap.get(key), key);
    }
  }

}