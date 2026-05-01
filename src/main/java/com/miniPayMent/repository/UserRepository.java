package com.miniPayMent.repository;

import com.miniPayMent.model.CreateUserDto;
import com.miniPayMent.model.UserDto;
import com.miniPayMent.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * SELECT * FROM user WHERE name = "@param name" AND personal_id = "@param personalId"
     * @param name
     * @param personalId
     * @return
     */
    UserEntity findByNameAndPersonalId(String name, String personalId);
}
