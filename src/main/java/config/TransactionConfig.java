package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @description:和事务相关的配置类
 * @author:Lisa
 * @create:2019/08/06
 */
public class TransactionConfig {

    /**
     * 创建事务管理器对象
     */
    @Bean("transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
