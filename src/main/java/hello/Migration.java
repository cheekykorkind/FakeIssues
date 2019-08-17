package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import org.flywaydb.core.Flyway;

import hello.Member;
import hello.UserMapper;


/**
 * DB 마이그레이션과 시딩을 관리합니다.
 */
@Service
public class Migration {
    @Autowired
    private Environment env;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    private Flyway flyway;

    public void run() {
        this.setFlyway();

        String mode = env.getProperty("migration");

        //  DB table 생성 및 seeder 실행
        if ("up".equals(mode)) {
            this.flyway.migrate();
            this.memberSeeder();

		//  DB 초기화.
        } else if ("clean".equals(mode)) {
            this.flyway.clean();
        }
    }

    /**
     * 유닛 테스트 마이그레이션 업
     */
    public void testUp() {
        this.setFlyway();
        this.flyway.migrate();
    }

    /**
     * 유닛 테스트 마이그레이션 다운
     */
    public void testClean() {
        this.setFlyway();
        this.flyway.clean();
    }

    /**
     * Flyway인스턴스를 로드
     */
    private void setFlyway() {
        String url = env.getProperty("spring.datasource.url");
        String user = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");

        this.flyway = Flyway.configure().dataSource(url, user, password).load();
    }

    /**
     * 개발용 유저 생성 seeder
     */
    private void memberSeeder() {
        Member member = new Member();
        member.setUsername("user3");
        member.setPassword(passwordEncoder.encode("password"));
        member.setName("안보여");

        userMapper.create(member);
    }
}
