package com.sse.ooseproject.controllers;

import com.sse.ooseproject.RoomRepository;
import com.sse.ooseproject.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Sort;

import java.util.List;

@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public String rooms(@RequestParam(name = "sort_by", required = false, defaultValue = "name") String sortBy,
                        @RequestParam(name = "sort_asc", required = false, defaultValue = "true") boolean sortAsc,
                        Model model) {
        Sort sort = sortAsc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Room> rooms = roomRepository.findAll(sort);

        model.addAttribute("rooms", rooms);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        return "rooms";
    }
}

