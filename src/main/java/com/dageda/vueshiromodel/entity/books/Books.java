package com.dageda.vueshiromodel.entity.books;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Books
 * @Description: 图书类
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
public class Books {
    private Integer id;
    /** 图书名称 haha */
    private String booksName;
    /** 图书库存 */
    private Integer inventory;
    /** 计入日期 */
    private Date recordDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getRecordDate() {
        return recordDate;
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Books(Integer id, String booksName, Integer inventory, Date recordDate) {
        this.id = id;
        this.booksName = booksName;
        this.inventory = inventory;
        this.recordDate = recordDate;
    }
    public Books() {
    }


}
