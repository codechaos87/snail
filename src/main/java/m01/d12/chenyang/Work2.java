/**
 * Project Name:snail
 * File Name:Work2.java
 * Package Name:m01.d12.chenyang
 * Date:2018年1月12日下午2:50:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.chenyang;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:50:23 <br/>
 * 
 * @author chenyang
 * @version
 * @see
 */
public class Work2 {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        // 得到DOM解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 从DOM工厂获取DOM解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        // 解析指定的XML文件
        Document doc = db.parse("D:\\GitHub\\snail\\src\\main\\java\\m01\\d12\\chenyang\\Work1.xml");
        // 得到关于Class节点列表信息
        NodeList classList = doc.getElementsByTagName("Class");
        // 对Class列表循环
        for (int i = 0; i < classList.getLength(); i++) {
            //Class循环下的第i个节点
            
            Element element = (Element)classList.item(i);
            // 获取Class的属性值
            String attrValue = element.getAttribute("id");
            // 得到关于student的节点列表信息
            NodeList students = element.getElementsByTagName("student");
            // 对student列表循环
            for (int j = 0; j < students.getLength(); j++) {
                // NodeList nameList =
                // element.getElementsByTagName("name");
                // Element nameElement = (Element)nameList.item(j);
                // String Sname = nameElement.getFirstChild().getNodeValue();
                System.out.println("学生班级：" + attrValue + "\t姓名："
                        + element.getElementsByTagName("name").item(j).getFirstChild().getNodeValue()/* Sname */
                        + "\t年龄：" + element.getElementsByTagName("age").item(j).getFirstChild().getNodeValue()
                        + "\t性别：" + element.getElementsByTagName("sex").item(j).getFirstChild().getNodeValue());
            }
        }

    }

}
