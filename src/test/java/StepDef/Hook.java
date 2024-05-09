package StepDef;

import io.cucumber.java.*;

import java.util.Objects;

import static Helper.Utility.*;

public class Hook{
    String tagRunning = null;

    @BeforeAll
    public static void setUp(){
        System.out.println("Before all");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("After all");
    }

    @Before
    public void beforeTest(Scenario scenario){
        System.out.println("Before Test");
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagRunning = tags[0];
        if (Objects.equals(tagRunning, "@web")){
            getDriver();
        }
    }
    @After
    public void afterTest(Scenario scenario) throws InterruptedException{
        System.out.println("Before Test");
        if (Objects.equals(tagRunning, "@web")){
            closeDriver();
        }
    }
}
