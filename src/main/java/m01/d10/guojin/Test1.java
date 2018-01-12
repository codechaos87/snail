/**
 * Project Name:dt59homework.guojin
 * File Name:Test1.java
 * Package Name:lesson20180111
 * Date:2018年1月10日下午4:30:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.guojin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午4:30:15 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Test1 {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = null;
        Socket so = null;
        FileOutputStream out = null;
        File file = new File("D:\\逻辑测试\\tit.jfif");
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream put1 = null;
        FileInputStream put = null;
        byte[] b;
        int len = 0;
        try {
            ss = new ServerSocket(6666);
            so = ss.accept();
            put1 = so.getInputStream();
            put = new FileInputStream(file);
            b = new byte[1024];
            out = new FileOutputStream(file);
            len = put1.read(b);
            while (len != -1) {
                // String str = new String(b, 0, len);
                out.write(b, 0, len);

                len = put1.read(b);
            }
        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            if (so != null) {
                try {
                    so.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            if (put != null) {
                try {

                    put.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            Test.print(put1);
            Test.print(out);
        }

    }
}
