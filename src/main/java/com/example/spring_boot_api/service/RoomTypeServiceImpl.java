package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.entity.RoomType;
import com.example.spring_boot_api.repository.RoomRepository;
import com.example.spring_boot_api.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomService roomService;
    private void updateRoomPriceAndArea(Room room) {
        List<RoomType> roomTypes = this.getRoomTypesByRoomId(room.getId());

        double minPrice = roomTypes.stream().mapToDouble(RoomType::getPrice).min().orElse(0);
        double maxPrice = roomTypes.stream().mapToDouble(RoomType::getPrice).max().orElse(0);
        double minArea = roomTypes.stream().mapToDouble(RoomType::getArea).min().orElse(0);
        double maxArea = roomTypes.stream().mapToDouble(RoomType::getArea).max().orElse(0);

        room.setMinPrice(minPrice);
        room.setMaxPrice(maxPrice);
        room.setMinArea(minArea);
        room.setMaxArea(maxArea);

        roomRepository.save(room);
    }
    @Override
    public RoomType addRoomType(RoomType roomType) {
        Room room =roomService.getRoomById(roomType.getId());
        updateRoomPriceAndArea(room);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(Long id, RoomType roomType) {
        roomType.setId(id);
        updateRoomPriceAndArea(roomType.getRoom());
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomType getRoomTypeById(Long id) {
        Optional<RoomType> roomTypeOptional = roomTypeRepository.findById(id);
        return roomTypeOptional.orElse(null);
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public List<RoomType> searchRoomTypes(String keyword) {
        return roomTypeRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<RoomType> getRoomTypesByUser(Long userId) {
        return roomTypeRepository.findByUserId(userId);
    }

    @Override
    public List<RoomType> getRoomTypesByRoomId(Long roomId) {
        return roomTypeRepository.findByRoomId(roomId);
    }
}
