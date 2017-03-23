package org.mybatis.generator.plugins.comment;

import org.apache.commons.lang3.StringUtils;

import javax.tools.*;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by v-taohuang on 2016/12/30.
 */
public class DynamicCompilerUtil {

    /**
     * 编译java文件
     *
     * @param filePath
     *            文件或者目录（若为目录，自动递归编译）
     * @param sourceDir
     *            java源文件存放目录
     * @param targetDir
     *            编译后class类文件存放目录
     * @param diagnostics
     *            存放编译过程中的错误信息
     * @return
     * @throws Exception
     */
    public static boolean compiler(String filePath, String sourceDir, String targetDir, DiagnosticCollector<JavaFileObject> diagnostics)
            throws Exception {
        // 获取编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 获取标准文件管理器实例
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        try {
            if (StringUtils.isEmpty(filePath) && StringUtils.isEmpty(sourceDir) && StringUtils.isEmpty(targetDir)) {
                return false;
            }
            // 得到filePath目录下的所有java源文件
            File sourceFile = new File(filePath);
            List<File> sourceFileList = new ArrayList<File>();
            getSourceFiles(sourceFile, sourceFileList);
            // 没有java文件，直接返回
            if (sourceFileList.size() == 0) {
                System.out.println(filePath + "目录下查找不到任何java文件");
                return false;
            }
            // 获取要编译的编译单元
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
            /**
             * 编译选项，在编译java文件时，编译程序会自动的去寻找java文件引用的其他的java源文件或者class。 -sourcepath选项就是定义java源文件的查找目录， -classpath选项就是定义class文件的查找目录。
             */
            Iterable<String> options = Arrays.asList("-d", targetDir, "-sourcepath", sourceDir);
            JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);
            // 运行编译任务
            return compilationTask.call();
        } finally {
            fileManager.close();
        }
    }

    /**
     * 查找该目录下的所有的java文件
     *
     * @param sourceFile
     * @param sourceFileList
     * @throws Exception
     */
    private static void getSourceFiles(File sourceFile, List<File> sourceFileList) throws Exception {
        if (sourceFile.exists() && sourceFileList != null) {// 文件或者目录必须存在
            if (sourceFile.isDirectory()) {// 若file对象为目录
                // 得到该目录下以.java结尾的文件或者目录
                File[] childrenFiles = sourceFile.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory()) {
                            return true;
                        } else {
                            String name = pathname.getName();
                            return name.endsWith(".java") ? true : false;
                        }
                    }
                });
                // 递归调用
                for (File childFile : childrenFiles) {
                    getSourceFiles(childFile, sourceFileList);
                }
            } else {// 若file对象为文件
                sourceFileList.add(sourceFile);
            }
        }
    }
    public static String java(String packPath){
        URL[] urls = null;
        try {
            //类路径,url的本地文件格式需要加file:/
            urls = new URL[] {new URL("file:/"+ new File("").getAbsolutePath().replaceAll("\\\\","/") + "/src/")};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //类加载器
        URLClassLoader url = new URLClassLoader(urls);
        Class clazz = null;
        String var = "";
        try {
            //加载到内存
            clazz = url.loadClass(packPath);
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Class<?> fldType = field.getType();
                String fldName = field.getName();
                fldName = fldName.toUpperCase().substring(0, 1)+fldName.substring(1);
                if (!"SerialVersionUID".equals(fldName)){
                    if (fldType == String.class){
                        var += "\t\t\t\tif(StringUtils.isNotBlank(record.get"+fldName+"())){\r\n" +
                                "\t\t\t\t\tcriteria.and"+fldName+"EqualTo(record.get"+fldName+"());\r\n" +
                                "\t\t\t\t}\r\n" ;
                    } else {
                        var += "\t\t\t\tif(null != record.get"+fldName+"()){\r\n" +
                                "\t\t\t\t\tcriteria.and"+fldName+"EqualTo(record.get"+fldName+"());\r\n" +
                                "\t\t\t\t}\r\n" ;
                    }
                }
            }
            //实例化对象
            clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return var;
    }
    public static void main(String[] args) {
        try {
            // 编译F:\\亚信工作\\SDL文件\\sdl\\src目录下的所有java文件
            String filePath = "F:\\亚信工作\\SDL文件\\sdl\\src";
            String sourceDir = "F:\\亚信工作\\SDL文件\\sdl\\src";
            String targetDir = "F:\\亚信工作\\SDL文件\\sdl\\classes";
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            boolean compilerResult = compiler(filePath, sourceDir, targetDir, diagnostics);
            if (compilerResult) {
                System.out.println("编译成功");
            } else {
                System.out.println("编译失败");
                for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
                    // System.out.format("%s[line %d column %d]-->%s%n", diagnostic.getKind(), diagnostic.getLineNumber(),
                    // diagnostic.getColumnNumber(),
                    // diagnostic.getMessage(null));
                    System.out.println(diagnostic.getMessage(null));
                }
            }
            loadClassFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadClassFile(String filePath) throws Exception {
        File clazzPath = new File(filePath);
        // 记录加载.class文件的数量
        int clazzCount = 0;

        if (clazzPath.exists() && clazzPath.isDirectory()) {
            // 获取路径长度
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;

            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);

            // 遍历类路径
            while (stack.isEmpty() == false) {
                File path = stack.pop();
                File[] classFiles = path.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        return pathname.isDirectory() || pathname.getName().endsWith(".class");
                    }
                });
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            boolean accessible = method.isAccessible();
                            try {
                                if (accessible == false) {
                                    method.setAccessible(true);
                                }
                                // 设置类加载器
                                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                                // 将当前类路径加入到类加载器中
                                method.invoke(classLoader, clazzPath.toURI().toURL());
                            } finally {
                                method.setAccessible(accessible);
                            }
                        }
                        // 文件名称
                        String className = subFile.getAbsolutePath();
                        int index = className.indexOf("com");
                        String clzzName = className.substring(className.indexOf("com"),className.length()-6).replaceAll("\\\\",".");
                        String cName = className.substring(clazzPathLen,className.length()-6);
                        // 加载Class类
                        Class.forName(clzzName);

                    }
                }
            }
        }
    }
}
