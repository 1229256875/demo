package com.kx.demo.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author caogj
 * 记录ip登陆和验证用户身份
 */
@Slf4j
@Component
public class SecurityFilter implements Filter, Ordered {


    private SecurityHandler handler;

    public SecurityFilter(SecurityHandler securityHandler) {
        this.handler = securityHandler;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        if (!(request instanceof RequestFacade)) {
            log.error("请求错误:{} {}", request.getParameterMap().toString());
            return;
        }

        RequestFacade requestFacade = (RequestFacade) request;
        ResponseFacade responseFacade = (ResponseFacade) response;

//        if (!requestFacade.getRequestURI().startsWith("/api/")) {
//            chain.doFilter(requestFacade, responseFacade);
//            return;
//        }

        handler.securityManager(requestFacade, responseFacade, chain);
    }

    @Override
    public int getOrder() {
        return -300;
    }
}
