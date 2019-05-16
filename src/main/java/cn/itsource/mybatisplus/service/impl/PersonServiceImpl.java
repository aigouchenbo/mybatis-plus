package cn.itsource.mybatisplus.service.impl;

import cn.itsource.mybatisplus.domain.Person;
import cn.itsource.mybatisplus.mapper.PersonMapper;
import cn.itsource.mybatisplus.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenbo
 * @since 2019-05-14
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
