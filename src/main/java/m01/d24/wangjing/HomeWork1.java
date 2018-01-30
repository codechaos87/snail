/**
 * Project Name:NewLife
 * File Name:HomeWork1.java
 * Package Name:a_002
 * Date:2018��1��24������8:12:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.wangjing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description: <br/>
 * Date: 2018��1��24�� ����8:12:56 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class HomeWork1 {

    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        int c = 0;
        try {
            fr = new FileReader("d:\\wangjing3.txt");
            fw = new FileWriter("e:\\wangjing.txt");
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            fw.close();
            System.out.println("�������");
        } catch (FileNotFoundException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
