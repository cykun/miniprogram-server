package com.cyquen.miniprogramserver.filter;

import com.auth0.jwt.interfaces.Claim;
import com.cyquen.miniprogramserver.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = "/*")
public class JwtFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        final String token = request.getHeader("token");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            if (token != null) {
                Map<String, Claim> userData = JwtUtil.verifyToken(token);
                if (userData == null) {
                    response.getWriter().write("token illegal！");
                    return;
                }
                Integer id = userData.get("id").asInt();
                LOGGER.info("userid: {}", id);
                request.setAttribute("id", id);
            }
        }
        filterChain.doFilter(request, response);
    }
}