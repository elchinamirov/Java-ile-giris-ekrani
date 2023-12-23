package Student;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // Spring bu classi gorende desinki bunun icinde nese konfiqurasiya var.
@EnableWebSecurity                            
@EnableMethodSecurity(prePostEnabled = true) // Bunu yazmayanda Spring PreAuthorities-leri gormezden gelir.(kimin username ve parolu dogrudursa her yere gire bilir)
public class SecurityConfig {
	
	@Autowired //DataSourcenin obyektine ehtiyacimiz var(Springe basa salmayaqki username ve parollar bazadadir)
private DataSource dataSource;
	
	
	
	 @Bean // UserDetailsService-nin obyekti springde var amma biz ozumuz yaradib veririk. Alt class bizde olduqu ucun esasen override olunmusu bizimkini esas goturecek.
	    public UserDetailsService userDetailsService() {
	        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
	        jdbcDao.setDataSource(dataSource); //Bazadan melumat goturme kodlarini deyirikki bizim bazadan gotur.
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
	        return http.csrf().disable() // Saytlar arasi id ve port cutlukleri arasinda melumatlar gelib gedisini qadagan olunmasidir.
	        		
	                .authorizeRequests() 
	                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll() // Spring Security  defult olaraq yalniz melumat qaytaran serverlere icaze verir .PoST ve PUT icaze vermir.Ona gorede 2 etapli aktivlesdiririk.
	                .requestMatchers(HttpMethod.GET,"/students/hamiya").permitAll()
	                
	                .anyRequest().authenticated() //Zincirvari melumat metod cagirma mexanizmasidir.
	                .and()                        // Yeni her metod bu obyektin ozunu qaytarir.
	                .httpBasic()                  //return this edir yeni.Bir bir yeniden http olani yazmiriq.Yazmaqda olar ama etmirik.
	                .and()
	                 
	                .build();
	    }
	    
		
		/*Spring Security-nin 2 cur qurulusu var.
	    
	        1)SESSION-MVC STATEFUL- Serverin vaxti bitende islemir.
	        2)TOKEN(Muasir,en cox istifade olunan)-REST STATELESS- Gelen melumati yadda saxlamir.Her gelende yeni user kimi dusunur.
		
		 TOKEN-in novleri var
	         1)BASIC= Username ve parol gelir servere.Server baxir eger varsa, icaze verir.
	         2)JWT
	         3)ldap
	         
	         *Errorlarin novleri
	         
	         1) 401 = Username ve password sehvdir ve ya yoxdur.
	        
	         2) 403 = Username ve password duzdir, amma metodun yoxdur.
	         
	         3) 500 = Kdda xeta var.ecurity ile elaqeli deyil.
	 */
	}

	
	

