package com.eldcare.service;

import com.eldcare.mapper.FeedbackMapper;
import com.eldcare.model.Feedback;
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

    public List<Feedback> listAll() {
        return feedbackMapper.selectAll();
    }
    public List<Feedback> listNotChecked(){
        return feedbackMapper.selectNotChecked();
    }
}
