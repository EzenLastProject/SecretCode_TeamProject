package SecretCode.ezen.www.config;



import SecretCode.ezen.www.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    springSecurity6 => createDeligationPasswordEncoder




    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

        // SecurityFilterChain 객체로 설정
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers
                                ("/index", "/", "/js/**", "/dist/**", "/board/list", "/member/login", "/member/register"
                                        ,"/member/login_register","/member/emailCheck", "/upload/**", "/comment/**"
                                        ,"/theme/theme", "/theme/**", "/qna/list", "/qna/**", "/qna/checkSecret" )
                        .permitAll().requestMatchers("/member/list").hasAnyRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(login -> login
                        .usernameParameter("email")
                        .passwordParameter("pwd")
                        .loginPage("/member/login")
                        .defaultSuccessUrl("/").permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl(("/member/logout"))
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/")
                );
        return http.build();


    }
//        userDetailsService : spring에서 만든 클래스와 같은 객체

    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserService();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
