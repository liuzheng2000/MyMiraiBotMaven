package edu.qingyun.HttpUtils;




import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author qingyun
 * @date 2021/12/13
 */
public class HttpUtilsClient {

    /**
     * 实例化 HttpClient 对象
     */
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
//            .proxy(ProxySelector.of(new InetSocketAddress("161.35.4.201", 80)))
//            .authenticator(Authenticator.getDefault())
            .build();




    /**
     * 发送Http2请求Get请求
     * 异步请求 返回Body对象
     */
    public String SendHttp2Get(String url)  {
        String result = new String();
        try{
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .setHeader("User-Agent", "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")   // add request header  添加头信息
                    .GET()
                    .build();

//            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());  //同步执行
//            result = response.body();
            CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());  // 异步执行
            result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        }catch (Exception e){
            e.printStackTrace();
        }
//        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
//        System.out.println(response.statusCode());
//        System.out.println(result);
        return result;
    }






    /**
     * @param url  发送的Url
     * @param Body 发送的请求对象  JSON格式
     * @return 返回主题内容
     * 发送Http2请求Get请求
     * 异步请求 返回Body对象
     */
    public String SendHttp2PostGson(String url , String Body)  {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(Body))
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;   //返回对象
        try{
            response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());
        return response.body();
    }


    // Sample: 'password=123&custom=secret&username=abc&ts=1570704369823'
    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }


    /**
     * @param url  发送的Url
     * @param Body 发送的请求对象  Map参数  Form格式
     * @return 返回主题内容
     * 发送Http2请求Post请求
     * 异步请求 返回Body对象
     */
    public String SendHttp2PostFormData(String url , Map Body)  {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(ofFormData(Body))
                .uri(URI.create(url))
                .setHeader("Content-Type", "application/x-www-form-urlencoded") // add request header
                .header("Content-Type", "application/octet-stream")//
                .build();
        HttpResponse<String> response = null;   //返回对象
        try{
            response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());
        return response.body();
    }






    /**
     * 通过URl获取InPutStream
     * @param url
     * @return
     */
    public InputStream GetPictureInPutStreamByUrl(String url){
        InputStream inputStream = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try{
            CompletableFuture<HttpResponse<InputStream>> httpResponseCompletableFuture = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream());// 异步执行
            inputStream = httpResponseCompletableFuture.thenApply(HttpResponse::body).get(120, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }


//    Connection lost, reconnecting... (HeartbeatFailedException: AliveHeartbeat, recoverable=true, cause=PacketTimeoutException(message=Timeout receiving Heartbeat response, cause=kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 5000 ms))

    // 测试运行
//    public static void main(String[] args) throws NoSuchAlgorithmException, URISyntaxException, IOException, InterruptedException, ExecutionException, TimeoutException {
//        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
//        for (int i = 0; i < 100; i++) {
//            httpUtilsClient.SendHttp2Get("https://ak-data-2.sapk.ch/api/v2/pl4/search_player/ws?limit=20");
//        }
//    }

}
