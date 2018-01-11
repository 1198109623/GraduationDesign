package com.hand.movie.utils;

import com.hand.movie.bean.Movie;

import java.io.File;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageByte {

    //从数据库获取图片到本地项目
    public void getImageFromDB(Movie movie, ImageByte imageByte) throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();//项目位置

        imageByte.byte2image(movie.getPicture(),courseFile+"/src/main/webapp/static/picture/fromDB/"+movie.getMovieId()+".jpg");
    }
    //从本地将图片取出并转换为byte数组,进而存入数据库中电影的图片属性
    public byte[] setImageToByte(ImageByte imageByte,String imageName) throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();//项目位置

        byte[] data = imageByte.image2byte("D:\\学习笔记和源码\\毕设\\MovieOrder\\src\\main\\webapp\\static\\picture\\toDB\\"+imageName);
        return data;
    }

    //图片到byte数组
    public byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
    //byte数组转换为图片
    public void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }


}
