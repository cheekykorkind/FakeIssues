# FakeIssues

[![Build Status](https://travis-ci.org/cheekykorkind/FakeIssues.svg?branch=master)](https://travis-ci.org/cheekykorkind/FakeIssues)

### 마이그레이션 없이 시작
./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar

### 마이그레이션 up
./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar --migration=up

### 마이그레이션 clean
./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar --migration=clean


## docker로 설정
### docker-compose.yml생성
- `docker_compose_up.sh up` 실행하면, 파일을 생성해줌

필요한 정보를 적을 필요가 있음.
At `docker_compose_up.sh`
```
...
UID=$(id -u $USER)  # Get uid from your host machine automatically
GID=$(id -g $USER)  # Get gid from your host machine automatically
UNAME=$(echo "$USER")  # Get linux user name from your host machine automatically
...
```

### test용 DB설정
- docker exec mysql57 mysql -u root -proot -e "create database fake_issues_test;"

### permission denied 대응(필요하면 사용)
- docker exec fake_issue chown -R vagrant:vagrant /home/vagrant/opt

### 마이그레이션 없이 시작
docker exec fake_issue ./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar

### 마이그레이션 up
docker exec fake_issue ./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar --migration=up

### 마이그레이션 clean
docker exec fake_issue ./gradlew clean build && java -jar build/libs/gs-spring-boot-0.1.0.jar --migration=clean
