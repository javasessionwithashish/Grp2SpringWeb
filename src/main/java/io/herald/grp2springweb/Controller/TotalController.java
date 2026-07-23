package io.herald.grp2springweb.Controller;

import io.herald.grp2springweb.Model.UserTable;
import io.herald.grp2springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller-> http request handler like get, post, etc....
@Controller
public class TotalController {

    //Autowired helps in dependency injection, provides all the reqd
    //functions and API's to a class/interface object
    //no new keyword is reqd
   @Autowired
    private UserRepository uRepo ;

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
    public String loginPost(HttpServletRequest request, Model m)
    {
        String username, password;
        //username=request.getParameter("username");
username=request.getParameter("username");
password=request.getParameter("password");

String hashPassword= DigestUtils.md5DigestAsHex(password.getBytes());
        //RepositoryLogin

        if(uRepo.existsByUsernameAndPassword(username,hashPassword))
        {

            HttpSession session= request.getSession();
       //Session revolves around the http requests, we are trying to
       //get a running session with the above code
            session.setAttribute("username",username);
//After a successful signin, a username is provided a session acc to
            //their username

            List<UserTable> totalUsers= uRepo.findAll();

m.addAttribute("totalUsers", totalUsers);

            return "homePage";
        }


//message lai Model ko attribute bhaninchha
        m.addAttribute("loginError", "Username/Password Incorrect");
      return "loginPage";
    }



    @PostMapping("/signup")
    public String signupPost(HttpServletRequest request, Model m)
    {

        String username,password;
        username=request.getParameter("username");
        password=request.getParameter("password");

        //md5- DigestUtils
        String hashPassword=DigestUtils.md5DigestAsHex(password.getBytes());

        UserTable ut = new UserTable();
        ut.setUsername(username);
        ut.setPassword(hashPassword);

        uRepo.save(ut);

      m.addAttribute("signupSuccess","Successfully signedup! Please login");
        return "loginPage";
    }


    @GetMapping("/home")
    public String homePage()
    {
        return "homePage";
    }


}
