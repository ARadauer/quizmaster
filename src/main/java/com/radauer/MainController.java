package com.radauer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController
{

    @RequestMapping("/page/**") public ModelAndView anyPage(HttpServletRequest request, HttpServletResponse response)
    {
        return new ModelAndView("index");
    }

    @RequestMapping("**/*.html") public ModelAndView handle(HttpServletRequest request)
    {
        String requestURI = request.getServletPath();
        String viewName = requestURI.substring(1, requestURI.length() - 5);
        return new ModelAndView(viewName);
    }

    @RequestMapping(value = {"/index", "/"})
    public String index()
    {
        return "index";
    }
}
