package com.wolfking.jeesite;


import com.drew.lang.BufferReader;
import com.wolfking.jeesite.modules.sys.service.SystemService;
import net.sf.ehcache.Ehcache;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.cache.ehcache.EhCache;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WolfkingJeesiteTest {
    @Test
    public void password(){
        SystemService systemService = new SystemService();
        String admin = systemService.entryptPassword("admin");
        System.out.println(admin);

    }

    @Test
    public void clearCode() throws Exception{
        String filePath = "D:\\net_code\\wolfking-jeesite\\src\\main\\java\\com\\wolfking";
        File file  = new File(filePath);

        List<File> allFile = new ArrayList<>();

        readFile(file,allFile);
        for(File isFile : allFile){
            System.out.println(isFile.getAbsolutePath());
            createNewFile(isFile);
        }
    }

    private boolean isRemove(String line){
        String[] removeLine = {"@author","@version","Copyright","Created by","create on","the email is"};
        for(String s : removeLine){
            if(line.contains(s)){
                return true;
            }
        }
        return false;
    }

    private void createNewFile(File file) throws Exception{
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        File tempFile = createTmpFile(file);
        String originFilePath = file.getAbsolutePath();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile,true));
        String line ;
        while((line = bufferReader.readLine()) != null){
            System.out.println(line);
            if(!isRemove(line)){
                bufferedWriter.write(line);
            }
        }

        bufferReader.close();
        bufferedWriter.close();
        file.delete();
        tempFile.renameTo(new File(originFilePath));
    }

    public File createTmpFile(File file) throws Exception{
        File filetmp = new File(file.getAbsolutePath()+".copy");
        if(!filetmp.exists()){
            filetmp.createNewFile();
        }
        return filetmp;
    }



    private void readFile(File file,List<File> allFile){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fileSi : files){
                readFile(fileSi,allFile);
            }
        }else{
            allFile.add(file);
        }
    }

}
