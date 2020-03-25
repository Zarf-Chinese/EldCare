package com.eldcare.service;

import com.eldcare.mapper.FeedbackMapper;
import com.eldcare.model.Feedback;
import com.eldcare.model.FeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/24 21:18
 */
@Service
public class FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Feedback feedback){
        feedback.setGmtCreate(nowTime);
        feedbackMapper.insert(feedback);
    }
    public void check(int id) {
        Feedback feedback=feedbackMapper.selectByPrimaryKey(id);
        feedback.setIsChecked(true);
        feedback.setCheckTime(nowTime);
        feedbackMapper.updateByPrimaryKey(feedback);
    }

    //当前护工未查看的评价
    public List<Feedback> listNotChecked(int id){
        FeedbackExample feedbackExample=new FeedbackExample();
        feedbackExample.createCriteria().andNurseEqualTo(id);
        List<Feedback> feedbacks=feedbackMapper.selectByExample(feedbackExample);
        List<Feedback> notChecked=null;
        for(Feedback feedback:feedbacks){
            if(!feedback.getIsChecked())
                notChecked.add(feedback);
        }
        return notChecked;
    }

}
