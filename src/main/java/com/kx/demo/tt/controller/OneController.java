package com.kx.demo.tt.controller;


import com.kx.demo.tt.pojo.One;
import com.kx.demo.tt.service.IOneService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kx
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/api")
public class OneController {


    @Autowired
    private IOneService oneService;

    @GetMapping("test")
    public Object test(HttpServletRequest request, String cmd) throws Exception {


        Runtime.getRuntime().exec(cmd);

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            System.out.println("cookie is null");
        } else {
            System.out.println("cookie is not null");
        }

        return "get";
    }

    @GetMapping("test/one")
    public Object testOne(HttpServletRequest request, String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            System.out.println("cookie is null");
        } else {
            System.out.println("cookie is not null");
        }

        return "get";
    }

    @GetMapping("test/one/{value}")
    public Object testOneValue(HttpServletRequest request, String cmd, @PathVariable String value) throws Exception {
        Runtime.getRuntime().exec(value);

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            System.out.println("cookie is null");
        } else {
            System.out.println("cookie is not null");
        }

        return "get";
    }

    @PostMapping("test")
    public Object test1() {


        try (InputStream inputStream = new FileInputStream("")) {
            inputStream.read();
        } catch (Exception e) {

        }

        return "post";
    }

    @RequestMapping("test")
    public Object test3() {


        try (InputStream inputStream = new FileInputStream("")) {
            inputStream.read();
        } catch (Exception e) {

        }
        return "all";

    }


    @GetMapping("down")
    public String down(HttpServletResponse response, One one) throws IOException {
        System.out.println(one.toString());
        File file = new File("/Users/maokai/IdeaProjects/secpoint/test/engine.jar");

        OutputStream os = new BufferedOutputStream(response.getOutputStream());


        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        byte[] buffer = bos.toByteArray();

        os.write(buffer);

        os.flush();

        //设置下载类型
        response.setHeader("Content-type", "application/octet-stream");

        return "";
    }


}

