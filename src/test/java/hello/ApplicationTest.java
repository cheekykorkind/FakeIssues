package hello;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.TestPropertySource;

import hello.Migration;

// test시 사용할 properties파일을 선택한다
@TestPropertySource(locations ="classpath:/application-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest
{
    @Autowired
    private Migration migration;

    @Before
    public void setup()
    {
        migration.testUp();
    }

    @Test
    public void mainTest() throws Exception
    {
    }

    @After
    public void tearDown()
    {
        migration.testClean();
    }
}
