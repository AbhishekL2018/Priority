package com.abhishek.priority.service.serviceImpl;

import com.abhishek.priority.dto.AssignUserPriorityObject;
import com.abhishek.priority.dto.PriorityObject;
import com.abhishek.priority.model.PriorityModel;
import com.abhishek.priority.model.UserPriorityMapping;
import com.abhishek.priority.repository.PriorityRepository;
import com.abhishek.priority.repository.UserPriorityRepository;
import com.abhishek.priority.response.ResponseCodeJson;
import com.abhishek.priority.response.UniversalResponse;
import com.abhishek.priority.service.PriorityService;
import com.abhishek.priority.utils.AtomicIdCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private UserPriorityRepository userPriorityRepository;

    @Override
    public ResponseCodeJson addPriorityType(String priorityName) {
        ResponseCodeJson codeJson = new ResponseCodeJson();
        Optional<PriorityModel> isUserPresent = priorityRepository.findByPriorityNameAndDeleted(priorityName, false);
        if (isUserPresent.isPresent()) {
            return new ResponseCodeJson("priority type already present", 403);
        }
        PriorityModel priorityModel = new PriorityModel();
        Long pid = AtomicIdCounter.getUniqueID();
        priorityModel.setPriorityId(pid);
        priorityModel.setPriorityName(priorityName);
        priorityRepository.save(priorityModel);
        return new ResponseCodeJson("added priority", 200, pid);
    }

    @Override
    public UniversalResponse getPriorityDetails(long userId) {
        UniversalResponse ur = new UniversalResponse();
        Optional<UserPriorityMapping> isPresent = userPriorityRepository.findFirstByUserIdAndDeleted(userId, false);
        if (!isPresent.isPresent()) {
            ur.setResponseCodeJson(new ResponseCodeJson("UserName not found", 400));
            return ur;
        }
        List<UserPriorityMapping> userPriorityMappingList = userPriorityRepository.findAllByUserIdAndDeleted(userId, false);
        AssignUserPriorityObject assignUserPriorityObject = new AssignUserPriorityObject();
        assignUserPriorityObject.setUserId(userId);
        List<PriorityObject> priorityObjectList = new ArrayList<>();
        for (UserPriorityMapping userPriorityMapping: userPriorityMappingList) {
            PriorityObject priorityObject = new PriorityObject();
            priorityObject.setPriorityId(userPriorityMapping.getPriorityId());
            priorityObject.setPriorityOrder(userPriorityMapping.getPriorityOrder());
            priorityObject.setPriorityScale(userPriorityMapping.getPriorityScale());
            priorityObjectList.add(priorityObject);
        }
        assignUserPriorityObject.setPriorityObjectList(priorityObjectList);
        ur.setResponseCodeJson(new ResponseCodeJson("fetched priority details", 200));
        ur.setObject(assignUserPriorityObject);
        return ur;
    }
}
