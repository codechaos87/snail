/**
 * Project Name:snail
 * File Name:FilereaderDemo.java
 * Package Name:m01.d24.tianyongxu
 * Date:2018年1月24日下午7:31:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.tianyongxu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午7:31:31 <br/>
 * 
 * @author tianyongxu
 * @version
 * @see
 */
public class FilereaderDemo {

    public static void main(String[] args) {
        File file = new File("D:\\tianyongxu.txt");
        File file1 = new File("E:\\tianyongxu1.txt");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw =  null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            fw =new FileWriter(file1);
            bw=new BufferedWriter(fw);
            String str=null;
            while((str=br.readLine())!=null){
                bw.write(str+"\r\n");
            }
            System.out.println("复制完成");
        } catch (FileNotFoundException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }finally{
            try {
                bw.close();
                fw.close();
                br.close();
                fr.close();
            } catch (IOException e) {

                e.printStackTrace();
                
            }
            
        }
    }

}
