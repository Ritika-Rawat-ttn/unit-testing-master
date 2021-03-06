package com.demo.service;

import com.demo.domain.Order;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock           //The purpose of mock is to focus on code being tested
    Order ord;


    @InjectMocks            //Mock annotation
    EmailService email;


    @Rule
    public ExpectedException Ex = ExpectedException.none();



    @Test
    public void test_Mockstaticmethod_expectinstanceOfEmailService(){
        EmailService es2 = EmailService.getInstance();
        assertTrue(es2 instanceof EmailService);
    }



    @Test
    public void test_sendemail_expectrue(){
        Order ord2= new Order(34,"anarkali suit",34567);
        assertTrue(email.sendEmail(ord2,"ritika"));
    }

    @Test
    public void test_sendemail_expectexception(){
        Ex.expect(RuntimeException.class);
        Ex.expectMessage("Exception");
        Order ord2= new Order(34,"anarkali",34567);
        EmailService email3=new EmailService();
        email3.sendEmail(ord2);

    }






}