package com.cralor.chap52eureka.eurekazuulclient.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import org.slf4j.LoggerFactory;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log=LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre"; //定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0;//定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() throws ZuulException {
        //filter需要执行的具体操作
        RequestContext cxk = RequestContext.getCurrentContext();
        HttpServletRequest request = cxk.getRequest();
        String token = request.getParameter("token");
        System.out.println(token);
        if(token==null){
            log.warn("token is empty");
            cxk.setSendZuulResponse(false);
            cxk.setResponseStatusCode(401);
            try {
                cxk.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}