/**
 * Project Name:snail
 * File Name:Schoolclass.java
 * Package Name:m01.d12.guojin
 * Date:2018年1月12日下午2:17:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.guojin;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:17:12 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Schoolclass {

    public static void main(String[] args) {

        try {
            File f = new File("E:\\mywork\\shcoolclass.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList nl = doc.getElementsByTagName("shcoolclass");
            for (int i = 0; i < nl.getLength(); i++) {
                Element e = (Element) nl.item(i);
                String str3 = e.getAttribute("id");
                System.out.println(str3);
                NodeList childList = doc.getElementsByTagName("students");
                NodeList childList1 = doc.getElementsByTagName("height");
                NodeList childList2 = doc.getElementsByTagName("weight");
                Node elementdone = childList.item(i);
                Node elementdone1 = childList1.item(i);
                Node elementdone2 = childList2.item(i);
                Node textdone = elementdone.getFirstChild();
                Node textdone1 = elementdone1.getFirstChild();
                Node textdone2 = elementdone2.getFirstChild();
                String str = textdone.getNodeValue();
                String str1 = textdone1.getNodeValue();
                String str2 = textdone2.getNodeValue();
                System.out.println(str3 + "有学生" + str);
                System.out.println("他 的身高是" + str1);
                System.out.println("他 的体重是" + str2);

            }
        } catch (ParserConfigurationException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (SAXException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }

}
