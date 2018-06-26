package com.app.security;

/**
 * 创建人: Hjx
 * Date: 2018/6/21
 * Description:
 * 用户注册security
 *
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("hjx").password("123456").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/css/**", "/index").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/blogs/**").hasRole("USER")
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login-error")
//                .and()
//                .exceptionHandling().accessDeniedPage("/401");
//
//        http
//                .logout().logoutSuccessUrl("/");
//    }

}
