package com.debxrshi.collabcode.repository;

import com.debxrshi.collabcode.models.Code;
import com.debxrshi.collabcode.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByUuidAndRoomKey(String uuid, String roomKey);
}
