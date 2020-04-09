package com.sysoiev.controller;

import com.sysoiev.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotebookController {
    private static Contact contact;

    static {
        contact = new Contact();
        contact.setName("Vasia");
        contact.setSurname("Pupkin");
        contact.setPhoneNumber("333-333-333");
        contact.setContactType("friend");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allNotes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

}
