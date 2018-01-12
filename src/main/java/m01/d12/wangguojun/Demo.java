/**
 * Project Name:snail
 * File Name:Demo.java
 * Package Name:m01.d12.wangguojun
 * Date:2018年1月12日下午3:37:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.wangguojun;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Description:   <br/>
 * Date:     2018年1月12日 下午3:37:38 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        long lasting = System.currentTimeMillis();

        try {
            File f = new File("E:\\workspace\\lession1\\Demo9.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(f);

            NodeList n1 = doc.getElementsByTagName("class");
            for (int i = 0; i < n1.getLength(); i++) {
                // 用id取班级
                Element e = (Element) n1.item(i);
                String n = e.getAttribute("id");
                System.out.println("班级是：" + n);
                NodeList childList = doc.getElementsByTagName("name1");
                Node elementNode = childList.item(i);
                Node textNode = elementNode.getFirstChild();
                String no = textNode.getNodeValue();

                System.out.println("名字是:" + no);

                NodeList childList1 = doc.getElementsByTagName("name2");
                Node elementNode1 = childList1.item(i);
                Node textNode1 = elementNode1.getFirstChild();
                String no1 = textNode1.getNodeValue();
                System.out.println("名字是:" + no1);

                NodeList childList2 = doc.getElementsByTagName("name3");
                Node elementNode2 = childList2.item(i);
                Node textNode2 = elementNode2.getFirstChild();
                String no2 = textNode2.getNodeValue();
                System.out.println("名字是:" + no2);

                NodeList childList3 = doc.getElementsByTagName("name4");
                Node elementNode3 = childList3.item(i);
                Node textNode3 = elementNode3.getFirstChild();
                String no3 = textNode3.getNodeValue();
                System.out.println("班级是：" + n);
                System.out.println("名字是:" + no3);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}





