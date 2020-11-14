package com.learning.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.learning")
@EnableJpaRepositories("com.learning.repository")
@EntityScan(basePackages = "com.learning.entity")
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        logger.info("AAAAAAAAAAAAAAPPPPPPPPPPPPPPPPPSSSSSSSSSSSSSSSSSSSS");
        SpringApplication.run(Application.class, args);
        logger.info("AAAAAAAAAAAAAAPPPPPPPPPPPPPPPPPSSSSSSSSSSSSSSSSSSSS11111111111DDDDDDDDDDDD");

        /*applicationContext =
                new AnnotationConfigApplicationContext(com.due.dots.com.learning.config.Application.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }*/

    }

}