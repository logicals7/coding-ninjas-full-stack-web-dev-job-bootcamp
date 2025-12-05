package com.cn.cnpayment.service;


				/**
				 Complete the PaymentService class as mentioned below:

				 Tasks:-

				 a. Autowire PaymentDAL.

				 b. Complete the following methods:

				 1. getPaymentById(int id): This method fetches payment from the dal
				 layer for a specific id.

				 2. getPaymentByPaymentType(String paymentType): This method
				 fetches a list of Payment from the dal layer based on the paymentType received.

				 3. getPaymentByDescriptionKeyword(String keyword): This method
				 fetches a list of payments from the dal layer based on the keyword received.

				 4. getAllPayments(): This method fetches a list of payments
				 from the dal layer.

				 5. addPayment(Payment payment): This method saves payment entity into the
				 database using the dal layer.

				 **/

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Arrays;

@Service
public class PaymentService {

	@Autowired
	private PaymentDAL paymentDAL;

	private static final List<String> VALID_TYPES = Arrays.asList("credit", "debit", "cash");

	@Transactional
	public Payment getPaymentById(int id) {
		Payment p = paymentDAL.getById(id);
		if (p == null) {
			throw new NotFoundException("Payment with id " + id + " not found.");
		}
		return p;
	}

	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {
		if (paymentType == null || !VALID_TYPES.contains(paymentType.trim().toLowerCase())) {
			throw new InvalidInputException("Invalid paymentType. Accepted values: Credit, Debit, Cash.");
		}
		List<Payment> list = paymentDAL.getByPaymentType(paymentType);
		if (list == null || list.isEmpty()) {
			throw new InvalidInputException("No payments found for paymentType: " + paymentType);
		}
		return list;
	}

	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {
		if (keyword == null || keyword.trim().isEmpty()) {
			throw new InvalidInputException("Search keyword cannot be empty.");
		}
		List<Payment> list = paymentDAL.getByPaymentDescription(keyword);
		if (list == null || list.isEmpty()) {
			// Could return empty list, but per requirement throw NotFound or InvalidInput:
			throw new NotFoundException("No payments found with description containing: " + keyword);
		}
		return list;
	}

	@Transactional
	public List<Payment> getAllPayments() {
		return paymentDAL.getAllPayments();
	}

	@Transactional
	public void addPayment(Payment payment) {
		if (payment == null) {
			throw new InvalidInputException("Payment cannot be null.");
		}

		// validate paymentType
		String pt = payment.getPaymentType();
		if (pt == null || !VALID_TYPES.contains(pt.trim().toLowerCase())) {
			throw new InvalidInputException("Invalid paymentType. Accepted values: Credit, Debit, Cash.");
		}

		// If id is provided and an entity already exists with that id
		int id = payment.getId();
		if (id != 0) {
			Payment existing = paymentDAL.getById(id);
			if (existing != null) {
				throw new ElementAlreadyExistException("Payment with id " + id + " already exists.");
			}
		}
		paymentDAL.addPayment(payment);
	}
}
