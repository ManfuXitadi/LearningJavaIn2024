package basicKnowledge.servletImitate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * web服务器开发团队
 */
public class TomcatService {

    private static HashMap<String, Servlet> servletMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //接收用户请求，根据请求路径调用对应的 Servlet 来完成业务逻辑
        while(true) {
            // 1 接收用户请求路径
            String url = getUserInput();
            // 2 根据请求路径找到对1应的 Servlet
            Servlet servlet = getServlet(url);
            if (servlet == null) {
                System.out.println("输入的url有误，请重新输入~");
                continue;
            }
            // 3 调用Servlet,执行业务逻辑
            servlet.service();
        }
    }

    private static String getUserInput(){
        System.out.println("请输入您需要跳转的网址:");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();
        return url;
    }

    private static Servlet getServlet(String url) throws Exception {
//        // 假设：BookRoomServlet - /bookRoom
//        // 假设：QueryRoomServlet - /queryRoom
//        if(url.equals("/bookRoom")){
//            return new BookRoomServlet();
//        } else if (url.equals("/queryRoom")) {
//            return new QueryRoomServlet();
//        }else {
//            return new NullServlet();
//        }
        if(servletMap.containsKey(url)){
            System.out.println("返回已存在的Servlet，无须创建~");
            return servletMap.get(url);
        }
        // 解析文件
        FileReader reader = new FileReader("D:\\Mycode\\LearningInGithub\\LearningJavaIn2024\\javaweb\\src\\main\\java\\basicKnowledge\\servletImitate\\web.properties");
        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        String className = properties.getProperty(url);
        if(className == null){
            return null;
        }
        // 根据类名称，获取处理请求的Servlet
        System.out.println("新建Servlet");
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Servlet servlet =  (Servlet) obj;
        servletMap.put(url, servlet);
        return servlet;
    }

}
