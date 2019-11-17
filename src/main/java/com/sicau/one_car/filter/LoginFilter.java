package com.sicau.one_car.filter;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.entity.po.User;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description:
 * @author tzw
 * CreateTime 19:59 2019/11/16
 **/
@Order(0)
@WebFilter(urlPatterns = "/unpub/*",filterName ="loginFilter" )
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        //获取session里的user
        HttpSession session=httpServletRequest.getSession();
        User user=(User)session.getAttribute(Const.RoleEnum.USER.getRole());

        if(user!=null){
            //用户登陆过
            filterChain.doFilter(servletRequest,servletResponse);
        }else
        {
            System.out.println("==================");
            //改进  --利用request、response输入输出流向前端返回数据，不是重定向
            httpServletResponse.sendRedirect("/front/error.html");
        }



    }

    @Override
    public void destroy() {

    }
}
