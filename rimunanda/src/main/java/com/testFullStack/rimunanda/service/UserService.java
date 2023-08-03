package com.testFullStack.rimunanda.service;

import com.testFullStack.rimunanda.dao.UserDao;
import com.testFullStack.rimunanda.dao.UserProductDao;
import com.testFullStack.rimunanda.dto.UsersDto;
import com.testFullStack.rimunanda.entity.Users;
import com.testFullStack.rimunanda.exception.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao dao;
    private final UserProductDao userProductDao

    public void save(UsersDto.Save data){
        this.dao.save(data);
    }

    public List<Users> findAll(){
        return this.dao.findAll();
    }

    public Users findById(Integer id){
        return this.dao.findById(id)
                .orElseThrow( () -> new IdNotFoundException("user dengan id "+ id + " tidak ditemukan"));
    }

    public void update(Integer id, UsersDto.Update data){
        findById(id);
        this.dao.update(id,data);
    }

    public void delete(Integer id){
        findById(id);
        this.userProductDao.deleteByUser(id);
        this.dao.delete(id);
    }
}
