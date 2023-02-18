package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页测试
     *
     * @return
     */
    public List<User> list() {
        Page<User> page = new Page<>(1, 1);
        page = userMapper.selectPage(page, null);
        return page.getRecords();
    }

    /**
     * 乐观锁测试
     *
     * @param id
     * @param age
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void update(Long id, Integer age) {
        User user = userMapper.selectById(id);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        user.setAge(age);
        int result = userMapper.updateById(user);
        if (result != 1) {
            throw new RuntimeException("更新失败");
        }
    }
}
