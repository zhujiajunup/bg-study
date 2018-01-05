package org.example.dao.conf;

import lombok.Getter;
import lombok.Setter;
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

import static org.example.dao.conf.MyBatisConfig.SSF_REF;

/**
 * MybatisConfig 配置mybatis
 * Created by zhujiajunup@163.com on 2017/7/5.
 */
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
    @Setter
    @Getter
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

    }
}
