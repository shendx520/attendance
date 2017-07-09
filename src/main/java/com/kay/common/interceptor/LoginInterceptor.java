package com.kay.common.interceptor;

import com.kay.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by kay on 2017/7/9.
 */
public class LoginInterceptor implements HandlerInterceptor{
    /**
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     * todo 1.登录页面放行 2.其他页面获取session判断是否登录
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri=request.getRequestURI();

        if(uri.indexOf("login")>=0) {
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userinfo");
        if (user != null) {
            return true;
        }

        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
