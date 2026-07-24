package io.herald.grp2springweb.Controller;

import io.herald.grp2springweb.Model.UserTable;
import io.herald.grp2springweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository uRepo;

    @PostMapping("/deleteUser")
    public String delete(@RequestParam("id") int id, Model m)
    {
uRepo.deleteById(id);

m.addAttribute("totalUsers",uRepo.findAll());
return "homePage";

    }

    @PostMapping("/editUser")
    public String editUserPost(@RequestParam ("id") int id, Model m)
    {
     UserTable user=  uRepo.getById(id);

       m.addAttribute("user",user);
        return "editUserPage";
    }

    @PostMapping("/updateUser")
    public String updateUserPost(@ModelAttribute UserTable user, Model m)
    {
        uRepo.save(user);

        m.addAttribute("totalUsers",uRepo.findAll());
        return "homePage";
    }


}
