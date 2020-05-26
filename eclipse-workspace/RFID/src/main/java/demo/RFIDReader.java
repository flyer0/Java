package demo;

import java.io.PrintStream;

public class RFIDReader {
  private Port port;
  private boolean errorFlag;

  public RFIDReader(Port p) {
    errorFlag = false;
    port = p;
  }

  public void list(PrintStream out) {
    String rfidTag;
    try {
      while ((rfidTag = port.read()) != null) {
        out.println(rfidTag);
      }
    } catch (ReadError ex) {
      errorFlag = true;
    }
    port.close();
  }

  public boolean isError() {
    return errorFlag;
  }

  public static void main(String args[]) throws CannotOpen {
    RFIDReader reader = new RFIDReader(new SerialPort("COM1", 9600));
    reader.list(System.out);
  }

  public String[] getTags() {
    // TODO: should return tags
    return null;
  }
}
