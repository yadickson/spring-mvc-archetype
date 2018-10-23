#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ${package}.service.OneService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"${package}.controller"})
public class MockControllerConfig {

    @Bean
    public OneService oneService() {
        return Mockito.mock(OneService.class);
    }

}
