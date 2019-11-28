package com.dageda.vueshiromodel.service.booksservice;

import com.dageda.vueshiromodel.entity.books.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BooksService
 * @Description: 图书Service接口
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
public interface BooksService {
    /**
     * 获取books的中记录数
     *
     * @return 记录数
     */
    Integer booksCount();

    /**
     * 获取books集合列表
     *
     * @param currentPage 起始页
     * @param pageSize    页大小
     * @return books集合列表
     */
    List<Books> getBooksList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 添加books数据
     *
     * @param books books实体类
     * @return 添加完成的主键id
     */
    Integer insertBooks(Books books);

    /**
     * 删除books一条记录
     *
     * @param id books的id
     * @return 成功条数
     */
    Integer deleteBooks(@Param("id") Integer id);

    /**
     * 修改books记录
     *
     * @param books books实体类
     * @return 成功条数
     */
    Integer updateBooks(Books books);
}
