package ru.redguy.reduhc.utils;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import ru.redguy.reduhc.RedUHC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtils {
    public static void Get(String path, Map<String, Object> params) throws IOException {
        Request request = new Request.Builder().url(path + buildGet(params)).get().build();

        Response response = RedUHC.Instance.okHttpClient.newCall(request).execute();
    }

    public static void Post(String path, String body, Map<String, Object> params) throws IOException {
        RequestBody rb = RequestBody.create(body, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder().url(path + buildGet(params)).post(rb).build();

        Response response = RedUHC.Instance.okHttpClient.newCall(request).execute();
    }

    public static String buildGet(Map<String,Object> args) {
        if(args == null) {
            return "";
        } else {
            return ("?" + buildPost(args));
        }
    }

    public static String buildPost(Map<String, Object> args) {
        if (args == null) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            args.forEach((name, value) -> {
                try {
                    stringBuilder.append(URLEncoder.encode(name, "UTF-8")).append('=').append(URLEncoder.encode(String.valueOf(value), "UTF-8")).append('&');
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });
            String strResult = stringBuilder.toString();
            return !strResult.isEmpty()
                    ? stringBuilder.substring(0, stringBuilder.length() - 1)
                    : strResult;
        }
    }
}
