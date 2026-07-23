package io.herald.grp2springweb.Repository;

import io.herald.grp2springweb.Model.UserTable;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Integer>
{
    boolean existsByUsernameAndPassword(String un, String pwd);
    //existsBy function can be found already in our repo, but username and password cant be
    //detected directly by existsBy function.
    //Hence, if our usertable has columns named "username" and "password" we can
    //suggest our repository to look for it , if the value exists or not.

    //Custom Syntaxes Signature

}
