package com.wayzim.client;

import com.wayzim.Invocation.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author 14684
 * @create 2020-08-27 10:33
 */
public class HttpClient {

    public String post(String hostname, int port, Invocation invocation) {
        try {
            //1:http连接
            URL url = new URL("http", hostname, port, "/myRpc");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //2:发送消息
            OutputStream os = connection.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            os.flush();

            //3:获取远程调用结果
            InputStream inputStream = connection.getInputStream();
            String result = IOUtils.toString(inputStream);
            inputStream.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
