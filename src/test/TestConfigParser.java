//package test;
//
//import static org.junit.Assert.*;
//
//import java.io.InputStream;
//
//import org.junit.Test;
//
//import com.gaby.snake.configuration.SnakeConf;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//public class TestConfigParser {
//
//	private static String myXML = "<config>" +
//								  "<height>200</height>" +
//								  "</config>";
//	
//	@Test
//	public void test() {
//
//		try {
//
//			SnakeConf sc = new SnakeConf();
//			sc.setHeight(200);
//
//			XStream xs = new XStream(new DomDriver());
//			xs.processAnnotations(SnakeConf.class);
//			String xml = xs.toXML(sc);
//			int x = 0;
//
//		} catch (Exception ex) {
//			int k = 0;
//		}
//	}
//	
//	@Test
//	public void parseXMLtest() {
//		
//		try {
//			XStream xs = new XStream(new DomDriver());
//			//xs.alias("snakeconfiguration", SnakeConf.class);
//			xs.processAnnotations(SnakeConf.class);
//			
//			SnakeConf sc = (SnakeConf) xs.fromXML(myXML);
//			
//			int x = 0;
//		} catch(Exception ex) {
//			
//			int k = 0;
//		}
//		
//	}
//	
//	@Test
//	public void parseXMLFromStream() {
//
//		
//		try{
//		InputStream in = (InputStream) TestConfigParser.class
//				.getResourceAsStream("config.xml");
//		System.out.println(in != null);
//		in = (InputStream) TestConfigParser.class.getClassLoader()
//				.getResourceAsStream("config.xml");
//
//		XStream xs = new XStream(new DomDriver());
//		xs.processAnnotations(SnakeConf.class);
//		SnakeConf sc = (SnakeConf) xs.fromXML(in);
//		int y = 0;
//		} catch(Exception ex){
//			int x = 0;
//		}
//		
//	}
//	
//}
