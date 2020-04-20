package com.r.myspring.config;

import com.r.myspring.injector.ResSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luozhan
 * @create 2020-04
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ResSqlInjector myLogicSqlInjector() {
        return new ResSqlInjector();
    }
}
