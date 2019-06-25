package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/")
    public String index() {
        City city1 = cityMapper.findByState("CA");
        City city2 = sqlSession.selectOne("hello.CityMapper.findByState", "CA");
        System.out.println(city1);
        System.out.println(city2);
        return "Greetings from Spring Boot!";
    }
}