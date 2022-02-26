package com.demo.service;

import com.demo.domain.Order;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    Order ord;

    @Mock
    EmailService email;

    @InjectMocks
    OrderService order;


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_getInstance_expectInstanceOfEmailService(){
        OrderService order2 = OrderService.getInstance();
        assertTrue(order2 instanceof OrderService);
    }

    @Test(expected = RuntimeException.class)
    public void test_placeOrder_expectNull(){
        Mockito.when(ord.getPrice()).thenReturn(80.0*20/100);
        assertEquals((double) 16,ord.getPrice(),0.001);
        // Second test
        Order ord2 = new Order();
        Mockito.when(ord2.setPriceWithTax(80.0*20/100)).thenReturn(new Order());
        assertTrue(ord2.setPriceWithTax(90.0*20/100) instanceof Order);
        //Third
        EmailService es2 = new EmailService();  //es.sendEmail(o);
        Mockito.verify(email).sendEmail(ord);
        //Fourth
        Mockito.verify(ord).setCustomerNotified(false);
    }



    @Test
    public void test_placeOrder_expectBoolean(){
        Mockito.when(email.sendEmail(ord, "cc")).thenReturn(true);
        assertTrue(email.sendEmail(ord,"cc"));
    }
}

