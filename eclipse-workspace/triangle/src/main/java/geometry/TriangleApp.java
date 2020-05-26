package geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class TriangleApp {
  public static void main(String args[]) {
    try {
      Pattern p = Pattern.compile(" ");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      String line = null;
      while ((line = in.readLine()) != null) {
        String[] result = p.split(line);
        if (result.length != 3) {
          throw new Exception("wrong number of input values");
        }
        double a = Double.parseDouble(result[0]);
        double b = Double.parseDouble(result[1]);
        double c = Double.parseDouble(result[2]);
        Triangle t = new TriangleImpl(a, b, c);
        System.out.println(t);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
