package com.arvind.assignment.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.arvind.assignment.entity.ProfileEntity;
import com.arvind.assignment.models.ProfileModel;
import com.arvind.assignment.repository.ProfileRepository;
import com.arvind.assignment.services.iservices.IProfileServices;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProfileServices implements IProfileServices{

    private final ProfileRepository profileRepository;

    @Override
    public String createProfile(ProfileModel profile) {
        ProfileEntity entity=new ProfileEntity();
        BeanUtils.copyProperties(profile, entity);
       profileRepository.save(entity);
       return "Profile Saved Successfully";

    }

    @Override
    public List<ProfileModel> readAllProfile() {
       List<ProfileEntity> entityList=profileRepository.findAll();
       List<ProfileModel> modelList = new ArrayList<>();

       for (int i = 0; i< entityList.size(); i++) {
        ProfileModel model= new ProfileModel();
        ProfileEntity entity= entityList.get(i);

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());
        model.setPhone(entity.getPhone());

        modelList.add(model);
       }

       return modelList;
    }

    @Override
    public ProfileModel getProfileByName(String name) {
    ProfileEntity entity= profileRepository.getByName(name);
    ProfileModel model= new ProfileModel();
    BeanUtils.copyProperties(entity, model);
    return model;
    }
    
}
