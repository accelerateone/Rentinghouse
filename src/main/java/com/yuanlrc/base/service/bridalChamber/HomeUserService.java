package com.yuanlrc.base.service.bridalChamber;

import com.yuanlrc.base.dao.bridalChamber.HomeUserDao;
import com.yuanlrc.base.entity.bridalChamber.HomeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeUserService {

    @Autowired
    private HomeUserDao homeUserDao;

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public HomeUser find(Long id){
        return homeUserDao.find(id);
    }
    /**
     * 通过手机号查找
     * @param userMobile
     * @return
     */
    public HomeUser findByUserMobile(String userMobile){
        return homeUserDao.findByUserMobile(userMobile);
    }

    /**
     * 通过邮箱账号查询
     */
    public HomeUser findByEmail(String email){
        return homeUserDao.findByEmail(email);
    }

    /**
     * 保存/编辑
     * @param homeUser
     * @return
     */
    public HomeUser save(HomeUser homeUser){
        return homeUserDao.save(homeUser);
    }

    /**
     * 返回前台用户总数
     * @return
     */
    public long total(){
        return homeUserDao.count();
    }

}
