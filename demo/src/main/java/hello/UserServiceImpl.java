package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hello.Member;
import hello.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    
     @Autowired UserMapper userMapper;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Member user = userMapper.readUser(username);
          user.setAuthorities(getAuthorities(username));
         
          return user;
     }
    
     public Collection<GrantedAuthority> getAuthorities(String username) {
          List<String> string_authorities = userMapper.readAuthority(username);
          List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
          for (String authority : string_authorities) {
               authorities.add(new SimpleGrantedAuthority(authority));
          }
          return authorities;
     }
}