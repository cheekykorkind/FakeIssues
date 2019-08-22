package hello;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import hello.SecurityMember;

@Component
public class UserInfo{
    public long getUserId(){
        SecurityMember principal = (SecurityMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return principal.getId();
    }
}
