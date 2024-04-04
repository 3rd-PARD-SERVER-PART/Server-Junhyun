package com.pard.SecondSeminar.user.repository;

import com.pard.SecondSeminar.user.User;
import com.pard.SecondSeminar.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //파일이 저장소 역할을 할거라는걸 알려줌
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    // Create

    public void save(UserDto userDto){
        User u = User.builder()
                .studentName(userDto.getStudentName())
                .studentId(userDto.getStudentId())
                .build();
        handong.put(userDto.getStudentId(),u);
    }

    // Read
    public UserDto findById(Integer studentId){
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }
    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build()).toList();
    }

    //UPDATE

    public void update(Integer studentId, UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
//        handong.put(user.getStudentId(),user);
    }

    // DELETE

    public void delete(Integer studentId){
        handong.remove(studentId);
    }
}
