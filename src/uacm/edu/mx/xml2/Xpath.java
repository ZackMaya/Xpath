package uacm.edu.mx.xml2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xpath {
    
	public static void main(String[] args) {
	      
	      try {
	         File inputFile = new File("c:/Users/netoz/Documents/workspace-sts-3.9.4.RELEASE/Xpath/src/uacm/edu/mx/xml2/archivo.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder;

	         dBuilder = dbFactory.newDocumentBuilder();

	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();

	         XPath xPath =  XPathFactory.newInstance().newXPath();

	      //Aqui va la consulta XPAth
	         String expression = "/items/item";	 
	         
	    //     String expression ="/items/item[contains(id,'item1')]";
	         
	         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
	            doc, XPathConstants.NODESET);

	         for (int i = 0; i < nodeList.getLength(); i++) {
	            Node nNode = nodeList.item(i);
	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               System.out.println("La bebida pertenece a :" + eElement.getAttribute("id"));
	               System.out.println("Nombre bebida : " 
	                  + eElement
	                  .getElementsByTagName("name")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Tipo : " 
	                  + eElement
	                  .getElementsByTagName("type")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("foto : " 
	                  + eElement
	                  .getElementsByTagName("photo")
	                  .item(0)
	                  .getTextContent());
	              
	            }
	         }
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (XPathExpressionException e) {
	         e.printStackTrace();
	      }
	   }
 
}
