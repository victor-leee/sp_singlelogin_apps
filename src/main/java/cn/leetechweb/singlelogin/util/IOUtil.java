package cn.leetechweb.singlelogin.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project Name: single_spot_login
 * Create Time: 2020/10/11 19:58
 *
 * @author junyu lee
 **/
public class IOUtil {
    public static void writeObjectToOutputStream(HttpServletResponse os, Object object) {
        String jsonVal = JSON.toJSONString(object);
        try {
            os.getOutputStream().println(jsonVal);
        }catch (Exception e) {
            System.err.println("IOUtil发生错误");
        }finally {
            try {
                os.getOutputStream().close();
            }catch (IOException e) {
                System.err.println("IOUtil发生错误");
            }
        }
    }
}
