package cn.itsource.mybatisplus.mapper;

import cn.itsource.mybatisplus.domain.Person;
import cn.itsource.mybatisplus.query.PersonQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenbo
 * @since 2019-05-14
 */
public interface PersonMapper extends BaseMapper<Person> {

    IPage<Person> selectByQuery(Page<Person> page, PersonQuery query);

}
