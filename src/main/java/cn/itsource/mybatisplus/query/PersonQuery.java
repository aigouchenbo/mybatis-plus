package cn.itsource.mybatisplus.query;


import cn.itsource.mybatisplus.query.BaseQuery;

/**
 *
 * @author chenbo
 * @since 2019-05-14
 */
public class PersonQuery extends BaseQuery {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}