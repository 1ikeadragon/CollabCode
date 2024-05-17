package com.debxrshi.collabcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debxrshi.collabcode.model.Room;


public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByUuidAndRoomKey(String uuid, String roomKey);
}
