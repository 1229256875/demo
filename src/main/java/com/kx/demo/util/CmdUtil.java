package com.kx.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/6/24 7:39 下午
 */
@Slf4j
public class CmdUtil {


    /**
     * 执行cmd
     */
    public static String exeCmd(String cmd) {

        log.info("\nexecute cmd : " + cmd);
        BufferedReader bf = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            Process exec = Runtime.getRuntime().exec(cmd);
            processBuilder.redirectErrorStream(true);
            bf = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = bf.readLine()) != null) {
                sb.append(line + "\n");
            }
            log.info("\nexecute cmd success");
            return sb.toString();
        } catch (Exception e) {
            log.info("\nexecute cmd not success :" + e);
            return "";
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {

                }
            }
        }
    }

    //todo: 加锁的必要性。。。。需详细了解
    public static synchronized String cmd(String cmd) {
        log.info("\nexecute time{}: \ncmd: {}", new Date(), cmd);
        CommandLine cmdLine = CommandLine.parse(cmd);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValues(null);
        ExecuteWatchdog watchdog = new ExecuteWatchdog(6000000);
        executor.setWatchdog(watchdog);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);

        executor.setStreamHandler(streamHandler);
        try {
            executor.execute(cmdLine);
            String out = outputStream.toString("gbk");//获取程序外部程序执行结果
            String error = errorStream.toString("gbk");
            if (!out.isEmpty()) {
                log.info("execute cmd Success");
            }
            if (!error.isEmpty()) {
                log.info("execute cmd not Success");
            }
            return out;
        } catch (IOException e) {
            log.info("execute cmd not success :" + e);
        }
        return null;
    }

}
