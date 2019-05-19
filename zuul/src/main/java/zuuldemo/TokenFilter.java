package zuuldemo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cong on 2018/5/18.
 */
public class TokenFilter extends ZuulFilter {
    @Value("${server.port}")
    private String serverPort;

    //四种类型：pre,routing,error,post
    //pre：主要用在路由映射的阶段是寻找路由映射表的
    //routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
    //error:一旦前面的过滤器出错了，会调用error过滤器。
    //post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
    @Override
    public String filterType() {
        return "pre";
    }

    //自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //控制过滤器生效不生效，可以在里面写一串逻辑来控制
    @Override
    public boolean shouldFilter() {
        return false;
    }

    //执行过滤逻辑
    @Override
    public Object run() {
        // 1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取 Request
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取token 的时候 从请求头中获取
        String token = request.getParameter("token");
        request.setAttribute("serverPort", serverPort);
        if (StringUtils.isEmpty(token)) {
            // 不会继续执行... 不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("token is null");
            currentContext.setResponseStatusCode(401);
            return null;
            // 返回一个错误提示
        }
        // 正常执行调用其他服务接口...
        System.out.println("网关执行端口号:" + serverPort);
        return null;

    }
}