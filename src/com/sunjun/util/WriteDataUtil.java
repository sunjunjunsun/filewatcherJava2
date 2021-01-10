package com.sunjun.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteDataUtil {
	public static void writeSn(String text, String strings) {
		String formatStr = new SimpleDateFormat("MMdd").format(new Date());
		String parentPath="\\\\172.26.12.16\\aoi\\5DX\\5DX不良\\"+ strings +"\\" +formatStr;
		if(!new File(parentPath).exists()) {
			new File(parentPath).mkdirs();
		}
		File file=new File(parentPath+"\\PassSnDetail.txt");
    	 try {
			FileOutputStream fos=new FileOutputStream(file,true);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
		    bw.write(text.toUpperCase()+ " Pass time "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"\r\n");
			bw.close();
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
