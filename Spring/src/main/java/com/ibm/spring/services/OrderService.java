//package com.ibm.spring.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service("orderService")
//public class OrderService {
//	@Autowired
//	private final PaymentService paymentService ;
//	
//	public OrderService(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}
//	
//	public void makePayment(double amount) {
//		paymentService.processPayment(amount);
//	}
//}


package com.ibm.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
	
	private final PaymentService paymentService ;
	
	@Autowired
	public OrderService(@Qualifier("UPIService")PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void makePayment(double amount) {
		paymentService.processPayment(amount);
	}
}
