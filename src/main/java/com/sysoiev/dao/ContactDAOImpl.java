package com.sysoiev.dao;

import com.sysoiev.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Contact> allNotes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Contact").list();
    }

    @Override
    @Transactional
    public void add(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(contact);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(contact);
    }

    @Override
    @Transactional
    public void edit(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.update(contact);
    }

    @Override
    @Transactional
    public Contact getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Contact.class, id);
    }

}