package com.sysoiev.dao;

import com.sysoiev.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContactDAOImpl implements ContactDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Contact> contacts = new HashMap<>();


    static {
        Contact contact = new Contact();
        contact.setId(AUTO_ID.getAndIncrement());
        contact.setName("Sergey");
        contact.setSurname("Gorban");
        contact.setPhoneNumber("876-876-876");
        contact.setContactType("friend");
        contacts.put(contact.getId(), contact);

    }

    @Override
    public List<Contact> allNotes() {
        return new ArrayList<>(contacts.values());
    }

    @Override
    public void add(Contact contact) {
        contact.setId(AUTO_ID.getAndIncrement());
        contacts.put(contact.getId(), contact);
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact.getId());
    }

    @Override
    public void edit(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    @Override
    public Contact getById(int id) {
        return contacts.get(id);
    }
}
