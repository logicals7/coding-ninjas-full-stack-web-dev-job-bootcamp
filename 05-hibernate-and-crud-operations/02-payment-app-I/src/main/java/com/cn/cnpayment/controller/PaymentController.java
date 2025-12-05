package com.cn.cnpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.service.PaymentService;
import java.util.List;

 /**
  # Complete the PaymentController class, methods to handle HTTP requests with
  required annotations for the following APIs: **/

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// GET "/payment/allPayments"
	@GetMapping("/allPayments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	// GET "/payment/id/{id}"
	@GetMapping("/id/{id}")
	public Payment getPaymentById(@PathVariable int id) {
		return paymentService.getPaymentById(id);
	}

	// POST "/payment/save"
	@PostMapping("/save")
	public void savePayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
	}

	// GET "/payment/paymentType/{paymentType}"
	@GetMapping("/paymentType/{paymentType}")
	public List<Payment> getByPaymentType(@PathVariable String paymentType) {
		return paymentService.getPaymentByPaymentType(paymentType);
	}

	// GET "/payment/description/{keyword}"
	@GetMapping("/description/{keyword}")
	public List<Payment> getByDescriptionKeyword(@PathVariable String keyword) {
		return paymentService.getPaymentByDescriptionKeyword(keyword);
	}
}
