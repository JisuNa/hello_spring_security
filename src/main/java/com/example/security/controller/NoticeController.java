package com.example.security.controller;


import com.example.security.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @RequestMapping("/list")
    public String getList(Model model) {

        model.addAttribute("list",noticeService.getList());

        return "notice/list";
    }


}
