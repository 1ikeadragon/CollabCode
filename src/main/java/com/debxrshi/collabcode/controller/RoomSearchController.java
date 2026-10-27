package com.debxrshi.collabcode.controller;

import com.debxrshi.collabcode.service.util.QueryInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoomSearchController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/rooms/search", produces = "application/json")
    public ResponseEntity<List<Map<String, Object>>> searchRooms(@RequestParam String lang) {
        String sql = "SELECT uuid, lang FROM Rooms WHERE lang = '" + QueryInput.clean(lang) + "' ORDER BY id DESC LIMIT 50";
        return ResponseEntity.ok(jdbcTemplate.queryForList(sql));
    }
}
