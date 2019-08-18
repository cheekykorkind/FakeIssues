CREATE TABLE user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NULL DEFAULT NULL,
  name VARCHAR(20) NULL DEFAULT NULL,
  password VARCHAR(500) NULL DEFAULT NULL,
  isAccountNonExpired TINYINT(1) NULL DEFAULT NULL,
  isAccountNonLocked TINYINT(1) NULL DEFAULT NULL,
  isCredentialsNonExpired TINYINT(1) NULL DEFAULT NULL,
  isEnabled TINYINT(1) NULL DEFAULT NULL
) COMMENT = '유저 테이블, 스프링 시큐리티를 위해서 이름이 고정된 칼럼이 있다';

CREATE TABLE authority (
  username VARCHAR(20) NULL DEFAULT NULL,
  authority_name VARCHAR(20) NULL DEFAULT NULL
) COMMENT = '권한 테이블, 스프링 시큐리티를 위해서 이름이 고정된 칼럼이 있다';

CREATE TABLE repositories (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255) NULL DEFAULT NULL,
  type INT COMMENT 'public으로 전체공개인지, private로 비공개인지'
) COMMENT = '깃허브의 리포지토리 담당이다';

CREATE TABLE repository_users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  userId INT,
  repositoryId INT
) COMMENT = '리포지토리에 속한 유저 담당이다, user와 repositories테이블의 다대다 관계 해소 테이블';

CREATE TABLE issues (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  content VARCHAR(255) NULL DEFAULT NULL,
  userId INT,
  repositoryId INT
) COMMENT = '깃허브 이슈 담당이다, user와 repositories테이블과 다대일 관계이다';

CREATE TABLE labels (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  color VARCHAR(255),
  description VARCHAR(255) NULL DEFAULT NULL,
  repositoryId INT
) COMMENT = '깃허브의 라벨담당이다, repositories테이블과 다대일 관계이다';

CREATE TABLE comments (
  id INT PRIMARY KEY AUTO_INCREMENT,
  content VARCHAR(255),
  issueId INT,
  userId INT
) COMMENT = '이슈에 대한 코멘트 담당이다, issues와 user테이블과 다대일 관계이다';
