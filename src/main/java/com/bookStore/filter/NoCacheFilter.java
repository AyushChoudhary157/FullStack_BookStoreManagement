package com.bookStore.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet filter to prevent browser caching of all application pages.
 * This is crucial for security, especially after a user logs out, as it
 * forces the browser to re-request the page from the server instead of
 * displaying a cached version.
 */
@WebFilter(urlPatterns = "/*")
public class NoCacheFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Set headers to prevent caching on all protected pages.
        // This is the most reliable way to prevent the back button issue.
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
        httpResponse.setHeader("Expires", "0"); // Proxies

        // Continue the filter chain
        chain.doFilter(request, response);
    }
}
