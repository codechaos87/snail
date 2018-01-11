/**
 * Project Name:snail
 * File Name:TcpClient.java
 * Package Name:m01.d10
 * Date:2018年1月11日上午12:02:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.chenyang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月11日 上午12:02:16 <br/>
 * @author   chenyang
 * @version
 * @see
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {

        Socket s= new Socket("192.168.80.121",10008);
        BufferedReader bufr = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\practice\\Bus.java"));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        String line = null;
        while((line=bufr.readLine())!=null){
            out.println(line);
        }
        out.println("over");
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String lineIn = bufIn.readLine();
        System.out.println(lineIn);
        bufr.close();
        s.close();
    
    }

}

