package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {
    User getUserByUsername(String username);

    List<User> lookPerson(String username, String  roleName);

    List<User> getStudentListByCourseId(Integer courseId);

    List<User> getAllTeachersBySchoolId(Integer schoolId);
}
