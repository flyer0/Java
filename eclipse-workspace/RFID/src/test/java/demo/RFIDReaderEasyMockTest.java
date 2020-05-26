package demo;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import demo.Port;
import demo.RFIDReader;
import demo.ReadError;

public class RFIDReaderEasyMockTest {
  private Port mock;
  private RFIDReader reader;

  @Before
  public void setUp() {
    mock = EasyMock.createMock(Port.class);
    reader = new RFIDReader(mock);
  }

  @Test
  public void testReader() throws ReadError {
    String expectedTags[] = {"E004010002035FE7", "0900000033E52E12", "E004010002035BFB"};

    for (int i = 0; i < expectedTags.length; i++) {
      EasyMock.expect(mock.read()).andReturn(expectedTags[i]);
    }
    EasyMock.expect(mock.read()).andReturn(null);
    mock.close();

    EasyMock.replay(mock);

    // execute test:
    String returnedTags[] = reader.getTags();
    Assert.assertEquals("number of RFID tags", expectedTags.length, returnedTags.length);

    EasyMock.verify(mock);

  }
}
