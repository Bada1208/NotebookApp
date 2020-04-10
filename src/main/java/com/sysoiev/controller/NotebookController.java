package com.sysoiev.controller;

import com.sysoiev.dao.ContactDAO;
import com.sysoiev.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NotebookController {
    private ContactDAO contactDAO;

    @Autowired
    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allNotes() {
        List<Contact> notes = contactDAO.allNotes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notes);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Contact contact = contactDAO.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("contact", contactDAO.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editContact(@ModelAttribute("contact") Contact contact) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        contactDAO.edit(contact);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact") Contact contact) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        contactDAO.add(contact);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteContact(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Contact contact = contactDAO.getById(id);
        contactDAO.delete(contact);
        return modelAndView;
    }
}
