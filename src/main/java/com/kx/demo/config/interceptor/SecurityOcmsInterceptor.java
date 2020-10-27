package com.kx.demo.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/10/24 9:13 上午
 */
@Component
public class SecurityOcmsInterceptor implements HandlerInterceptor {
    private static final String IP = "real-ip";
    private static final String TOKEN = "token-";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ip = (String) request.getAttribute(IP);

        Cookie token = WebUtils.getCookie(request, "token");

//        try {
//            verfiy(token, ip);
//        } catch (TokenVerifyException e) {
//            clientSecurityRepository.secIncr(ip);
//            throw new UnauthorizedException("token verfiy error");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }


//    private void verfiy(Cookie cookie, String ip) throws TokenVerifyException {
//
//
//        if (cookie == null || cookie.getValue() == null || cookie.getValue().isEmpty()) {
//            throw new TokenVerifyException("token is null");
//        }
//        String token = cookie.getValue();
//        Map<String, Claim> map = JwtUtil.verfiyToken(token);
//        String str = map.get("user").asString();
//        User user = null;
//        if (str != null && !str.isEmpty()) {
//            user = JSONObject.parseObject(str, User.class);
//        }
//        Integer verfiy = userTokenRepository.verfiy(user.getId(), token);
//        if (verfiy == 1) {
//            throw new TokenVerifyException("token expired");
//        } else if (verfiy == 2) {
//            throw new TokenVerifyException("token out");
//        }
//
//        if (user != null) {
//            userTokenRepository.refreshOToken(token);
//            userTokenRepository.refreshToken(user.getId());
//            userRepository.refreshIp(ip, user.getUsername());
//        } else {
//            throw new TokenVerifyException("token verify error");
//        }
//    }
}
