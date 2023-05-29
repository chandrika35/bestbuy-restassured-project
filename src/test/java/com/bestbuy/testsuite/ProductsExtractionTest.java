package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //21.Extract the limit

    @Test
    public void test001(){
        int limit  =  response.extract().path("limit");
        System.out.println("The value of limit "+ limit);

    }

    //22. Extract the total
    @Test
    public void test002(){
        int total = response.extract().path("total");
        System.out.println("the total value is : "  + total);

    }

    // 23. Extract the name of 5th product
    @Test
    public void test003(){
        String productName = response.extract().path("data[4].name");
        System.out.println("name of 5th product : " + productName);
    }

    // 24. Extract the names of all the products
    @Test
    public void test004(){
        List<String> productsName =  response.extract().path("data.name");
        System.out.println("name of all the products :"  + productsName);
    }
    // 25. Extract the productId of all the products
    @Test
    public void test005(){
        List<Integer> productIds = response.extract().path("data.id");
        System.out.println("list of all products : " + productIds);
    }
    //26. Print the size of the data list
    @Test
    public void test006(){
        List<HashMap<String, ?>>productData = response.extract().path("data");
        System.out.println("size of the data " + productData.size());
    }
    // 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-pack)
    @Test
    public void test007(){
        List<Integer> price = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.price");
        System.out.println("value of the product where name is 'Energizer - MAX Batteries AA (4-pack)' :"+ price);
    }

   // 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-pack)

    @Test
    public void test008(){
        List<Integer> modelName = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("value of the product where name is 'Energizer - N Cell E90 Batteries (2-pack)' :"+ modelName);
    }

    // 29. Get all the categories of 8th products
    @Test
    public void test009(){
        List<HashMap<String, ?>> productCategories  = response.extract().path("data[7].categories");
        System.out.println("all categories of 8th product " + productCategories );
    }
    //30.  Get categories of the store where product id = 150115
    @Test
    public void test010(){
        List<Integer> categories = response.extract().path("data[3].categories");
        System.out.println("categories of 150115 : " + categories);
    }

//31. Get all the descriptions of all the products

    @Test
    public void test011(){
        List<Integer> description = response.extract().path("data.description");
        System.out.println("Descriptions : " + description);}



    //32. Get id of all the all categories of all the products
    @Test
    public void test012(){
        List<Integer> idcategories = response.extract().path("data.categories.id");
        System.out.println("Descriptions : " + idcategories);}

//33. Find the product names Where type = HardGood

    @Test
    public void test013(){
        List<Integer> name = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("product names are " + name);}

    @Test
    //34. Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)

    public void test014(){
        List<Integer> categories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("Total number of categories  " + categories);}

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test015(){

        List<Integer> createdAt = response.extract().path("data.findAll{it.price <5.49}.createdAt");
        System.out.println("Total number of createdAt  " + createdAt);}

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)"
    @Test
    public void test016(){
        List<Integer> categories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("Name  of all categories  " + categories);}

//37. Find the manufacturer of all the products

    @Test
    public void test017(){
        List<Integer> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("Name  of all manufacturer  " + manufacturer);}

    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test018(){
        List<Integer> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer)'}.image");
        System.out.println("image of Enerfizer " + image);}

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test019(){

        List<Integer> createdAt = response.extract().path("data.findAll{it.price >5.49}.createdAt");
        System.out.println("Total number of createdAt  " + createdAt);}

    //40. Find the uri of all the products
    @Test
    public void test020(){
        List<Integer> url = response.extract().path("data.url");
        System.out.println("Total URL  " + url);}




}
