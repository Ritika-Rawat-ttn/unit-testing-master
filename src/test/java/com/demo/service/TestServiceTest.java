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
public class TestServiceTest {


    @Mock
    Order ord1;

    @Mock
    EmailService email;

    @InjectMocks
    TestService testService;


    @Rule
    public ExpectedException ex= ExpectedException.none();


    @Test
    public void testFirstMethod() {
        assertEquals(1, testService.test());
    }

    @Test
    public void test_getinstance_expectInstanceofemailservice(){
////        TestService testService1= TestService.getInstance();
//        TestService testService1 = TestService.getInstance();
//
//        assertTrue(testService1 instanceof TestService);
        OrderService os2 = OrderService.getInstance();
        assertTrue(os2 instanceof OrderService);
    }




//    private void assertEquals(boolean b) {
//    }
    @Test(expected = RuntimeException.class)
    public void testplaceorder_expectnull(){
        Mockito.when(ord1.getPrice()).thenReturn(80.0*20/100);
        //assertEquals((double) 18,ord1.getPrice(),0.001);
        assertEquals((double) 18,ord1.getPrice(),0.001);


        //Second test
        Order ord2=new Order<>();
        Mockito.when(ord2.setPriceWithTax(80.0*20/100)).thenReturn(new Order());
        assertTrue(ord2.setPriceWithTax(90.0*20/100) instanceof Order);


        //Third test
        EmailService email2=new EmailService();
        Mockito.verify(ord1).setCustomerNotified(false);
    }

    @Test
    public void test_placeorder_expectboolean(){
        Mockito.when(email.sendEmail(ord1,"ritika")).thenReturn(true);
        assertTrue(email.sendEmail(ord1,"ritika"));
    }




}