package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks {

    private final TestContext context;

    public MyHooks(TestContext context){
        this.context = context;
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());

    }

    @After
    public void after(Scenario scenario){
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());

    }
}
