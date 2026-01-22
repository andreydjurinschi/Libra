/*
package org.cedacri.spring.cedintlibra.utils;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;

import javax.sql.DataSource;

*/
/**
 * configuration class that creates bean {@link SpringLiquibase}
 *//*

@Configuration
public class LiquibaseConfig {

    */
/**
     * defines bean for the liquibase
     * @param dataSource - bean, which would be extracted from SpringContext
     * @return {@link SpringLiquibase}
     *//*

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("db/changelog/db.changelog-master.yaml");
        liquibase.setResourceLoader(new DefaultResourceLoader());
        return liquibase;
    }
}
*/
