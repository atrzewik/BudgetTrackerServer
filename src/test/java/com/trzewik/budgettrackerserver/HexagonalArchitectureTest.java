package com.trzewik.budgettrackerserver;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Named;
import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.trzewik.budgettrackerserver")
public class HexagonalArchitectureTest {

    @ArchTest
    public static final ArchRule rule_for_entities = classes()
            .that()
            .areAnnotatedWith(Entity.class)
            .should()
            .resideOutsideOfPackage("..domain..");
    @ArchTest
    public static final ArchRule rule_for_controllers = classes()
            .that()
            .areAnnotatedWith(Controller.class)
            .or()
            .areAnnotatedWith(RestController.class)
            .or()
            .areAnnotatedWith(ControllerAdvice.class)
            .should()
            .resideOutsideOfPackage("..domain..");
    @ArchTest
    public static final ArchRule rule_for_services = classes()
            .that()
            .areAnnotatedWith(Service.class)
            .should()
            .resideOutsideOfPackage("..domain..");

    @ArchTest
    public static final ArchRule rule_for_dependencies = noClasses()
            .that()
            .areAnnotatedWith(Named.class)
            .should()
            .dependOnClassesThat()
            .areAnnotatedWith(RestController.class)
            .orShould()
            .dependOnClassesThat()
            .areAnnotatedWith(Controller.class);

    @ArchTest
    public static final ArchRule rule_for_junit4_methods = noMethods()
            .should()
            .beAnnotatedWith("org.junit.Test");
}
