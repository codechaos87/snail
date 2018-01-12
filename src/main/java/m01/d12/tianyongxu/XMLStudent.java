/**
 * Project Name:snail
 * File Name:XMLStudent.java
 * Package Name:m01.d12.tianyongxu
 * Date:2018年1月12日下午4:20:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.tianyongxu;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description:   <br/>
 * Date:     2018年1月12日 下午4:20:48 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class XMLStudent {

    public static void main(String[] args) {
        long lasting = System.currentTimeMillis();
        
        try {
            File file = new File("D:\\workspace\\Practice\\src\\studlist.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            NodeList nl=document.getElementsByTagName("student");
            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println("姓名"+document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
                System.out.println("年龄"+document.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        } catch (SAXException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        System.out.println("运行时间"+(System.currentTimeMillis()-lasting)+"毫秒");
    }

}

