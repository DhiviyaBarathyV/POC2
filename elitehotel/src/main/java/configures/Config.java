package configures;

import javax.sql.DataSource;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dao.UserDao;
import dao.UserDaoImple;
import services.UserService;
@EnableWebMvc
@Configuration
@ComponentScan({"controllers","dao","services"})
public class Config implements WebMvcConfigurer 
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}
	@Bean
	public UserService userservice()
	{
		
		return new UserService();
	}
	@Bean
	public UserDao userdao()
	{
		
		return new UserDaoImple();
	}
	@Bean
	public JdbcTemplate jdbctemplate()
	{
		
		return new JdbcTemplate();
	}
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/poc?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Vdb@1997");
        return dataSource;
    }
	 @Bean
	    public JdbcTemplate jdbctemplate(DataSource dataSource) {
	        JdbcTemplate jdbctemplate = new JdbcTemplate(dataSource);
	        jdbctemplate.setResultsMapCaseInsensitive(true);
	        return jdbctemplate;
	    }
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry
		.addResourceHandler("/UrlToReachResourcesFolder/**")
		.addResourceLocations("/resources/");
		
	}

}
