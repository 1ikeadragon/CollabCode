package com.debxrshi.collabcode.controllers;

import com.debxrshi.collabcode.models.Room;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoomController {


    /*
     * req -> /createRoom -> d.lang (d.user inferred) d.roomKey
     * res -> UUID(username), roomCreate(UUID, lang) -> CodeExec url -> http://127.1/room/UUID
     * req -> saveBtn -> /saveCode -> d.lang (d.user inferred) d.code d.roomKey
     */


     /*
      * table schema
      * ID USER PASS EMAIL
      * CREATORID ROOMID LANG CODE ROOMKEY
      *
      */


    //TODO: PostMapping(createRoom)
    //TODO: GetMapping(joinRoom)

    @PostMapping(value = "/createRoom", consumes = "application/json", produces = "application/json")
    public String createRoom(){
        // Creates Room object and assigns values to fields.
        String uuid = null;
        return uuid;
    }

    @GetMapping(value = "/joinRoom", consumes = "application/json", produces = "application/json")
    public void joinRoom(){
        // Join room with roomKey as [GET] returns HTTP.200/401
    }

    @PutMapping(value = "/saveState", consumes = "application/json", produces = "application/json")
    public void saveState(@RequestBody Room room ){
        // Update Code value of Room object
    }

}


