# spring boot整合mybatis
## pom.xml配置
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.4.RELEASE</version>
</parent>
<dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.0</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
 </dependencies>
```
## 配置application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
## 创建数据库
```sql
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age`  smallint(6) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2
ROW_FORMAT=DYNAMIC
;
```
## User entity
```java
public class User {

    private Long id;
    private String name;
    private Integer age;

    // getter and setter
}
```

## UserMapper
```java
@Mapper
public interface UserMapper {
    @Select("select from user where name=#{name}")
    User findByName(@Param("name") String name);
    /* 不支持重载哦！！！
    @Insert("insert into user(name, age) values (#{name}, #{age})")
    int insert(@Param("name")String name, @Param("age") Integer age);
    */
    @Insert("insert into user(name, age) values (#{user.name}, #{user.age})")
    int insert(@Param("user") User user);
}
```
## SpringBoot Application
```java
@SpringBootApplication
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
```

## Test
```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void insert1() throws Exception{
        User user= new User("Lucy", 15);
        userMapper.insert(user);
    }
}
```
