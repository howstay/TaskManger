package org.example.taskmanager.Controller;

import org.example.taskmanager.POJO.DTO.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    ArrayList<UserDTO> users = new ArrayList<>();

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
        for (UserDTO user : users) {
            if (user.getName().equals(userDTO.getName()) && user.getPassword().equals(userDTO.getPassword())) {
                return "该账号已被注册";
            }
        }
        users.add(userDTO);
        return "注册成功";
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO userDTO) {
        for (UserDTO user : users) {
            if (user.getName().equals(userDTO.getName()) && user.getPassword().equals(userDTO.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
