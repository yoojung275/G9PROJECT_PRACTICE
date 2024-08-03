package org.g9project4.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.g9project4.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController{

    private final BoardDataRepository boardDataRepository;

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoard form, Model model) {

        return "front/board/write";
    }

    @GetMapping("/update")
    public String update() {

        return "redirect:/board/list";
    }

    @PostMapping("/save")
    public String save(@Valid RequestBoard form, Model model, Errors errors) {
        String mode = form.getId() == null ? "update" : "write";

        if (errors.hasErrors()) {
            return "front/board/" + mode;
        }
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String view() {

        return "front/board/view";
    }

    @GetMapping("/list")
    public String list() {

        return "front/board/list";
    }

    @PostMapping("/delete")
    public String delete() {

        return "redirect:/front/board/list";
    }


}
