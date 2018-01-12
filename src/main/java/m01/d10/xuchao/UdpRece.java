/**
 * Project Name:snail
 * File Name:Homework.java
 * Package Name:m01.d10.xuchao
 * Date:2018年1月10日下午6:28:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.xuchao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:28:58 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class UdpRece {

    public static void main(String[] args) throws Exception {
        BufferedWriter bfuw = new BufferedWriter(new FileWriter("E:Homework3_copy.txt"));
        DatagramSocket ds = new DatagramSocket(10000);
        byte[] buf = new byte[1024 * 4];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);
        String data = new String(dp.getData(), 0, dp.getLength());
        bfuw.write(data);
        bfuw.close();
        ds.close();

    }
}
