package tst.project.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtils {
	
	/**
     * 提取出xml数据包中的加密消息
     * @param xmltext 待提取的xml字符串
     * @return 提取出的加密消息字符串
     * @throws AesException 
     */
    public static Object[] extract(String xmltext){
        Object[] result = new Object[3];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xmltext);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName("Encrypt");
            NodeList nodelist2 = root.getElementsByTagName("ToUserName");
            System.out.println("nodelist2.item(0)="+nodelist2.item(0));
            result[0] = 0;
            result[1] = nodelist1.item(0).getTextContent();
            //这里加了一个判断，因为接收推送component_verify_ticket的解谜过程中没有第三个参数，回报空指针异常
            if(nodelist2.item(0) != null){
                result[2] = nodelist2.item(0).getTextContent();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	/**
	 * map转成xml
	 * 
	 * @param arr
	 * @return
	 */
	public static String ArrayToXml(Map<String, String> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}

		xml += "</xml>";
		return xml;
	}

	public static Document getDocumentByXml(String xml){
		try{
			StringReader sr = new StringReader(xml); 
			InputSource is = new InputSource(sr); 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
			Document doc = builder.parse(is);
			
			//Document document = (Document) DocumentHelper.parseText(xml); 
			return doc;
		}catch(Exception e){
			return null;
		}
	}
	public static String getValueByTagName(Document doc, String tagName) {
		if (doc == null) {
			return "";
		}
		NodeList pl = doc.getElementsByTagName(tagName);
		if (pl != null && pl.getLength() > 0) {
			return pl.item(0).getTextContent();
		}
		return "";
	}

	// XML转字符串 原样取出
	public static String getXmlString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");// 解决中文问题，试过用GBK不行
			t.setOutputProperty(OutputKeys.METHOD, "html");
			t.setOutputProperty(OutputKeys.VERSION, "4.0");
			t.setOutputProperty(OutputKeys.INDENT, "no");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			t.transform(new DOMSource(doc), new StreamResult(bos));
			return bos.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return "";
	}
}
