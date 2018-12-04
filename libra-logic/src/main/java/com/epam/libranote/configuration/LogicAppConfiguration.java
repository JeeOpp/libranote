package com.epam.libranote.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.epam.libranote.service"})
@MapperScan({"com.epam.libranote.mapper"})
@EnableTransactionManagement
public class LogicAppConfiguration {
//
//    private static final String PROP_DATABASE_DRIVER = "db.driver";
//    private static final String PROP_DATABASE_PASS = "db.password";
//    private static final String PROP_DATABASE_URL = "db.url";
//    private static final String PROP_DATABASE_USERNAME = "db.username";
//    private static final String PROP_DATABASE_MIN_IDLE = "db.minidle";
//    private static final String PROP_DATABASE_MAX_IDLE = "db.maxidle";
//
//    @Resource
//    private Environment env;

    private static final String DATASOURCE = "java:comp/env/jdbc/libranote";

    @Bean
    public DataSource dataSource() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        DataSource dataSource = dsLookup.getDataSource(DATASOURCE);
        return dataSource;
    }

//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//
//        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
//        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
//        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
//        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASS));
//        dataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty(PROP_DATABASE_MIN_IDLE)));
//        dataSource.setMaxIdle(Integer.valueOf(env.getRequiredProperty(PROP_DATABASE_MAX_IDLE)));
//        return dataSource;
//    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}
