package az.developia.restaurantelchinemirov.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http.csrf().disable().authorizeRequests()
.antMatchers(HttpMethod.GET,"/products/hamiya").permitAll()
.antMatchers(HttpMethod.POST,"/users/signup").permitAll()
.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
.antMatchers(HttpMethod.POST,"/products").permitAll()
.antMatchers(HttpMethod.GET,"/h2-console").permitAll()
.antMatchers(HttpMethod.GET,"/products/hamiya").permitAll()
.antMatchers(HttpMethod.GET,"/users/test").permitAll()
.anyRequest().authenticated().and()
.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.headers().frameOptions().disable();	
}
@Autowired
private DataSource dataSource;

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.jdbcAuthentication().dataSource(dataSource);
}	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Autowired
    private  DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
         return jdbcDao;
    }

    

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
       
        return authProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
        		
                .authorizeRequests() 
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/products/hamiya").permitAll()

                .anyRequest().authenticated()
                .and()
                .httpBasic() 
                .and()
                 
                .build();
    }
    
	
	
	*/
	

    
    
    