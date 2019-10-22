package com.macro.mymall.admin.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 * @author clay
 * @date 2019/10/15 17:25
 */
@Data
public class CommonPage<T> {

    /**
     * 当前页码
     */
    private Integer pageNumer;
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     *  总页数
     */
    private Integer totalPage;
    /**
     *  总数量
     */
    private Long total;
    /**
     * 业务数据
     */
    private List<T> list;
    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T>CommonPage<T> restPage(List<T> list) {
        CommonPage<T> commonPage = new CommonPage<T>();
        PageInfo<T> pageInfo  = new PageInfo<>(list);
        commonPage.setList(pageInfo.getList());
        commonPage.setPageNumer(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setTotalPage(pageInfo.getPages());
        return commonPage;
    }



}
