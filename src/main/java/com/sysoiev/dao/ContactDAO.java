package com.sysoiev.dao;

import com.sysoiev.model.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> allNotes();

    void add(Contact contact);

    void delete(Contact contact);

    void edit(Contact contact);

    Contact getById(int id);
}

