package by.kanarski.profito.listeners.request;

import by.kanarski.profito.constants.Parameter;
import by.kanarski.profito.dto.user.UserDto;
import by.kanarski.profito.utils.threadLocal.ThreadLocalUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@WebListener
public class ThreadLocalListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ThreadLocalUtil.destroy();
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        request.setAttribute(Parameter.USER, new UserDto());
        HttpSession session = request.getSession();
    }
}
