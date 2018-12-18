package MySelfRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class MySelfRule {

@Bean
public IRule MyRule(){
    return new RoundRobinRule_Self();
}


}
