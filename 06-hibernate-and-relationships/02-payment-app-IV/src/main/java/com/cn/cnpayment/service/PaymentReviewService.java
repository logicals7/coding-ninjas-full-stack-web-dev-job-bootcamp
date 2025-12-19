package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.entity.PaymentReview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentReviewService {

// Autowire the PaymentReviewDAL object.
	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		/**
		   1. This method fetches PaymentReview for a specific id.
		   2. If no paymentReview is found then it throws NotFoundException.
		**/
		PaymentReview review = paymentReviewDAL.getById(id);
		if (review == null) {
			throw new NotFoundException("Review with given id is not there!!");
		}
		return review;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		/**
		 1. This method fetches the list of all PaymentReviews.
		 2. If no paymentReview is found then it throws NotFoundException.
		 **/
		List<PaymentReview> reviews = paymentReviewDAL.getAllPaymentReview();
		if (reviews == null || reviews.isEmpty()) {
			throw new NotFoundException("No review found!!");
		}
		return reviews;
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {
		/**
		 1. This method first checks if the given paymentReview exists or not.
		 2. If the given paymentReview is not found, then it saves the PaymentReview entity into the database.
		 3. If found then it throws ElementAlreadyExistException.
		 **/
		// Check if ID exists directly rather than calling the method that throws NotFoundException
		if (newPaymentReview.getId() != 0 && paymentReviewDAL.getById(newPaymentReview.getId()) != null) {
			throw new ElementAlreadyExistException("Review already exists!!");
		}
		paymentReviewDAL.save(newPaymentReview);
	}

	@Transactional
	public void delete(int id) {
		/**
		 1. This method deletes PaymentReview for a specific id.
		 2. If no paymentReview is found for the given id, then it throws NotFoundException.
		 **/
		if(getPaymentReviewById(id) == null) throw new NotFoundException("Payment review not exists!!");
		paymentReviewDAL.delete(id);
	}

	@Transactional
	public List<PaymentReview> getPaymentReviewByQueryType(String queryType) {
		/**
		 1. This method fetches the list of PaymentReview based on the queryType received.
		 2. Passing an empty queryType throws InvalidInputException.
		 3. Only the following queryType are accepted in any format i.e. UpperCase/LowerCase
		 "Payment Issue","Bank Issue", "Merchant Issue"
		 **/
		if (queryType == null || queryType.trim().isEmpty())
			throw new InvalidInputException("queryType is invalid.");
		List<PaymentReview> reviews = paymentReviewDAL.getByQueryType(queryType);
		return reviews;

	}

}
