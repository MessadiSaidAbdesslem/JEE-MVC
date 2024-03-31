package mybootapp.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/counter")
public class CounterController {
    @GetMapping("")
    public ModelAndView showCounter(//
                                    @SessionAttribute(required = false, name = "counter") CounterBean counter) {
        return new ModelAndView("counter2", "counter", counter);
    }

    @GetMapping("/init")
    public ModelAndView init(HttpSession session) {
        var counter = new CounterBean();
        session.setAttribute("counter", counter);
        return new ModelAndView("counter2", "counter", counter);
    }

    @GetMapping("/inc")
    public ModelAndView incCounter(@SessionAttribute("counter") CounterBean counter) {
        counter.setValue(counter.getValue() + 1);
        return new ModelAndView("counter2", "counter", counter);
    }
}
