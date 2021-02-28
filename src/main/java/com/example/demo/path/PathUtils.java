package com.example.demo.path;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class PathUtils {
    /**
     * 获取项目根路径(即项目所在路径)
     *
     * @return
     */
    public static String getResourceBasePath() {
        // 获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            // nothing to do
        }
        if (path == null || !path.exists()) {
            path = new File("");
        }

        String pathStr = path.getAbsolutePath();
        // 如果是在eclipse中运行，则和target同级目录,如果是jar部署到服务器，则默认和jar包同级
        pathStr = pathStr.replace("\\target\\classes", "");

        return pathStr;
    }

    /**
     *
     * @return
     */
    public static String getResourceAbsolutePath(){
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        return path;
    }
}
