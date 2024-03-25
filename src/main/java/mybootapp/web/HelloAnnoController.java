package mybootapp.web;

import java.util.Date;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @GetMapping("/welcome")
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("hello", "now", now);
    }

    @GetMapping("/counter")
    public ModelAndView getCounterPage(HttpSession session){
        int counter;
        System.out.println(session.getAttribute("counter"));
        if(session.getAttribute("counter") == null) {
            counter = 1;
            session.setAttribute("counter",counter);
        }else {
            counter = (int) session.getAttribute("counter");
            counter++;
            session.setAttribute("counter",counter);
        }

        return new ModelAndView("counter","counter",counter);
    }

    @GetMapping("/plus10")
    public ModelAndView plus10(@RequestParam(value = "num",defaultValue = "100") Integer value,@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        logger.info("Running plus10 controller with param: "+value);
        System.out.println(date);
        return new ModelAndView("hello","now",value+10);
    }

    @GetMapping("/voir/{param}")
    public ModelAndView voir(@PathVariable("param") Integer param) {
        logger.info("Running param controler with param=" + param);
        return new ModelAndView("hello", "now", param);
    }

    @GetMapping("/voir/{param}/{param2}")
    public ModelAndView voir2(@PathVariable("param") Integer param,@PathVariable("param2") String param2) {
        logger.info("Running param controler with param=" + param);
        return new ModelAndView("hello", "now", param+param2);
    }

    @GetMapping("/matrix/{param}")
    @ResponseBody
    public String testMatrix(
                             @PathVariable("param") String param,
                             @MatrixVariable(name = "a", defaultValue = "A") String a,
                             @MatrixVariable(name = "b", defaultValue = "1") Integer b
    ) {
        return String.format("param=%s, a=%s, b=%d", param, a, b);
    }

    // http://localhost:8081/tests/matrix/hello/hello;a=%7B%22test%22:%22test%22%7D;b=ffdd;c=12
    @GetMapping("/matrix/{param1}/{param2}")
    @ResponseBody
    public String testMatrixMap(
            @MatrixVariable Map<String,String> a
    ) {
        return String.format(a.keySet().stream().toList().toString());
    }
}