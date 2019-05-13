package com.es.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * #分页工具类
 * 
 * @author Handc
 *
 */
public class Pager<T> {
    // 当前页
    private int currentPage;
    // 当前索引
    private int currentIndex;
    // 每页数量
    private int pageNum;
    // 总页数
    private int totalPage;
    // 总条数
    private int totalCount;
    // 数据列表
    List<T> list = new ArrayList<>();
    private Pager() {
        
    }
    
    public Pager(int currentPage,int pageNum,int totalCount){
        this.totalCount = totalCount;
        
        this.totalPage = (totalCount+pageNum-1)/pageNum;
        
        this.currentPage = currentPage<=0?1:currentPage>totalPage?totalPage:currentPage;
        
        this.currentIndex = (currentPage-1)*pageNum;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
