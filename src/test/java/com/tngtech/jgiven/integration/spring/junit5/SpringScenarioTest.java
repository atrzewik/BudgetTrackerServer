package com.tngtech.jgiven.integration.spring.junit5;

import com.tngtech.jgiven.integration.spring.SpringStageCreator;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Borrowed from <a href="https://github.com/TNG/JGiven/blob/master/jgiven-spring-junit5/src/main/java/com/tngtech/jgiven/integration/spring/junit5/SpringScenarioTest.java">https://github.com/TNG/JGiven</a>
 * because there was no deploy to mvn central
 */
@ExtendWith(SpringExtension.class)
public class SpringScenarioTest<GIVEN, WHEN, THEN> extends
        ScenarioTest<GIVEN, WHEN, THEN> implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        getScenario().setStageCreator(beanFactory.getBean(SpringStageCreator.class));
    }
}