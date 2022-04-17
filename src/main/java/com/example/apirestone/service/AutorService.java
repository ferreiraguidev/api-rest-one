package com.example.apirestone.service;


import com.example.apirestone.controller.dtos.request.UsersPostReqBody;
import com.example.apirestone.controller.dtos.request.UsersPutReqBody;
import com.example.apirestone.model.Users;
import com.example.apirestone.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class AutorService {

    private final UsersRepository usersRepository;

    public AutorService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Could not find id"));
    }

    public Users save(UsersPostReqBody usersPostReqBody) {

        Users autor = Users.builder()
                .name(usersPostReqBody.getNome())
                .email(usersPostReqBody.getEmail())
                .password(usersPostReqBody.getSenha())
                .build();
        return usersRepository.save(autor);

    }
    public void update(UsersPutReqBody usersPutReqBody){

        Users savedAutor = findById(usersPutReqBody.getId());

        Users user = Users.builder()
                .id(usersPutReqBody.getId())
                .name(usersPutReqBody.getNome())
                .email(usersPutReqBody.getEmail())
                .password(usersPutReqBody.getSenha())
                .build();
        usersRepository.save(user);
    }
    public void delete(Long id){
        usersRepository.deleteById(id);
    }
}
