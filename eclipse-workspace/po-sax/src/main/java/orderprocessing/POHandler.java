package orderprocessing;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class POHandler extends DefaultHandler {
  StringBuffer buf = null;
  static int cnt = 0;
  Double total = 0.0;
  public void startElement(String uri, String name,
                           String element, Attributes attrs) {
      
      if(element.equals("po:td")) {
          buf = new StringBuffer();
          cnt++;
          System.out.println("tes");
          
      }
  }

  public void endElement (String uri, String name, String qName){
      if(buf!= null) {
          total += Double.valueOf(buf.toString());
          buf=null;
      }
  }
  
  public void characters(char ch[], int start, int length) {
      if(buf != null) {
          for(int i = start;i < start + length;i++) {
              buf.append(ch[i]);
          }
      }
  }
  
  public double getTotal() {
      
      return total;
  }

public static void main (String args[])
        throws Exception {
   SAXParserFactory factory = SAXParserFactory.newInstance();
   SAXParser saxParser = factory.newSAXParser();
   POHandler handler = new POHandler();
   
   // Parse each file provided on the command line.
   for (int i = 0; i < args.length; i++) {
      saxParser.parse( new File(args[i]), handler );
      System.out.println(args[i]+" Total " + handler.getTotal());
      System.out.println(cnt);
   }
 }

}
