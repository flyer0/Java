package geometry;

/**
 * The triangle class represents a two-dimensional figure with three vertices 
 * and three edges which are straight lines.
 * 
 * @author Ronald Tanner tar@semafor.ch
 */
public class TriangleImpl implements Triangle {
  private boolean isosceles; // gleichschenklig
  private boolean equilateral; // gleichseitig
  private boolean acute_angled; // spitzwinklig
  private boolean obtuse_angled; // stumpfwinklig
  private boolean right_angled; // rechtwinklig

  /**
   * constructs a triangle and determines its type
   * 
   * @param a length of the longest side
   * @param b length of the midst side
   * @param c length of the shortest side
   * @throws exception if the order sequence of the parameters a,b,c is not descending.
   */
  public TriangleImpl(double a, double b, double c) throws Exception {
    isosceles = false;
    equilateral = false;
    acute_angled = false;
    obtuse_angled = false;
    right_angled = false;

    if ((a < b) || (b < c)) {
      throw new Exception("wrong input");
    }
    if ((a == b) || (b == c)) {
      if ((a == b) && (b == c)) {
        equilateral = true;
      } else {
        isosceles = true;
      }
    } else {
      double a2 = a * a;
      double b2 = b * b;
      double c2 = c * c;
      if (a2 == b2 + c2) {
        right_angled = true;
      } else if (a2 < b2 + c2) {
        acute_angled = true;
      } else {
        obtuse_angled = true;
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see geometry.Triangle#isIsosceles()
   */
  public boolean isIsosceles() {
    return isosceles;
  }

  /*
   * (non-Javadoc)
   * 
   * @see geometry.Triangle#isEquilateral()
   */
  public boolean isEquilateral() {
    return equilateral;
  }

  /*
   * (non-Javadoc)
   * 
   * @see geometry.Triangle#isAcuteAngled()
   */
  public boolean isAcuteAngled() {
    return acute_angled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see geometry.Triangle#isObtuseAngled()
   */
  public boolean isObtuseAngled() {
    return obtuse_angled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see geometry.Triangle#isRightAngled()
   */
  public boolean isRightAngled() {
    return right_angled;
  }

  public String toString() {
    return new String(
        (isIsosceles() ? "1" : "0") + (isEquilateral() ? "1" : "0") + (isAcuteAngled() ? "1" : "0")
            + (isObtuseAngled() ? "1" : "0") + (isRightAngled() ? "1" : "0"));
  }

}
