package io.herald.grp2springweb.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//Controller-> http request handler like get, post, etc....
@Controller
public class TotalController {

    @GetMapping("/")
    public String firstPage()
    {
        return "index"; //returns index.html page
    }

    @GetMapping("/signup")
    public String signupGet()
    {
        return "signupPage";
    }

    @GetMapping("/login")
    public String loginGet()
    {
        return "loginPage";
    }


    @PostMapping("/loginPost")
    public String loginPost(HttpServletRequest request)
    {
        String username, password;
        //username=request.getParameter("username");
username=request.getParameter("username");
password=request.getParameter("password");


    }



}
