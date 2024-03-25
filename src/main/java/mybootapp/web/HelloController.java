package mybootapp.web;

import java.io.IOException;
import java.util.Date;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Service("/hello")
public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @PostConstruct
    void init() {
        logger.info("Created hello bean");
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning hello view");
        return new ModelAndView("hello","now",new Date());
    }



}