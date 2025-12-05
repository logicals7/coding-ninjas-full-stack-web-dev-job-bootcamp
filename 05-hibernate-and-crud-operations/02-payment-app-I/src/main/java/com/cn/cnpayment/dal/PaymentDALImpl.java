package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**  Note: Session annotation will be imported through "org.hibernate" whereas for transactional & EntityManager
 	  annotations, you must import the Jakarta package as shown below:

	                       import jakarta.transaction.Transactional;

	  **/


/**
 				Complete the PaymentDALImpl class as mentioned below:

 								Tasks:-

				 a. Autowire EntityManager.

				 b. Override the following methods:

				 1. getById(int id) : This method fetches the payment entity from
				 the database for a specific id.

				 2. getAllPayments() : This method fetches the list of payments from
				 the database.

				 3. getByPaymentType(String paymentType) : This method fetches the list
				 of payments from the database based on the paymentType received.

				 4. getByPaymentDescription(String keyword) : This method fetches the list
				 of payments from the database based on the keyword received.

				 5. addPayment(Payment payment) : This method saves a payment entity into the
				 database.

 **/

@Repository
public class PaymentDALImpl implements PaymentDAL {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Payment.class, id);
	}

	@Override
	public List<Payment> getAllPayments() {
		Session session = entityManager.unwrap(Session.class);
		Query<Payment> query = session.createQuery("from Payment", Payment.class);
		return query.getResultList();
	}

	@Override
	public List<Payment> getByPaymentType(String paymentType) {
		Session session = entityManager.unwrap(Session.class);
		Query<Payment> query = session.createQuery(
				"from Payment p where lower(p.paymentType) = :pt", Payment.class);
		query.setParameter("pt", paymentType.toLowerCase());
		return query.getResultList();
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword) {
		Session session = entityManager.unwrap(Session.class);
		Query<Payment> query = session.createQuery(
				"from Payment p where lower(p.description) like :kw", Payment.class);
		query.setParameter("kw", "%" + keyword.toLowerCase() + "%");
		return query.getResultList();
	}

	@Override
	public void addPayment(Payment payment) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(payment);
		session.flush();
	}
}
