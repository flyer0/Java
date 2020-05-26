package demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import demo.Port;
import demo.RFIDReader;
import demo.ReadError;

import junit.framework.Assert;

public class RFIDReaderMockitoTest {
  private Port mock;
  private RFIDReader reader;

  @Before
  public void setUp() {
    mock = Mockito.mock(Port.class);
    reader = new RFIDReader(mock);
  }

  @Test
  public void testReader() throws ReadError {
    String expectedTags[] = {"E004010002035FE7", "0900000033E52E12", "E004010002035BFB"};

    for (int i = 0; i < expectedTags.length; i++) {
      Mockito.when(mock.read()).thenReturn(expectedTags[i]);
    }
    Mockito.when(mock.read()).thenReturn(null);
    mock.close();

    // execute test:
    String returnedTags[] = reader.getTags();
    Assert.assertEquals("number of RFID tags", 
        expectedTags.length, 
        returnedTags.length);

    Mockito.verify(mock);

  }
}
