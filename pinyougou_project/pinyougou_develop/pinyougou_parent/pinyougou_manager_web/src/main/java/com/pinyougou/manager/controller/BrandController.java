package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("/findAll.do")
    public List<TbBrand> findAll() {
        return  brandService.findAll();
    }

    /**
     * 分页查询
     * @param page 当前页码
     * @param rows 当前页记录数
     * @return
     */
    @RequestMapping("/findPage.do")
    public PageResult findPage(int page,int rows){
        return  brandService.findPage(page,rows);
    }

    @RequestMapping("/add.do")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }
    @RequestMapping("/findOne.do")
    public TbBrand findOne(long id) {
        return  brandService.fingOne(id);
    }
    @RequestMapping("/update.do")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"更新失败");
        }
    }

    @RequestMapping("/delete.do")
    public Result delete(long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"删除失败");
        }
    }
    @RequestMapping("/search.do")
    public PageResult search(@RequestBody TbBrand brand,int page,int rows) {
        return brandService.findPage(brand,page,rows);
    }

    @RequestMapping("/selectOptionList.do")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
