package service;

import dao.EldDaoImpl;
import dao.IEldDao;
import entity.Elder;

import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/10/23-19:43
 */
public class EldServiceImpl implements IEldService {
    IEldDao eldDao=new EldDaoImpl();
        //查询全部老人
    public List<Elder> queAllEld() {
            return eldDao.queAllEld();
    }
}
