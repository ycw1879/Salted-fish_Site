package com.gomso.core.utils;

import org.w3c.dom.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SuppressWarnings("rawtypes")
public class XmlUtil {

    
    @SuppressWarnings("unchecked")
	public static ArrayList getFindChildNodeToNodeList(NodeList nodeList ,String nodename ) {

			ArrayList nodes = new ArrayList();
	
			for(int i=0; i<nodeList.getLength();i++) {
	
				Node node = nodeList.item(i);
	
				if (node.getNodeName().equalsIgnoreCase(nodename)){
					nodes.add(node);
				}
	
			}
	
			return nodes;
		}

	public static NodeList getFindChildNodeList(Node node) {
	
		NodeList nodelist = node.getChildNodes();
		return nodelist;
	}

	public static boolean existElements(NodeList nl) {
	
		boolean returnValue = false;
	
		if (nl != null && nl.getLength() > 0) returnValue = true;
	
		return returnValue;
	}


    @SuppressWarnings("unchecked")
    public static HashMap getFindAttributesMap(Node node,String[] key){
		HashMap map = new HashMap();
		NamedNodeMap attrs = node.getAttributes();
		for(int i=0; i<attrs.getLength();i++) {
	
			Node sqlattrnode = attrs.item(i);
	
			for(int j =0; j < key.length; j ++){
				if (sqlattrnode.getNodeName().equalsIgnoreCase(key[j])){
					map.put(key[j], sqlattrnode.getNodeValue().trim());
				}
	
			}
		}
		return map;
	}


	public static String getFindAttributes(Node node,String key){
		NamedNodeMap attrs = node.getAttributes();
		String returnVal = null;
		for(int i=0; i<attrs.getLength();i++) {
	
			Node sqlattrnode = attrs.item(i);
			if(sqlattrnode.getNodeName().equals(key)){
				returnVal = sqlattrnode.getNodeValue().trim();
			}
	
		}
		return returnVal;
	}

	public static String getNodeValue(Node node){
		String returnValue = null;
		Node childNode = node.getFirstChild();

		
		if(childNode.getNodeType() == Node.TEXT_NODE || childNode.getNodeType() == Node.CDATA_SECTION_NODE ){
			returnValue = childNode.getNodeValue().trim();
		}
		return returnValue;
	}

	public static void writeToFile(String fileName, String xml, String encoding) throws Exception {
	
		String absolutePath = fileName;
		
		PrintStream out = null;
		try{
			FileUtil.copyFile(absolutePath, absolutePath + ".bak");
			File fileArchive = new File( absolutePath );
	
			FileOutputStream fo = null;
			if( fileArchive.exists() ){
				fo = new FileOutputStream( absolutePath, false );
			}else{
				fileArchive.createNewFile();
				fo = new FileOutputStream( absolutePath, true );
			}

			out = new PrintStream(fo , false, encoding);
			
			out.print(xml);
			out.flush();
			
		}catch(Exception e){			
			throw e;
		}finally{
			try { out.close(); } catch(Exception e) {}
		}
	}

	public static Node findChildFromNodeWithName(Node node , String nodename) {
	
				
		Node childNode = null;
		NodeList nodelist = node.getChildNodes();
//		System.out.println( nodelist.getLength() );
		if (existElements(nodelist)) {
			
			for(int i=0; i<nodelist.getLength();i++) {
	
				Node cnode = nodelist.item(i);
//				System.out.println( i + ":" + cnode );
				
//				System.out.println( cnode.getNodeName() + ":" + nodename );
				if (cnode.getNodeName().equalsIgnoreCase(nodename)) 
					childNode = cnode;
			}
		}
	
		return childNode;
	}

	public static List<Node> findNodesFromNodeWithName(Node node , String nodename) {
		List<Node> list = new ArrayList<Node>();
		NodeList nodelist = node.getChildNodes();
		if (existElements(nodelist)) {
	
			for(int i=0; i<nodelist.getLength();i++) {
				Node cnode = nodelist.item(i);
	
				if (cnode.getNodeName().equalsIgnoreCase(nodename)){ 
					list.add(cnode);
				}
			}
		}
	
		return list;
	}

	public static String getAttributeToNode(Node node,String name){
		String retrunValue = null;
		NamedNodeMap attributes = node.getAttributes();
		for(int i=0; i<attributes.getLength();i++) {
	
			Node sqlattrnode = attributes.item(i);
			if (sqlattrnode.getNodeName().equalsIgnoreCase(name)) 
				retrunValue = sqlattrnode.getNodeValue().trim();
		}
		return retrunValue;
	}

	public static String getAttributeToElement(Element element,String name){
		String returnValue = null;
		NamedNodeMap attributes = element.getAttributes();
		for(int i=0; i<attributes.getLength();i++) {
	
			Node sqlattrnode = attributes.item(i);
			if (sqlattrnode.getNodeName().equalsIgnoreCase(name)) 
				returnValue = sqlattrnode.getNodeValue().trim();
		}
		return returnValue;
	}

	

	public static String toString(Document doc, String encoding) 
	{ 
		if(encoding == null){
			encoding = "UTF-8";
		}
		
		try{ 
			StringWriter stw = new StringWriter(); 
			Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
			serializer.setOutputProperty( OutputKeys.ENCODING , encoding );
			serializer.setOutputProperty( OutputKeys.METHOD , "xml" );
			serializer.setOutputProperty( OutputKeys.INDENT , "yes" );
			serializer.setOutputProperty( OutputKeys.CDATA_SECTION_ELEMENTS , "yes" );
			serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
			return stw.toString(); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return null; 
	}
}
