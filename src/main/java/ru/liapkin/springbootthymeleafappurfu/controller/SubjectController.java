package ru.liapkin.springbootthymeleafappurfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.liapkin.springbootthymeleafappurfu.dao.SubjectRepository;
import ru.liapkin.springbootthymeleafappurfu.entity.Subject;

import java.util.Optional;

@Slf4j
@RequestMapping("/subjects")
@Controller
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllSubjects() {
        log.info("/subjects/list -> connection");
        ModelAndView mav = new ModelAndView("list-subjects");
        mav.addObject("subjects", subjectRepository.findAll());
        return mav;
    }

    @GetMapping("/addSubjectForm")
    public ModelAndView addSubjectForm() {
        ModelAndView mav = new ModelAndView("add-subject-form");
        Subject subject = new Subject();
        mav.addObject("subject", subject);
        return mav;
    }

    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute Subject subject) {
        subjectRepository.save(subject);
        return "redirect:/subjects/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long subjectId) {
        ModelAndView mav = new ModelAndView("add-subject-form");
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        Subject subject = new Subject();
        if (optionalSubject.isPresent()) {
            subject = optionalSubject.get();
        }
        mav.addObject("subject", subject);
        return mav;
    }

    @GetMapping("/deleteSubject")
    public String deleteSubject(@RequestParam Long subjectId) {
        subjectRepository.deleteById(subjectId);
        return "redirect:/subjects/list";
    }

}
