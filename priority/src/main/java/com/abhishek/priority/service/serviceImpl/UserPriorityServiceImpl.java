package com.abhishek.priority.service.serviceImpl;

import com.abhishek.priority.dto.AssignUserPriorityObject;
import com.abhishek.priority.dto.PriorityObject;
import com.abhishek.priority.model.UserModel;
import com.abhishek.priority.model.UserPriorityMapping;
import com.abhishek.priority.repository.UserPriorityRepository;
import com.abhishek.priority.repository.UserRepository;
import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.service.UserPriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserPriorityServiceImpl implements UserPriorityService {

    @Autowired
    private UserPriorityRepository userPriorityRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseCodeJson assignPriority(AssignUserPriorityObject assignUserPriorityObject) {
        ResponseCodeJson codeJson = new ResponseCodeJson();
        List<UserPriorityMapping> userPriorityMappingList = new ArrayList<>();
        Optional<UserModel> isUserPresent = userRepository.findByUserIdAndDeleted(assignUserPriorityObject.getUserId(),false);
        if(isUserPresent.isEmpty()){
            return new ResponseCodeJson("UserId not valid",403);
        }
        for (PriorityObject priorityObject: assignUserPriorityObject.getPriorityObjectList()) {
            Optional<UserPriorityMapping> isUserMappingPresent = userPriorityRepository.
                    findByUserIdAndPriorityIdAndDeleted(assignUserPriorityObject.getUserId(), priorityObject.getPriorityId(), false);
            if (isUserMappingPresent.isEmpty()) {
                UserPriorityMapping userPriorityMapping = new UserPriorityMapping();
                userPriorityMapping.setPriorityOrder(priorityObject.getPriorityOrder());
                userPriorityMapping.setPriorityId(priorityObject.getPriorityId());

                int scale = priorityObject.getPriorityScale();
                if(scale >=1 && scale <=5){
                    userPriorityMapping.setPriorityScale(scale);
                }else{
                    return new ResponseCodeJson("scale should always be in the range of 1 to 5",403);
                }

                userPriorityMapping.setUserId(assignUserPriorityObject.getUserId());
                userPriorityMappingList.add(userPriorityMapping);
            }
        }
        userPriorityRepository.saveAll(userPriorityMappingList);
        return new ResponseCodeJson("Added mapping for given priority types", 200);
    }
}
