package com.restapiexample.Dummy.cucumber;


import com.restapiexample.Dummy.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/"
        , tags = "@smoke"

)
public class CucumberRunner extends TestBase {


}
