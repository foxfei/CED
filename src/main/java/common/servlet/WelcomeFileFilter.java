package common.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 发现是项目根目录如 
 * http://server:port/app 
 * http://server:port/app/ 
 * 则导向到
 * http://server:port/app/Home.action 
 * 这个过滤器需要放在s2filter之前
 * @author wangliang_gz@qq.com
 */
public class WelcomeFileFilter implements Filter {
	public void destroy() {
		indexFile = null;
	}

	private String indexFile;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//String servletPath = httpServletRequest.getServletPath();
		String contextPath = httpServletRequest.getContextPath();
		String requestURI = httpServletRequest.getRequestURI();
		//System.out.println(requestURI);
		//System.out.println(contextPath);
		if (contextPath.equalsIgnoreCase(requestURI) || (contextPath+"/").equalsIgnoreCase(requestURI)) {
			String url = "";
			if(indexFile.startsWith("/")){
				url = contextPath + indexFile;
			}else{
				url = contextPath +"/" +indexFile;
			}
			httpServletResponse.sendRedirect(url);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		indexFile = "Home.action";
		String x = arg0.getInitParameter("indexFile");
		if (StringUtils.isNotBlank(x)) {
			indexFile = x;
		}
	}

}
