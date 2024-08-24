package com.arvind.assignment.services.iservices;

import java.util.List;

import com.arvind.assignment.models.ProfileModel;

public interface IProfileServices {

    String createProfile(ProfileModel profile);
    List<ProfileModel> readAllProfile();
    ProfileModel getProfileByName(String name);
    
}
