package com.cyj.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class PageUtil {
    // 总页数
    private int totalPage;
    // 总记录(条数)
    private int totalCount;
    // 当前页码(1,2,3……)
    private int pageNumber;
    // 每页显示条数
    private int pageSize;
    // 当前页数据集合
    private List data;
    // 数据行数
    private int rowNum = 0;


    /**
     * 构造方法，传递每页条数和总记录数
     */
    public PageUtil() {

    }
    //总记录数和每页显示记录数构造函数
    public PageUtil(int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        if (this.totalCount % this.pageSize == 0) {
            // 计算总页数
            this.totalPage = this.totalCount / this.pageSize;
        } else {
            this.totalPage = this.totalCount / this.pageSize + 1;
        }
    }

    public PageUtil(List list,int pageSize,int pageNum,int rowNum){
        this.totalCount = list.size();
        this.pageSize = pageSize;
        this.pageNumber = pageNum;
        this.totalPage = this.totalCount / this.pageSize;
        if(this.totalCount%this.pageSize!=0) this.totalPage++;
        int begin = Math.max(0,(pageNum-1)*pageSize);
        int end = Math.min(totalCount,pageNum*pageSize);
        this.data = list.subList(begin,end);
        this.setRowNum(rowNum);
    }


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        if(rowNum!=0) this.data = getRowList(data,rowNum);
        else this.data = data;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
        if(this.data != null && this.rowNum != 0) this.data = getRowList(data,rowNum);
    }

    public static List<List<?> > getRowList(List<?> list,int rowNum){
        List<List<?>> rowList = new ArrayList<List<?>>();
        for(int i = 0,j = rowNum; i < list.size(); i += rowNum, j += rowNum){
            if(j > list.size()) {
                j = list.size();
            }
            rowList.add(list.subList(i,j));
        }
        return rowList;
    }

    public int getRowNum() {
        return rowNum;
    }
}
