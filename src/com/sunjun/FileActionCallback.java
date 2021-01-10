package com.sunjun;

import java.io.File;


public abstract class FileActionCallback {
 
    public void delete(File file) {
    };
 
    public void modify(File file) {
    };
 
    public void create(File file){
    	System.out.println("开启文件监控系统");
    };
 
}
