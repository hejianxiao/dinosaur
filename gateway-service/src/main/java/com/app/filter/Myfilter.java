package com.app.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 创建人: Hjx
 * Date: 2018/6/21
 * Description:
 */
@Component
public class Myfilter extends ZuulFilter {


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");

        String uri = request.getRequestURI();
        if (uri.startsWith("/api")) {
            if (accessToken == null) {
                System.out.println("打印日志：token is empty.");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("token is empty.");
                } catch (Exception e) {
                    return null;
                }
            }
        }
        System.out.println("打印日志：OK.");
        return null;
    }
}
