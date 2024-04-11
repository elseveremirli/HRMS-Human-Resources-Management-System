package kodlama.io.hrms.security.config;


import kodlama.io.hrms.security.service.HrmsEmployeeDetailServiceImpl;
import kodlama.io.hrms.security.service.UserDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final UserDetailService userDetailService;
    private final BCryptPasswordEncoder passwordEncoderconfig;

    public SecurityConfiguration(UserDetailService userDetailService, BCryptPasswordEncoder passwordEncoderconfig) {
        this.userDetailService = userDetailService;
        this.passwordEncoderconfig = passwordEncoderconfig;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoderconfig);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{

        security
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(withDefaults())
                .authorizeHttpRequests(x -> x.requestMatchers("/public/**","/swagger-ui/**","/api/hmrsEmployee/**").permitAll())
                .authorizeHttpRequests(x->x.anyRequest().authenticated())
//               .authorizeHttpRequests(x -> x.anyRequest().permitAll())
        ;

        return security.build();
    }

}
