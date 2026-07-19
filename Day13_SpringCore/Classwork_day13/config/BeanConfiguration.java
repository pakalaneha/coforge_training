package com.coforge.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Customer;
import com.coforge.model.DeliveryAddress;

@Configuration
public class BeanConfiguration {

    @Bean(name = "customer1")
    public Customer getCustomer() {
        Customer customer = new Customer();

        customer.setCustomerId(101);
        customer.setCustomerName("Aarav Sharma");
        customer.setEmails(Arrays.asList(
                "aarav.sharma@gmail.com",
                "aaravsharma123@gmail.com"
        ));

        customer.setDeliveryAddress(
                Arrays.asList(getDeliveryAddress1(), getDeliveryAddress2())
        );

        return customer;
    }


    @Bean(name = "deliveryAddress1")
    public DeliveryAddress getDeliveryAddress1() {
        DeliveryAddress deliveryAddress1 = new DeliveryAddress();

        deliveryAddress1.setCity("Bengaluru");
        deliveryAddress1.setState("Karnataka");

        return deliveryAddress1;
    }


    @Bean(name = "deliveryAddress2")
    public DeliveryAddress getDeliveryAddress2() {
        DeliveryAddress deliveryAddress2 = new DeliveryAddress();

        deliveryAddress2.setCity("Pune");
        deliveryAddress2.setState("Maharashtra");

        return deliveryAddress2;
    }
}