package org.jjzhu.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static org.jjzhu.springboot.config.MyBatisConfig.SSF_REF;

/**
 * Created by zhujiajunup@163.com on 2017/7/4.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"org.jjzhu.dao"},
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
                .driverClassName(jdbcConfig.getDriverClass())
                .url(jdbcConfig.url)
                .username(jdbcConfig.userName)
                .password(jdbcConfig.password).build();
    }

    @Bean(SSF_REF)
    public SqlSessionFactory createSqlSessionFactory(@Qualifier(DATA_SOURCE)DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /* 设置 mybatis configuration 扫描路径 */
        bean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        try {
            /* 添加 mapper 扫描路径 */
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @PropertySource(value = "classpath:db.properties")
    @Component
    static class JdbcConfig{
        @Value("${jbdc.username}")
        private String userName;

        @Value("${jbdc.driver}")
        private String driverClass;

        @Value("${jbdc.url}")
        private String url;

        @Value("${jbdc.password}")
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDriverClass() {
            return driverClass;
        }

        public void setDriverClass(String driverClass) {
            this.driverClass = driverClass;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
