package az.developia.libraryelchinemirov.config;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/files/").permitAll()

				.antMatchers(HttpMethod.POST, "/users/signup").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/").permitAll()
				.antMatchers(HttpMethod.POST, "/files").permitAll()
				.antMatchers(HttpMethod.GET, "/h2-console").permitAll()
				
				.antMatchers(HttpMethod.GET, "/files/")
				.permitAll().antMatchers(HttpMethod.GET, "/users/test")
				.permitAll() 

				.anyRequest().authenticated().and()

				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.headers().frameOptions().disable();

	}

	@Autowired
	private DataSource dataSource; 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);

	}
}
