package com.debxrshi.collabcode.controllers;

import com.debxrshi.collabcode.models.Room;
import com.debxrshi.collabcode.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoomController {


    @Autowired
    private RoomRepository roomRepository;
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
    //TODO: PostMapping(joinRoom)

    @PostMapping(value = "/createRoom", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createRoom(@RequestBody Room room){
        roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.OK).body("Room Created!");
    }

    @GetMapping(value = "/joinRoom", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> joinRoom(@RequestParam String uuid, String roomKey) {
        Room roomObj = roomRepository.findByUuidAndRoomKey(uuid, roomKey);
        if (roomObj != null) {
            return ResponseEntity.status(HttpStatus.OK).body(roomObj);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check your credentials! Wrong ID or KEY");
    }

    @PutMapping(value = "/saveState", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> saveState(@RequestBody Room room ){
        if(roomRepository.findByUuidAndRoomKey(room.getUuid(),room.getRoomKey()) != null){
            roomRepository.save(room);
            return ResponseEntity.status(HttpStatus.OK).body(room);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check your credentials! Wrong ID or KEY");
    }

}


