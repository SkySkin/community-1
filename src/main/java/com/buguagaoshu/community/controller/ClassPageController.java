package com.buguagaoshu.community.controller;

import com.buguagaoshu.community.cache.HotQuestionCache;
import com.buguagaoshu.community.cache.HotTagCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Pu Zhiwei {@literal puzhiweipuzhiwei@foxmail.com}
 * create          2019-09-16 21:56
 */
@Controller
public class ClassPageController {
    private final HotTagCache hotTagCache;

    private final HotQuestionCache hotQuestionCache;

    @Autowired
    public ClassPageController(HotTagCache hotTagCache, HotQuestionCache hotQuestionCache) {
        this.hotTagCache = hotTagCache;
        this.hotQuestionCache = hotQuestionCache;
    }

    @GetMapping("/class")
    public String getClassPage(Model model) {
        model.addAttribute("hotQuestions", hotQuestionCache.getHotQuestionDTOList());
        List<String> hots = hotTagCache.getHots();
        model.addAttribute("hots", hots);
        return "class";
    }
}
