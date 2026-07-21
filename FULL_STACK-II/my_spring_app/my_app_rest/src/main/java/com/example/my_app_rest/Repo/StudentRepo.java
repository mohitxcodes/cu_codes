package com.example.my_app_rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.my_app_rest.Entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

}
