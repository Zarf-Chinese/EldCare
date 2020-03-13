package controller.nurse;

import entity.Nurse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.INurService;
import service.NurServiceImpl;
import util.FileUtil;
import util.FixNameUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static java.lang.String.valueOf;

/**
 * Author:ShiQi
 * Date:2019/12/2-15:34
 */
@WebServlet("/nurseUpdate.do")
public class nurseUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);//加上这句默认去调doGet
        //处理请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //设置返回页格式：
        response.setHeader("content-type", "text/html;charset=utf-8");

        int id = -1;
        String nurPh = "-1";
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
                upload.setSizeMax(307200);//单位：字节B

                //通过parseRequest解析form中的所有请求字段，并保存到items集合中
                List<FileItem> items = upload.parseRequest(request);
                //迭代器遍历，取出字段
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    //无序，需要根据name属性判断字段
                    //先判断是否为普通form表单字段：
                    if (item.isFormField()) {
                        if ("id".equals(item.getFieldName())) {
                            //getFieldName获取普通表单字段的name值(需要注明编码格式)
                            id = Integer.parseInt(item.getString("UTF-8"));
                        /*} else if ("sname".equals(item.getFieldName())) {
                            sname = item.getString("UTF-8");*/
                        } else {
                            System.out.println("其他字段");
                        }
                    } else {
                        //文件上传处理
                        //文件名：(getName获取文件名)
                        String fileName = item.getName();
                        //限制上传类型：
                        //提取文件后缀名：
                        String ext = fileName.substring(fileName.indexOf(".") + 1);//注意方法大小写
                        if (!(("jpg").equals(ext) || ("png").equals(ext))) {
                            System.out.println("图片类型有误！");
                            return;
                        }//错误信息返回给前端：建立error对象，携带信息发送至前端

                        //类加载器获取配置文件中路径信息
                        Properties p=new Properties();
                        p.load(nurseUpdateServlet.class.getClassLoader().getResourceAsStream("config.properties"));

                        //获取文件内容并上传：
                        //定义文件路径（指定上传位置）：upload
//                        String path="xxxx";//强烈耦合，建议使用动态地址
                        String path = p.getProperty("imagePath");
//                        String path = "F:\\File\\computerscience\\IdeaWorkSpace\\EldCare\\web\\images\\";
                        //获取服务器路径：
//                        String path = request.getSession().getServletContext().getRealPath("image");
                        //F:\File\computerscience\IdeaWorkSpace\EldCare\out\artifacts\EldCare\res
                        File file = new File(path, fileName);//输出文件路径

                        /*//设置上传文件时用到的临时文件的大小（先到缓冲区，再到文件）:（对象：DiskFileItemFactory）
                        factory.setSizeThreshold(10240);//“仓库”
                        //设置临时文件的目录
                        factory.setRepository(new File("F:\\File\\out\\artifacts\\UpAndDown_war_exploded\\uploadtemp"));*/

                        //上传：
                        item.write(file);
                        //重命名：
                        File newFile=new File(path+"\\nursePhoto"+id +"."+ ext);
                        System.out.println("是否重命名成功："+ FileUtil.rename(file,newFile));
                        //将名称存储在数据库中：
                        nurPh = "nursePhoto"+id +"."+ ext;
                    }
                }
            }
        } catch (FileUploadBase.SizeLimitExceededException e) {
            System.out.println("上传文件大小超过限制！");
            response.getWriter().write("<script  type='text/javascript'>alert('上传文件大小超过限制！');window.location.href='test.html'</script>");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Nurse nurse = new Nurse(id, nurPh);
        INurService ss = new NurServiceImpl();
        boolean result = ss.nurUpdate(nurse);

        if (result) {
            response.getWriter().write("<script  type='text/javascript'>alert('上传成功!');window.location.href='nurShowCom.do'</script>");
//            response.getWriter().write("<script  type='text/javascript'>alert('上传成功!');window.location.href='nurShowCom.do'</script>");
            //跳转至其他页面
        } else {
            response.getWriter().write("<script  type='text/javascript'>alert('上传失败，系统错误');window.location.href='test.html'</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
