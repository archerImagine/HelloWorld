package com.cisco.cmad;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/login/*")
public class BlogAuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("BlogAuthFilter.destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;
		System.out.println("BlogAuthFilter.doFilter()");
		/*Do Not Check for registration links*/
		if (hreq.getRequestURI().contains("/registration")) {
			chain.doFilter(req, res);
			return;
		}
		// Check if this request is already authenticated in a session
		if (hreq.getSession().getAttribute("user") != null) {
			// Authenitcated user, proceed with the api call
			chain.doFilter(req, res);
			return;
		}
		
		String basicAuthHeader = hreq.getHeader("Authorization");
		if (basicAuthHeader == null) {
			hres.sendError(401, "Unauthenticated");
			return;
		}
		// decode it to a form of Basic username:password
		if (basicAuthHeader != null && basicAuthHeader.startsWith("Basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = basicAuthHeader.substring("Basic".length()).trim();
			String credentials = new String(Base64.decodeBase64(base64Credentials));
			// credentials = username:password
			// Split the user name and password
			String username = credentials.split(":")[0];
			String password = credentials.split(":")[1];
			// HARDCODED USERNAME CHECKING. REPLACE WITH DATABASE BASED
			// VERIFICATION LOGIC
			if (username.equals("admin") && password.equals("admin123")) {
				// User is authenticated.. setup session and proceed
				hreq.getSession().setAttribute("user", username);
				
				chain.doFilter(req, res);
				return;
			}
		}else{
			hres.sendError(401, "Invalid authenitcation details");
			return;
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("BlogAuthFilter.init()");
		
	}

}
