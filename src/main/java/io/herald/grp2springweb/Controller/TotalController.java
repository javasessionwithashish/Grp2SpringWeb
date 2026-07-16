package io.herald.grp2springweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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




}
