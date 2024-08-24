package com.arvind.assignment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.assignment.entity.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity,Long>{

    ProfileEntity getByName(String name);
    
}
