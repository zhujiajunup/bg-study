package org.jjzhu.springmvc.dao;

import org.jjzhu.springmvc.model.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhujiajunup@163.com on 2017/7/12.
 */
@Repository
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findSpittle(String name);
    Spittle insertSpittle(Spittle spittle);
    void deleteSpittle(Long id);

}
