package com.app.dao.impl;

import com.app.dao.CustomerDao;
import com.app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> findAllCustomers() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Customer", Customer.class).getResultList();

    }

    @Override
    public void saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public Customer findCustomer(long id) {
        return sessionFactory.getCurrentSession().find(Customer.class, id);
    }

    @Override
    public void deleteCustomer(long id) {
        sessionFactory.getCurrentSession()
                .delete(sessionFactory.getCurrentSession().find(Customer.class, id));
    }
}
