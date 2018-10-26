package com.group19.comment.g19_comment;


import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DemoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        DemoUser user = null;
        String password = upat.getCredentials().toString();
        List<GrantedAuthority> authorities = new ArrayList();
        if ("user".equals(username) && "password".equals(password)) {
            user = new DemoUser(username, password, authorities);
            user.setFname("Patthanapong");
            user.setLname("Pacteez");
        } else {
            throw new BadCredentialsException("Username and password wrong!");
        }
        return user;
    }

}