package com.group.libraryapprimi.service.user;

import com.group.libraryapprimi.domain.user.User;
import com.group.libraryapprimi.domain.user.UserRepository;
import com.group.libraryapprimi.dto.user.request.UserCreateRequest;
import com.group.libraryapprimi.dto.user.request.UserUpdateRequest;
import com.group.libraryapprimi.dto.user.response.UserResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * user 정보를 저장
     * @param request user 정보
     */
    public void saveUser(UserCreateRequest request) {
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    /**
     * 모든 user를 조회
     * @return users
     * @apiNote 1. class의 생성자를 통한 return, 2.stream -> map -> responseMapping을 통해 연결
     */
    public List<UserResponse> getUsers() {
        //findAll 모든 데이터를 가져온다.
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

        //return userRepository.findAll()
        //        .stream()
        //        .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge())).collect(Collectors.toList());
    }

    /**
     * user 정보 update
     * @param request user 정보
     */
    public void updateUser(UserUpdateRequest request) {
        //select * from user where id = ?;
        //Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(user.getName());
        userRepository.save(user);
    }

    /**
     * user 정보 삭제
     * @param name 이름
     */
    public void deleteUser(String name){
        //select * from user where name = ?
        //User user = userRepository.findByName(name).orElseThrow(IllegalAccessError::new);
        //userRepository.delete(user);

        if (!userRepository.existsByName(name)) {
            throw new IllegalArgumentException();
        }

        Optional<User> user = userRepository.findByName(name);
        userRepository.delete(user.get());

    }




}
