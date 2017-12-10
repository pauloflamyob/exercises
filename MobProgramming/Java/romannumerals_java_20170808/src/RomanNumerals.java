import java.util.TreeMap;

public class RomanNumerals {
  private static TreeMap<Integer, String> romanMap = new TreeMap<>();

  static {
    romanMap.put(1, "I");
    romanMap.put(4, "IV");
    romanMap.put(5, "V");
    romanMap.put(9, "IX");
    romanMap.put(10, "X");
    romanMap.put(40, "XL");
    romanMap.put(50, "L");
    romanMap.put(90, "XC");
    romanMap.put(100, "C");
  }

  public String convertToRomanNumerals(int number) {
    String output = "";

    int runningCount = number;
    if (runningCount >= 100) {
      output += romanMap.get(100);
      runningCount = runningCount % 100;
    }
    if (runningCount >= 90) {
      output += romanMap.get(90);
      runningCount = runningCount % 90;
    }
    if (runningCount >= 50) {
      output += romanMap.get(50);
      runningCount = runningCount % 50;
    }

    if (runningCount >= 40) {
      output += romanMap.get(40);
      runningCount -= 40;
    }
    if (runningCount >= 10) {
      output += repeat(runningCount / 10, "X");
      runningCount = runningCount % 10;
    }
    if (runningCount == 9) {
      output += romanMap.get(9);
      runningCount = runningCount % 9;
    }
    if (runningCount >= 5) {
      output += romanMap.get(5);
      runningCount = runningCount % 5;
    }
    if (runningCount == 4) {
      output += repeat(runningCount / 4, "IV");
    }
    if (runningCount < 4) {
      output += repeat(runningCount, "I");
    }
    return output;
  }

  private String repeat(int number, String letter) {
    String value = "";
    for (int i = 0; i < number; i++) {
      value = value + letter;
    }

    return value;
  }


}


