package com.github.knafelek.pilesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { //żeby nie trzeba było się logować przed rejestracją

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //lepsze niż BCrypt, przedrostek wstawiony automatyczne na podstawie przedrostka
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username = ?") //3 pole czy jest aktywny a nie mamy takiego pola więc domyślnie true
                .authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM users WHERE username = ?"); //nie ma tabelki z rolami stąd USER_USER na sztywno

/*        auth.inMemoryAuthentication()//na potrzeby testów konfiguracja
                .withUser("user").password(passwordEncoder().encode("pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("pass")).roles("ADMIN");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //reguły czytane od góry do dołu! dlatego od pojedynczych stron do globalnych!
        http.authorizeRequests()
                .antMatchers("/register", "/pile", "/pile/**", "/checkSS.jsp", "/home/**", "/investition/**", "/user-page").permitAll()//POTEM ZMIENIĆ DOSTĘPNOŚĆ PILE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                .antMatchers("/login").anonymous()
                .antMatchers("/user", "/user/**").hasRole("USER")
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .antMatchers("/media/**").permitAll()//dostęp do obrazkówi itd miałyby tylko osoby zalogowane bez tego
                .anyRequest().authenticated() //dla bezpieczesńtwa, musi być na końcu
                .and()
            .formLogin()
                .loginPage("/login")//formularz logowania
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/user") //domyslnie po zalogowaniu przenosi tu
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")//udało się zostałeś prawidłowo wylogowany
                .and()
            .csrf()//wyłącza konieczność wylogowania przez formularz
                .disable()
            .rememberMe()
                .key("MójTajnyKluczRememberMe") //włącza opcję rememberme //klucz szyfrujący - tworzy ciasteczko przy jego użyciu i przy rozszyfrowaniu używa klucza//klucz użyty do zaszycia hasła użytkownika
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(7*24*60*60);
    }
}
