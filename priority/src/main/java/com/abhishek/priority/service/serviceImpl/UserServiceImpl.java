package com.abhishek.priority.service.serviceImpl;

import com.abhishek.priority.model.UserModel;
import com.abhishek.priority.repository.UserRepository;
import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.service.UserService;
import com.abhishek.priority.utils.AtomicIdCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseCodeJson addUser(String userName) {
        ResponseCodeJson codeJson = new ResponseCodeJson();
        Optional<UserModel> isUserPresent = userRepository.findByUserNameAndDeleted(userName, false);
        if (isUserPresent.isPresent()) {
            return new ResponseCodeJson("user already present", 403);
        }
        UserModel userModel = new UserModel();
        Long uid = AtomicIdCounter.getUniqueID();
        userModel.setUserId(uid);
        userModel.setUserName(userName);
        userRepository.save(userModel);
        return new ResponseCodeJson("added user", 200, uid);
    }
}
