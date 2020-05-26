package demo;

import org.junit.Test;

public class RFIDReaderTest {

  @Test
  public void testReader() {
    MockPort mockport = new MockPort();
    RFIDReader r = new RFIDReader(mockport);
    r.list(mockport);
    mockport.verify();
  }
}
