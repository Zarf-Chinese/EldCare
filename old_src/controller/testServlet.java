package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.PicUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/12/3-19:07
 */
@WebServlet("/test.do")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();//加缓冲区。需要将接口变为实现类
        ServletFileUpload upload = new ServletFileUpload(factory);
        //通过parseRequest解析form中的所有请求字段，并保存到items集合中
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //迭代器遍历，取出字段
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            //无序，需要根据name属性判断字段
            //先判断是否为普通form表单字段：
            if (item.isFormField()) {
                //普通表单类型
            } else {
                //文件上传处理
                //文件名：(getName获取文件名)
                String fileName = item.getName();
                //提取文件后缀名：
                String ext=fileName.substring(fileName.indexOf(".")+1);//注意方法大小写
                if(!(("jpg").equals(ext)||("png").equals(ext))){
                    System.out.println("图片类型有误！");
                    return;
                }//错误信息返回给前端：建立error对象，携带信息发送至前端

                //定义文件路径（指定上传位置）：upload
//                        String path="xxxx";//强烈耦合，建议使用动态地址
                String path="F:\\Photo";
                File file = new File(path, fileName);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = new Date();
                String str = sdf.format(time);
                System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss格式化后的输出: " + str);
                String newName = "images\\nursePhoto:" + 1;//+"."+ext;

                //
                try {
                  String result=  PicUtil.upload(request, file,newName);
                  System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
