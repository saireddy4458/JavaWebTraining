package com.ibm.spring.services;

import org.springframework.stereotype.Component;

@Component("creditCardService")
public class CreditcardService implements PaymentService {

	@Override
	public void processPayment(double amount) {
		System.out.println(amount + "paid using Credit Card");

	}

}
