/**
 * Project Name:snail
 * File Name:SchoolXMLDemo.java
 * Package Name:m01.d12.xuchao
 * Date:2018年1月12日下午8:13:37
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.xuchao;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午8:13:37 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class SchoolXMLDemo {
    private static final Logger LOG = Logger.getLogger(SchoolXMLDemo.class);

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder bf = dbf.newDocumentBuilder();
            Document doc = bf.parse(new File("C:\\Users\\chaos\\Desktop\\Demo\\School.xml"));
            NodeList classList = doc.getElementsByTagName("Class");
            for (int i = 0; i < classList.getLength(); i++) {
                Node classNode = classList.item(i);
                Element element = (Element) classNode;
                String attrValue = element.getAttribute("class");
                NodeList studentsList = element.getElementsByTagName("Student");
                for (int j = 0; j < studentsList.getLength(); j++) {
                    NodeList nameList = element.getElementsByTagName("name");
                    Element nameElement = ((Element) nameList.item(j));
                    String studentName = nameElement.getFirstChild().getNodeValue();
                    // Node name = nameList.item(j);
                    // Node names = name.getFirstChild();
                    // String studentName = names.getNodeValue();
                    LOG.info("我是" + attrValue + "的学生，我叫" + studentName + "，今年"
                            + element.getElementsByTagName("age").item(j).getFirstChild().getNodeValue() + "岁，性别是"
                            + element.getElementsByTagName("sex").item(j).getFirstChild().getNodeValue() + "。");
                }
            }
        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        } catch (SAXException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
