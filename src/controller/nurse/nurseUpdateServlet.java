package controller.user;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/12/2-15:34
 */
@WebServlet("/userUpdate.do")
public class userUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);//加上这句默认去调doGet
        //处理请求编码
        request.setCharacterEncoding("utf-8");
//设置响应编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //上传：
        //判断前台的form是否有multipart属性
//        (因为form有了此字段，不能简单地用getRequest拿数据了）
        try {
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (isMultiPart) {
                //
//                FileItemFactory factory = new DiskFileItemFactory();//接口
                DiskFileItemFactory factory = new DiskFileItemFactory();//加缓冲区。需要将接口变为实现类
                ServletFileUpload upload = new ServletFileUpload(factory);

                //控制上传文件的大小：（对象：ServletFileUpload，在解析文件之前）
                upload.setSizeMax(102400);//单位：字节B

                //通过parseRequest解析form中的所有请求字段，并保存到items集合中
                List<FileItem> items = upload.parseRequest(request);
                //迭代器遍历，取出字段
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    int sno = -1;
                    String sname = null;
                    //无序，需要根据name属性判断字段
                    //先判断是否为普通form表单字段：
                    if (item.isFormField()) {
                        if ("sno".equals(item.getFieldName())) {
                            //getFieldName获取普通表单字段的name值(需要注明编码格式)
                            sno = Integer.parseInt(item.getString("UTF-8"));
                        } else if ("sname".equals(item.getFieldName())) {
                            sname = item.getString("UTF-8");
                        } else {
                            System.out.println("其他字段");
                        }
                    } else {
                        //文件上传处理
                        //文件名：(getName获取文件名)
                        String fileName = item.getName();
                        //限制上传类型：
                        //提取文件后缀名：
                        String ext=fileName.substring(fileName.indexOf(".")+1);//注意方法大小写
                        if(!(("jpg").equals(ext)||("png").equals(ext))){
                            System.out.println("图片类型有误！");
                            return;
                        }//错误信息返回给前端：建立error对象，携带信息发送至前端

                        //获取文件内容并上传：
                        //定义文件路径（指定上传位置）：upload
//                        String path="xxxx";//强烈耦合，建议使用动态地址
                        //获取服务器路径：
                        String path = request.getSession().getServletContext().getRealPath("upload");
                        File file = new File(path, fileName);//输出文件路径

                        //设置上传文件时用到的临时文件的大小（先到缓冲区，再到文件）:（对象：DiskFileItemFactory）
                        factory.setSizeThreshold(10240);//“仓库”
                        //设置临时文件的目录
                        factory.setRepository(new File("F:\\File\\out\\artifacts\\UpAndDown_war_exploded\\uploadtemp"));

                        //上传：
                        item.write(file);
                        System.out.println(fileName + "上传成功！");
                        return;
                    }
                }
            }
        } catch(FileUploadBase.SizeLimitExceededException e) {
            System.out.println("上传文件大小超过限制！");
        }catch(FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
