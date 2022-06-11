package ph.cfg;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatasourceConfig {
	
	@Bean
    @Profile("de")
    DataSource sqlDs() {
    	return DataSourceBuilder
    			.create()
    			.driverClassName(org.h2.Driver.class.getName())
    			.url("jdbc:h2:mem:imenu")
    			.username("sa")
    			.password("password")
    			.build();
    }
	
	

}
