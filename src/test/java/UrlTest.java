import net.mamoe.mirai.contact.Contact;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL urlFile = new URL("https://qingyun-test.oss-cn-hangzhou.aliyuncs.com/QueHun/1149278.png");
        InputStream inputStream = urlFile.openStream();
        System.out.println(inputStream);
    }
}
