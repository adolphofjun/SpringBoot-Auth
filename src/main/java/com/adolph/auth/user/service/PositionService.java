package com.adolph.auth.user.service;

import com.adolph.auth.bean.Position;
import com.adolph.auth.user.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PositionService {
    @Autowired
    PositionDao positionDao;

    public int addPos(Position pos) {
        if (positionDao.getPosByName(pos.getName()) != null) {
            return -1;
        }
        return positionDao.addPos(pos);
    }

    public List<Position> getAllPos() {
        return positionDao.getAllPos();
    }

    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        return positionDao.deletePosById(split) == split.length;
    }

    public int updatePosById(Position position) {
        return positionDao.updatePosById(position);
    }

}
