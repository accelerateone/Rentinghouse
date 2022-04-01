package com.yuanlrc.base.dao.bridalChamber;

import com.yuanlrc.base.entity.bridalChamber.HomeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeUserDao extends JpaRepository<HomeUser,Long> {

    /**
     * 根据id来查询
     * @param id
     * @return
     */
    @Query("select hu from HomeUser hu where id = :id")
    HomeUser find(@Param("id")Long id);

    /**
     * 通过手机号查询
     * @param userMobile
     * @return
     */
    HomeUser findByUserMobile(@Param("userMobile")String userMobile);

    /**
     * 通过邮箱查询
     */
    HomeUser findByEmail(@Param("email")String email);

}
