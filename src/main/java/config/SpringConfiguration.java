package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:Spring配置类，相当于bean.xml
 * @author:Lisa
 * @create:2019/08/06
 */
@Configuration
@ComponentScan("com.ls") // 配置spring创建容器时需要扫描的包
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement // 开启spring对注解事务的支持
public class SpringConfiguration {
}
