/**
 * Project Name:snail
 * File Name:Homework2.java
 * Package Name:m01.d10.xuchao
 * Date:2018年1月10日下午6:47:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.xuchao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:47:34 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
class UdpSend {

    public static void main(String[] args) throws Exception {
        BufferedReader bufr = null;
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        ds = new DatagramSocket();
        bufr = new BufferedReader(new FileReader("D:\\git\\dt59lesson\\src\\main\\java\\hm20180106\\Homework3.java"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = bufr.readLine()) != null) {
            sb.append(line);
            sb.append("\r\n");
        }
        byte[] buf = sb.toString().getBytes();
        dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
        ds.send(dp);
        ds.close();
        bufr.close();
    }
}
