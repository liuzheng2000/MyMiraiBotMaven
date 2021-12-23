package LoliconAPiTest;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HttpTest {

    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
//            .proxy(ProxySelector.of(new InetSocketAddress("81.68.226.200", 7890)))
//            .authenticator(Authenticator.getDefault())
            .build();



    public InputStream GetPictureInPutStreamByUrl(String url){
        InputStream inputStream = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try{
            CompletableFuture<HttpResponse<InputStream>> httpResponseCompletableFuture = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream());// 异步执行
            inputStream = httpResponseCompletableFuture.thenApply(HttpResponse::body).get(60, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void main(String[] args) {
        HttpTest httpTest = new HttpTest();
        InputStream inputStream = httpTest.GetPictureInPutStreamByUrl("https://i.pixiv.cat/img-original/img/2021/07/30/11/58/27/91595077_p0.png");

        System.out.println(inputStream);
    }
}
