package com.restapiexample.Dummy.cucumber.steps;

import com.restapiexample.Dummy.employeeinfo.EmployeeSteps;
import com.restapiexample.Dummy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;


import static org.hamcrest.Matchers.hasValue;


public class EmployeeStepdefs {
    static String employee_name = "Parita" + TestUtils.getRandomValue();
    static String employee_salary = "100000";
    static String employee_age="39";
    static int employeeId;
    static ValidatableResponse response;

    @Steps
    EmployeeSteps employeeSteps;

    @When("^I create a new employee by providing the information name salary and age$")
    public void iCreateANewEmployeeByProvidingTheInformationNameSalaryAndAge() {
        response=employeeSteps.createEmployee(employee_name,employee_salary,employee_age);
        response.log().all().statusCode(200);
    }

    @Then("^I verify that the new employee is created$")
    public void iVerifyThatTheNewEmployeeIsCreated() {
        employee_name="Cedric Kelly";
        HashMap<String, Object> employeeMap = employeeSteps.getEmployeeInfoByEmployeeName(employee_name);
        Assert.assertThat(employeeMap, hasValue(employee_name));
        employeeId = (int) employeeMap.get("id");
        System.out.println(employeeId);
    }

    @When("^I update the employee with name salary and age$")
    public void iUpdateTheEmployeeWithNameSalaryAndAge() {
        employee_name = "Mahesh";
        employee_salary="25000";
        employee_age="32";
        employeeId=6;
        response=employeeSteps.updateEmployee(employeeId,employee_name,employee_salary,employee_age);
    }

    @Then("^I verify that the employee information is updated$")
    public void iVerifyThatTheEmployeeInformationIsUpdated() {
        response.log().all().statusCode(200);
    }

    @When("^I delete the created employee with id$")
    public void iDeleteTheCreatedEmployeeWithId() {
        employeeId=3;
        response= employeeSteps.deleteEmployee(employeeId);
    }

    @Then("^I verify that the employee is deleted and get the status (\\d+)$")
    public void iVerifyThatTheEmployeeIsDeletedAndGetTheStatus(int exp) {
        response.statusCode(exp).log().status();
    }

}
