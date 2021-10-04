package com.natixis.chatdonback.controller;


import com.natixis.chatdonback.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CandidatureController {

    @Autowired
    CandidatureService candidatureService;
}
