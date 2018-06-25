package com.adolph.auth.user.service;


import com.adolph.auth.bean.JobLevel;
import com.adolph.auth.user.dao.JobLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class JobLevelService {
    @Autowired
    JobLevelDao jobLevelDao;

    public int addJobLevel(JobLevel jobLevel) {
        if (jobLevelDao.getJobLevelByName(jobLevel.getName()) != null) {
            return -1;
        }
        return jobLevelDao.addJobLevel(jobLevel);
    }

    public List<JobLevel> getAllJobLevels() {
        return jobLevelDao.getAllJobLevels();
    }

    public boolean deleteJobLevelById(String ids) {
        String[] split = ids.split(",");
        return jobLevelDao.deleteJobLevelById(split) == split.length;
    }

    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelDao.updateJobLevel(jobLevel);
    }
}
