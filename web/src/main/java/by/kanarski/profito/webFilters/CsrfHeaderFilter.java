package by.kanarski.profito.webFilters;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public class CsrfHeaderFilter extends OncePerRequestFilter {

    private static final String CSRF_TOKEN_NAME = "X-CSRF-TOKEN";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
            Cookie cookie = WebUtils.getCookie(request, CSRF_TOKEN_NAME);
            String token = csrf.getToken();
            if (cookie == null || token != null && !token.equals(cookie.getValue())) {
                cookie = new Cookie(CSRF_TOKEN_NAME, token);
                response.addCookie(cookie);
            }
        }
        filterChain.doFilter(request, response);
    }
}
