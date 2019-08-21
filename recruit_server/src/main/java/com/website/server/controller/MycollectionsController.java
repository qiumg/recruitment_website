package com.website.server.controller;

import com.website.server.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MycollectionsController {
    @Autowired
    private CollectionsService collectionsService;
    @RequestMapping("collections")
    public List<Integer> collections(Integer userId) {
        return collectionsService.selectjid(userId);
    }
}
