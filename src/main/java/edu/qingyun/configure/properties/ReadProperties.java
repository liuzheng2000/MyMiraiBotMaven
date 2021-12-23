package edu.qingyun.configure.properties;

import edu.qingyun.MiraiBotTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 实现从配置文件读取内容
 * @author qingyun
 * @date 2021/12/18
 */
public class ReadProperties {

    public Map<String, String> loadResources() {
        //获取主类
        Class<?> miraiBotTestClass = MiraiBotTest.class;
        //主类的加载位置
//        ClassLoader classLoader = miraiBotTestClass.getClassLoader();
//        //获取resource位置
//        URL resourceUrl = classLoader.getResource("application.properties");


        //新建一个配置文件类
        Properties properties = new Properties();
        //读取流的内容
        //Paths.get(resourceUrl.toURI()  读取配置文件
        try (InputStream stream =  miraiBotTestClass.getResourceAsStream("/application.properties"); Reader reader = new InputStreamReader(stream)) {
            properties.load(reader);
        } catch (IOException e  ) {
            e.printStackTrace();
        }

        Map<String, String> resource = new HashMap<>(properties.size());
        // 放入Map
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            resource.put(entry.getKey().toString(), entry.getValue().toString());
        }
        //返回
        return resource;
    }
}
