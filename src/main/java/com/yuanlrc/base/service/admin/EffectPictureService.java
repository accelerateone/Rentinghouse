package com.yuanlrc.base.service.admin;

import com.yuanlrc.base.dao.admin.EffectPictureDao;
import com.yuanlrc.base.entity.bridalChamber.EffectPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EffectPictureService {

    @Autowired
    private EffectPictureDao effectPictureDao;

    public List<EffectPicture> saveAll(List<EffectPicture> effectPictures){
        return effectPictureDao.saveAll(effectPictures);
    }

}
