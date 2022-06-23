package com.restapiexample.Dummy.testbase;



import com.restapiexample.Dummy.constants.Path;
import com.restapiexample.Dummy.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.EMPLOYEE;
    }
    }


