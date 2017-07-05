# SpringBoot多模块项目搭建
项目有如下三个模块
- dao
> 数据库操作
- service
> 项目逻辑
- web
> web api,与前端交互
## 创建项目模块
项目右键-> 新建module.
项目结构look like this

![](http://i.imgur.com/B4EkQsa.png)
## 配置pom.xml
spring-boot-mult-module项目下配置spring-boot的依赖。
可以有两种方式来引入spring-boot

### method-1
直接添加parent,继承spring-boot的pom依赖
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>org.example</groupId>
    <artifactId>spring-boot-mult-module</artifactId>
    <version>1.0</version>
    <modules>
        <module>mult-module-dao</module>
        <module>mult-module-service</module>
        <module>mult-module-web</module>
    </modules>
    <packaging>pom</packaging>

    <name>spring-boot-mult-module</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```
### method-2
如果你项目中有其他的父类，就不能用method-1中的继承了，这样你可以这样来管理spring-boot的依赖
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>spring-boot-mult-module</artifactId>
    <version>1.0</version>
    <modules>
        <module>mult-module-dao</module>
        <module>mult-module-service</module>
        <module>mult-module-web</module>
    </modules>
    <packaging>pom</packaging>

    <name>spring-boot-mult-module</name>
    <url>http://maven.apache.org</url>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <!-- Import dependency management from Spring Boot -->
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>1.5.4.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```
本例中用的是method-1，完整的pom.xml如下：
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>org.example</groupId>
    <artifactId>spring-boot-mult-module</artifactId>
    <version>1.0</version>
    <modules>
        <module>mult-module-dao</module>
        <module>mult-module-service</module>
        <module>mult-module-web</module>
    </modules>
    <packaging>pom</packaging>

    <name>spring-boot-mult-module</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <!-- mybatis start -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.2.8</version>
        </dependency>
        <!-- mybatis end -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.6</version>
            <scope>provided</scope>
        </dependency>

    </dependencies>
    <build>
        <finalName>mult-module-web</finalName>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.*</include>
                </includes>
                <excludes>
                    <exclude>**/*.java</exclude>
                </excludes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.*</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
这里需要注意的，spring-boot已经添加了很多依赖的包，如果你想使用不同版本的库，你可以用<exclusions>来移除，然后添加自己版本的库

for example:
the version of jackson in spring-boot-1.5.4.RELEASE is
```xml
<jackson.version>2.8.8</jackson.version>
```
now, you want to use another version of jackson, you can add the follow dependency in you pom.xml
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.7.4</version>
    <exclusions>
        <exclusion>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.7.4</version>
</dependency>

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.7.4</version>
</dependency>
```
reference: https://springframework.guru/jackson-dependency-issue-spring-boot-maven/
## dao模块
dao模块是用来操作数据库的，创建包
- config
> 包下新建MyBatisConfig.java
- mapper
> mybatis xml文件
- entity
> 数据库实体类 User

创建接口
- UserDao

在main文件夹下创建resources文件夹，并添加文件
- db.properties
> 数据库配置
- mybatis-config.xml
> mybatis配置

now, you dao module's structure may look like this:

![](http://i.imgur.com/awB6aOO.png)

then, each file's content are follow:

### MyBatisConfig
```java
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"org.example.dao"},
        sqlSessionFactoryRef = SSF_REF,
        annotationClass = Repository.class)
public class MyBatisConfig {
    public static final String SSF_REF = "sqlSessionFactory";
    public static final String DATA_SOURCE = "dataSource";

    @Autowired
    private JdbcConfig jdbcConfig;

    @Bean(name = DATA_SOURCE)
    public DataSource createDataSource(){
        return DataSourceBuilder.create(Thread.currentThread().getContextClassLoader())
                .driverClassName(jdbcConfig.driverClass)
                .url(jdbcConfig.url)
                .username(jdbcConfig.userName)
                .password(jdbcConfig.password).build();
    }

    @Bean(SSF_REF)
    public SqlSessionFactory createSqlSessionFactory(@Qualifier(DATA_SOURCE)DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /* 设置 mybatis configuration 扫描路径 */
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        try {
            /* 添加 mapper 扫描路径 */
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setMapperLocations(resolver.getResources("classpath:/org/example/dao/mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @PropertySource(value = "classpath:db.properties")
    @Component
    @Getter
    @Setter
    static class JdbcConfig{
        @Value("${jbdc.username}")
        private String userName;

        @Value("${jbdc.driver}")
        private String driverClass;

        @Value("${jbdc.url}")
        private String url;

        @Value("${jbdc.password}")
        private String password;

    }
}
```
### User
```java
@Setter
@Getter
public class User {

    private Long id;
    private String name;
    private Integer age;
    
    public User(){}
    
    public User(String name, Integer age){
        this.age = age;
        this.name = name;
    }
}
```
### UserMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.example.dao.UserDao">
    <select id="findByName" resultType="User">
        select id, name, age from user where name = #{name}
    </select>

    <insert id="addUser" parameterType="User">
        insert into user (name, age) values (#{user.name, #{user.age})
    </insert>

</mapper>
```
### UserDao
```java
public interface UserDao {

    boolean addUser(@Param("user") User user);

    User findByName(@Param("name")String name);

}
```
### db.properties
```properties
jbdc.url=jdbc:mysql://localhost:3306/spring_boot?useSSL=false
jbdc.username=****
jbdc.password=****
jbdc.driver=com.mysql.jdbc.Driver

```
### mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 配置全局属性 -->
    <settings>
        <!-- 使全局的映射器启用或禁用缓存。 -->
        <setting name="cacheEnabled" value="true"/>
        <!-- 全局启用或禁用延迟加载。当禁用时，所有关联对象都会即时加载。 -->
        <setting name="lazyLoadingEnabled" value="true"/>
        <!-- 当启用时，有延迟加载属性的对象在被调用时将会完全加载任意属性。否则，每种属性将会按需要加载。 -->
        <setting name="aggressiveLazyLoading" value="true"/>
        <!-- 是否允许单条sql 返回多个数据集  (取决于驱动的兼容性) default:true -->
        <setting name="multipleResultSetsEnabled" value="true"/>
        <!-- 是否可以使用列的别名 (取决于驱动的兼容性) default:true -->
        <setting name="useColumnLabel" value="true"/>
        <!-- 允许JDBC 生成主键。需要驱动器支持。如果设为了true，这个设置将强制使用被生成的主键，有一些驱动器不兼容不过仍然可以执行。  default:false  -->
        <setting name="useGeneratedKeys" value="true"/>
        <!-- 指定 MyBatis 如何自动映射 数据基表的列 NONE：不隐射　PARTIAL:部分  FULL:全部  -->
        <setting name="autoMappingBehavior" value="PARTIAL"/>
        <!-- 这是默认的执行类型  （SIMPLE: 简单； REUSE: 执行器可能重复使用prepared statements语句；BATCH: 执行器可以重复执行语句和批量更新）  -->
        <setting name="defaultExecutorType" value="SIMPLE"/>
        <!-- 使用驼峰命名法转换字段。 -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <!-- 设置本地缓存范围 session:就会有数据的共享  statement:语句范围 (这样就不会有数据的共享 ) defalut:session -->
        <setting name="localCacheScope" value="SESSION"/>
        <!-- 设置但JDBC类型为空时,某些驱动程序 要指定值,default:OTHER，插入空值时不需要指定类型 -->
        <setting name="jdbcTypeForNull" value="NULL"/>
    </settings>

    <!-- 使用po对象当做对象的别名 -->
    <typeAliases>
        <package name="org.example.dao.entity"/>
    </typeAliases>
</configuration>
```
### Application.java
```java
@SpringBootApplication
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
```
## DaoTest
```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void insert(){
        User user = new User("Ducy", 20);
        userDao.addUser(user);
    }
}
```
finally, the structure of dao module may look like this:

![](http://i.imgur.com/n1XDweo.png)

then run all the tests and check the database to see whether or not the insert test is successful.
 
if occur ==IllegalStateException: No supported DataSource type found== error

make sure the dependency of commons-dbcp, or tomcat-jdbc or hikaricp in your pom.xml file

reference: https://stackoverflow.com/questions/34790924/i-am-getting-datasource-not-supported-when-using-datasoucebuilder
## service module
![](http://i.imgur.com/hQH3cv3.png)

### pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>spring-boot-mult-module</artifactId>
        <groupId>org.example</groupId>
        <version>1.0</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>mult-module-service</artifactId>
    <packaging>jar</packaging>

    <name>mult-module-service</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>12.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>mult-module-dao</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
</project>
```
### IUserService
```java
public interface IUserService {

    boolean addUser(User user) throws NullPointerException, IllegalArgumentException;

    User findByName(String name);

}
```
### UserService
```java
@Service
public class UserService implements IUserService{

    @Autowired
    UserDao userDao;
    @Override
    public boolean addUser(User user) {
        Preconditions.checkNotNull(user);
        Preconditions.checkNotNull(user.getName());
        Integer age = user.getAge();
        if(age < 0 && age > 200){
            throw new IllegalArgumentException("age illegal");
        }
        return userDao.addUser(user);
    }

    @Override
    public User findByName(String name) {

        return userDao.findByName(name);
    }
}
```

## web moudle
![](http://i.imgur.com/VFApkEN.png)

### UserController
```java
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/add")
    @ResponseBody
    public String addUser(@RequestBody User user){
        try {
            userService.addUser(user);
        }catch (NullPointerException e){
            return "null point";
        }catch (IllegalArgumentException e){
            return "illegal argument";
        }
        return "ok";
    }
    @RequestMapping(value = "/findByName")
    @ResponseBody
    public User findByName(String name){

        return userService.findByName(name);
    }
}
```

## Others
### change tomcat server port
the default port of tomcat server is 8080,

if you want to use another port ,

you can create application.properties under resources in web module.

and add the follow property to change server port
```properties
server.port=8081
```
![](http://i.imgur.com/C3WkhGH.png)

### add filter
if you want to add some filter in you web application

define your filter 
```java
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("my filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
```

then configure your filter in your ApplicationConfig.java
```java
@Configuration
public class ApplicationConfig {
    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}
```

run your application and you will see the filter is load.

![](http://i.imgur.com/xaV28v5.png)

