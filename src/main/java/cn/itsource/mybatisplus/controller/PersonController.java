package cn.itsource.mybatisplus.controller;

import cn.itsource.mybatisplus.query.PersonQuery;
import cn.itsource.mybatisplus.service.IPersonService;
import cn.itsource.mybatisplus.domain.Person;
import cn.itsource.mybatisplus.util.AjaxResult;
import cn.itsource.mybatisplus.util.PageList;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    public IPersonService personService;

    /**
    * 保存和修改公用的
    * @param person  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Person person){
        try {
            if(person.getId()!=null){
                personService.updateById(person);
            }else{
                personService.save(person);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Integer id){
        try {
            personService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Person get(@RequestParam(value="id",required=true) Long id)
    {
        return personService.getById(id);
    }


    /**
    * 查看所有信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Person> list(){

        return personService.list();
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Person> json(@RequestBody PersonQuery query)
    {
        //自己构建条件
        IPage<Person> iPage = new Page<Person>(query.getPage(), query.getSize());
        //条件构造器
        QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(query.getName())) {
            queryWrapper.like("username", query.getName());
        }

        IPage<Person> page = personService.page(iPage,queryWrapper);
        List<Person> rows = page.getRecords();
        long total = page.getTotal();
        return new PageList<>(total,rows);
    }
}
