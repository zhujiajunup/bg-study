package org.jjzhu.springmvc.dao;

import org.jjzhu.springmvc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

/**
 * Created by hzzhujiajun on 2017/7/12.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
