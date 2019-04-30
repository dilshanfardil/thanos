package lk.avalanche.godslayer.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/30/2019
 * Time: 4:52 PM}
 */


@Configuration
@ComponentScan("lk.avalanche.godslayer")
@EnableWebMvc
@EnableWebSecurity
public class WebAppConfig {
}
