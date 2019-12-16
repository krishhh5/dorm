package com.dorm.service.imple;

import com.dorm.entity.PageInfo;
import com.dorm.entity.User;
import com.dorm.mapper.UserMapper;
import com.dorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")

public class UserServiceImple implements UserService {

    // 注入
    @Autowired
    private UserMapper userMapper;
    public UserServiceImple() {
        super();
    }

    @Override
    public PageInfo<User> findPageInfo(String userName, Integer userId, String studentClass, Integer pageIndex, Integer pageSize) {
            PageInfo<User> userPageInfo = new PageInfo<User>();
            userPageInfo.setPageIndex(pageIndex);
            userPageInfo.setPageSize(pageSize);
            //获取总条数
            Integer totalCount = userMapper.totalCount(userName,userId,studentClass);
            if (totalCount>0){
                userPageInfo.setTotalCount(totalCount);
                //每一页显示学生信息数
                //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
                List<User> studentList = userMapper.getStudentList(userName,userId,studentClass,
                        (userPageInfo.getPageIndex()-1)*userPageInfo.getPageSize(),userPageInfo.getPageSize());
                userPageInfo.setList(studentList);
            }
            return userPageInfo;
    }

    @Override
    public List<User> getStudentList(String userName, Integer userId, String name, String age, Integer studentAddress, String studentClass, Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public int deleteStudent(Integer userId) {
        return userMapper.deleteStudent(userId);
    }

    @Override
    public int addStudent(User student) {
        return userMapper.addStudent(student);
    }

    @Override
    public int updateStudent(User student) {
        return userMapper.updateStudent(student);
    }

    @Override
    public User findStudentById(Integer userId) {
        return userMapper.findStudentById(userId);   }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    //管理登陆查询
    @Override
    public User findUser(User user) {
       User u = userMapper.findUser(user);
       return u;
    }
}
