package com.debxrshi.collabcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debxrshi.collabcode.model.Code;
import com.debxrshi.collabcode.model.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByUuidAndRoomKey(String uuid, String roomKey);
}
