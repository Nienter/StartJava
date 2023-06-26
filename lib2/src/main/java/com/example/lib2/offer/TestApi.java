package com.example.lib2.offer;

import com.example.lib2.ReqType;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import netscape.javascript.JSObject;

public class TestApi {
    public static void main(String[] args) {
        new TestApi().testApi();
    }

    private void testApi() {
        IReqApi api = create(IReqApi.class);
        String s = api.login("niu@victurbo.com", "edfdg");
        System.out.println(s);
    }

    @SuppressWarnings("unchecked")
    private <T> T create(Class<IReqApi> iReqApiClass) {
        return (T) Proxy.newProxyInstance(iReqApiClass.getClassLoader(), new Class[]{iReqApiClass},
                (proxy, method, args) -> {
                    ReqType reqType = method.getAnnotation(ReqType.class);
                    ReqUrl reqUrl = method.getAnnotation(ReqUrl.class);
                    Type[] parameterTypes = method.getGenericParameterTypes();
                    Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();
                    ReqParam reqParam;
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 0; i < parameterAnnotationsArray.length; i++) {
                        Annotation[] annotations = parameterAnnotationsArray[i];
                        if (annotations != null) {
                            reqParam = (ReqParam) annotations[0];
//                            jsonObject.put(reqParam.value(), args[i]);
                            System.out.println("reqParam---reqParam->" + reqParam.value() + "==" + args[i]);
                        }
                    }
//                    jsonObject.put("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6InN4cy00ZjFnMjNhMTJhYSJ9.eyJpc3MiOiJkZXZpbnplbmciLCJqdGkiOiJzeHMtNGYxZzIzYTEyYWEiLCJpYXQiOjE2NTcyNjQ3MDksImV4cCI6MTY1NzM1MTEwOSwiZW1haWwiOiJuaXVAdmljdHVyYm8uY29tIiwidWlkIjoiNjMiLCJ1c2VybmFtZSI6Im5wayJ9.NAfr85jqdunrx-A5mLmYhqKreFCS2Aq9gQPiwHhkySI");
//                    jsonObject.put("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6InN4cy00ZjFnMjNhMTJhYSJ9.eyJpc3MiOiJkZXZpbnplbmciLCJqdGkiOiJzeHMtNGYxZzIzYTEyYWEiLCJpYXQiOjE2NTcyNjQ3MDksImV4cCI6MTY1NzM1MTEwOSwiZW1haWwiOiJuaXVAdmljdHVyYm8uY29tIiwidWlkIjoiNjMiLCJ1c2VybmFtZSI6Im5wayJ9.NAfr85jqdunrx-A5mLmYhqKreFCS2Aq9gQPiwHhkySI");
                    System.out.println(jsonObject.toString());
//                        String body = "{\"email\":\"niu@victurbo.com\",\"passcode\":\"5l4ghv74ewq\"}";

                    URL url = new URL("https://api.vtsys.xyz/rest.php/act/apps/person?page=1&pagesize=20&app_name=&dataType=dev&app_type=&dev_status=");
                    URLConnection urlConnection = url.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty( "Content-Type", "application/json;charset=UTF-8" );
                    httpURLConnection.setRequestProperty("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6InN4cy00ZjFnMjNhMTJhYSJ9.eyJpc3MiOiJkZXZpbnplbmciLCJqdGkiOiJzeHMtNGYxZzIzYTEyYWEiLCJpYXQiOjE2NTcyNjQ3MDksImV4cCI6MTY1NzM1MTEwOSwiZW1haWwiOiJuaXVAdmljdHVyYm8uY29tIiwidWlkIjoiNjMiLCJ1c2VybmFtZSI6Im5wayJ9.NAfr85jqdunrx-A5mLmYhqKreFCS2Aq9gQPiwHhkySI");
                    httpURLConnection.setRequestProperty("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6InN4cy00ZjFnMjNhMTJhYSJ9.eyJpc3MiOiJkZXZpbnplbmciLCJqdGkiOiJzeHMtNGYxZzIzYTEyYWEiLCJpYXQiOjE2NTcyNjQ3MDksImV4cCI6MTY1NzM1MTEwOSwiZW1haWwiOiJuaXVAdmljdHVyYm8uY29tIiwidWlkIjoiNjMiLCJ1c2VybmFtZSI6Im5wayJ9.NAfr85jqdunrx-A5mLmYhqKreFCS2Aq9gQPiwHhkySI");
                    httpURLConnection.setDoInput( true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(jsonObject.toString().getBytes());
                    outputStream.flush();
                    outputStream.close();
                    InputStream in = httpURLConnection.getInputStream();
//                        int count=httpURLConnection.getContentLength();//获取远程资源长度
                    byte[] buffer = new byte[1024];
                    FileOutputStream baos = new FileOutputStream("out.txt");
                    for (int i = 0; (i = in.read(buffer)) > 0;) {
                        baos.write(buffer,0, i);
                    }

                    return String.valueOf(baos.toString());
                });
    }
}


