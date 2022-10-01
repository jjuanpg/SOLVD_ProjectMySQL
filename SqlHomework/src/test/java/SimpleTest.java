import com.solvd.connection_pool.Multithread;
import com.solvd.parsers.xml.Dom;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleTest {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document dom = documentBuilder.parse(Dom.class.getClassLoader().getResourceAsStream("car.xml"));

        public SimpleTest() throws ParserConfigurationException, IOException, SAXException {
        }

        @Test
        public void ConnectionPoolTest() throws InterruptedException {
            ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            Multithread myThing = new Multithread();
            for(int i=1; i<8; i++){
                service.submit(myThing);
            }
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
            assertTrue(myThing.isRes());
        }

        @Test
        public void ConnectionPoolRelease() throws InterruptedException {
            ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            Multithread myThing = new Multithread();
            for(int i=1; i<8; i++){
                service.submit(myThing);
            }
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
            assertTrue(myThing.isClosing());
        }

        @Test
        public void GetElementByTag(){
            NodeList nodeList = dom.getElementsByTagName("car");
            Node first = nodeList.item(0);

            assertEquals(4, nodeList.getLength());
            assertEquals(Node.ELEMENT_NODE, first.getNodeType());
            assertEquals("car", first.getNodeName());
        }
}
