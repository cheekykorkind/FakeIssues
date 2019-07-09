package hello;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.DefaultRedirectStrategy;
 

// WebSecurityConfigurerAdapter를 상속한 클래스에서 .defaultSuccessUrl("/index2")로
// 로그인 후 리다이렉트 설정이 안되서 커스텀 핸들러를 작성
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String _url;

    public CustomLoginSuccessHandler(String url) {
        this._url = url;
    }

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response, 
        Authentication authentication
    )
    throws 
        ServletException,
        IOException 
    {
        (new DefaultRedirectStrategy()).sendRedirect(request, response, this._url);
    }
}
