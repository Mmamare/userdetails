package com.example.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.entity.UserData;

@Repository
public interface UserRepo extends CrudRepository<UserData, Long> {
	UserData findUserByUniqueId(String uniqueId);

}
