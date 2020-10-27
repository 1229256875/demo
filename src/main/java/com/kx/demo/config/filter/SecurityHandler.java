package com.kx.demo.config.filter;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 安全处理器
 *
 * @author: xiongk@tcsec.com.cn
 * @create: 2018-08-07 10:36
 */
@Component
public class SecurityHandler {

    private static final String LOGON_URL = "/api/login";
    private static final String LOGOUT_URL = "/api/logout";

    private static final String PARAM_NAME_ERROR = "error";


//	@Autowired
//	private ClientSecurityRepository clientSecurityRepository;

    public void securityManager(RequestFacade requestFacade, ResponseFacade responseFacade, FilterChain chain)
            throws IOException, ServletException {
        String url = requestFacade.getRequestURI();
        // TODO can't capture the client's real ip via docker
        String ip = requestFacade.getHeader("X-Real-IP");
        if (ip == null) {
            ip = requestFacade.getRemoteAddr();
        }

        requestFacade.setAttribute("real-ip", ip);

        setHeader(responseFacade, requestFacade);

        // TODO check if the token-error-limit is reach, if reached then block the ip;
//		if (!clientSecurityRepository.isSecurity(ip)) {
//			pushResponse(responseFacade, "IP lock", 403);
//			return;
//		}

        if (!responseFacade.isCommitted()) {
            chain.doFilter(requestFacade, responseFacade);
        }
    }


    private void pushResponse(ResponseFacade response, String body, int state) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(state);
        PrintWriter out = response.getWriter();
        out.write(body);
        out.flush();
        out.close();
    }

    private void setHeader(ResponseFacade responseFacade, RequestFacade requestFacade) {
//        responseFacade.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:3000");
        responseFacade.setHeader("Access-Control-Allow-Origin", requestFacade.getHeader("Origin"));
        responseFacade.setHeader("Access-Control-Allow-Headers", "token, pragma, Origin, X-Requested-With, Content-Type, Accept, Content-Disposition");
        responseFacade.setHeader("Access-Control-Allow-Credentials", "true");
        responseFacade.setHeader("Access-Control-Expose-Headers", "page, per_page,status,total_count, pragma, token, reportFileName, Content-Disposition");
        responseFacade.setHeader("Access-Control-Max-Age", "3600");
        responseFacade.setHeader("Access-Control-Allow-Headers","Access-Control-Allow-Headers");
    }


}
