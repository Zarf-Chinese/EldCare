package util;
import java.io.File;
import java.util.ArrayList;

/**
 * 此类中封装一些常用的文件操作。
 * 所有方法都是静态方法，不需要生成此类的实例，
 * 为避免生成此类的实例，构造方法被申明为private类型的。
 */
/**
 * Author:ShiQi
 * Date:2019/12/3-17:59
 */
public class FileUtil {
    //重命名文件
    public static boolean rename(File file, File newFile){
        File file1=file.getAbsoluteFile();
        System.out.println(file1);
        System.out.println(newFile);
        //如果存在同名文件，则删除
        if(newFile.exists()){
            newFile.delete();
        }
        return file1.renameTo(newFile);
    }
/*  rename测试记录：
//拿到上传的文件：
File file1=file.getAbsoluteFile();
System.out.println(file1);
String newPath=path+"nursePhoto"+id +"."+ ext;
File newFile=new File(newPath);
System.out.println(newFile);
//将原文件更改为f:\a\b.xlsx，其中路径是必要的。注意
System.out.println("是否重命名成功："+file1.renameTo(newFile));*/


        /**
         * 判断指定的文件是否存在。
         * @param fileName 要判断的文件的文件名
         * @return 存在时返回true，否则返回false。
         * @since  1.0
         */
        public static boolean isFileExist(String fileName) {
            return new File(fileName).isFile();
        }

        /**
         * 创建指定的目录。
         * 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
         * <b>注意：可能会在返回false的时候创建部分父目录。</b>
         * @param file 要创建的目录
         * @return 完全创建成功时返回true，否则返回false。
         * @since  1.0
         */
        public static boolean makeDirectory(File file) {
            File parent = file.getParentFile();
            if (parent != null) {
                return parent.mkdirs();
            }
            return false;
        }

        /**
         * 创建指定的目录。
         * 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
         * <b>注意：可能会在返回false的时候创建部分父目录。</b>
         * @param fileName 要创建的目录的目录名
         * @return 完全创建成功时返回true，否则返回false。
         * @since  1.0
         */
        public static boolean makeDirectory(String fileName) {
            File file = new File(fileName);
            return makeDirectory(file);
        }

        /**
         * 列出目录中的所有内容，包括其子目录中的内容。
         * @param file 要列出的目录
         * @param filter 过滤器
         * @return 目录内容的文件数组。
         * @since  1.0
         */
        public static File[] listAll(File file,
                                     javax.swing.filechooser.FileFilter filter) {
            ArrayList list = new ArrayList();
            File[] files;
            if (!file.exists() || file.isFile()) {
                return null;
            }
            file.list();
            files = new File[list.size()];
            list.toArray(files);
            return files;
        }

            /**
         * 从文件路径得到文件名。
         * @param filePath 文件的路径，可以是相对路径也可以是绝对路径
         * @return 对应的文件名
         * @since  1.0
         */
        public static String getFileName(String filePath) {
            File file = new File(filePath);
            return file.getName();
        }

        /**
         * 从文件名得到文件绝对路径。
         * @param fileName 文件名
         * @return 对应的文件路径
         * @since  1.0
         */
        public static String getFilePath(String fileName) {
            File file = new File(fileName);
            return file.getAbsolutePath();
        }

        /**
         * 得到文件的类型。
         * 实际上就是得到文件名中最后一个“.”后面的部分。
         * @param fileName 文件名
         * @return 文件名中的类型部分
         * @since  1.0
         */
        public static String getTypePart(String fileName) {
            int point = fileName.lastIndexOf('.');
            int length = fileName.length();
            if (point == -1 || point == length - 1) {
                return "";
            }
            else {
                return fileName.substring(point + 1, length);
            }
        }

        /**
         * 得到文件的类型。
         * 实际上就是得到文件名中最后一个“.”后面的部分。
         * @param file 文件
         * @return 文件名中的类型部分
         * @since  1.0
         */
        public static String getFileType(File file) {
            return getTypePart(file.getName());
        }

        /**
         * 将文件名中的类型部分去掉。
         * @param filename 文件名
         * @return 去掉类型部分的结果
         * @since  1.0
         */
        public static String trimType(String filename) {
            int index = filename.lastIndexOf(".");
            if (index != -1) {
                return filename.substring(0, index);
            }
            else {
                return filename;
            }
        }

    }
