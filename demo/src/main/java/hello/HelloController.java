package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;


@Controller
public class HelloController {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/will/first")
    public String index() {
        return "firstPage";
    }

    @RequestMapping("/second")
    public String index2() {
        return "secondPage";
    }
}