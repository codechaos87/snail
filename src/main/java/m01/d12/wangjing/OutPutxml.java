/**
 * Project Name:snail
 * File Name:OutPutxml.java
 * Package Name:m01.d11.wangjing
 * Date:2018年1月12日下午2:45:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.wangjing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:45:04 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class OutPutxml {

    public static void main(String[] args) throws DOMException {

        long lasting = System.currentTimeMillis();
        try {
            File f = new File("D:\\git\\snail\\lib\\ClassInfor.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(f);
            NodeList nl = doc.getElementsByTagName("student");
            for (int i = 0; i < nl.getLength(); i++) {
                System.out.print("姓名:" + doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue() + " ");
                System.out.println("年龄:" + doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
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
        System.out.println("运行时间" + (System.currentTimeMillis() - lasting) + "毫秒");

    }
}
