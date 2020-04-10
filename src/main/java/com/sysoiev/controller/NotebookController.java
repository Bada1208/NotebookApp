package com.sysoiev.controller;

import com.sysoiev.dao.ContactDAO;
import com.sysoiev.dao.ContactDAOImpl;
import com.sysoiev.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NotebookController {
    private ContactDAO contactDAO = new ContactDAOImpl();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allNotes() {
        List<Contact> notes = contactDAO.allNotes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notes);
        return modelAndView;
    }

}
