package com.bzs.service.Impl;

import com.bzs.service.FileWriterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("fileWriterService")
public class FileWriterServiceImpl implements FileWriterService {

    @Value("${filePath}")
    private File file;
    private FileWriter fw;

    @PostConstruct
    public void init() {
        try {
            if (!file.exists()) {

                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            System.out.print("成功打开文件\n");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void write(String context) {
        try {
            fw.write(context + "\n");
            System.out.println("正在写入文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destory() {
        if (fw != null) {
            try {
                fw.flush();

                fw.close();
                System.out.print("正在关闭文件");
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}