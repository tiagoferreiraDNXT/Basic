package com.example.demo.Services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.User;
import com.example.demo.Repos.UserRepository;


@Service
public class UserService {

@Autowired
private UserRepository userRepository;


//@PostConstruct
//public void init() {
//	userRepository.saveAll(
//			Stream.of(
//					new User(1,"user1",null),
//					new User(2,"user2",null)
//					).collect(Collectors.toList()));
//}

public User createUser(User user) {
	return userRepository.save(user);
}

public List<User> createUsers(List<User> users){
	return userRepository.saveAll(users);
}

public User getUserById(int id) {
	return userRepository.findById(id).orElse(null);
}

public List<User> getAllUsers(){
	return userRepository.findAll();
}

public User updateUser(User user) {
	User oldUser;
	Optional<User> changeUser=userRepository.findById(user.getId());
	if(changeUser.isPresent()) {
		oldUser=changeUser.get();
		oldUser.setName(user.getName());
		oldUser.setId(user.getId());
		oldUser.setListPc(user.getListPc());
	}
	else {
		return new User(user.getId(),user.getName(),user.getListPc());
		
	}
	return oldUser;
}

public String deleteUserById(int id) {
	 userRepository.deleteById(id);
	 return "Deleted User with id="+id;
}

}
