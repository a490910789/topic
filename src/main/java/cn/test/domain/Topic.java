package cn.test.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2018-10-08
 */
@TableName("t_topic")
public class Topic extends Model<Topic> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "topicid", type = IdType.AUTO)
    private Integer topicid;
    private String title;
    private String content;
    private String author;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    private Integer clickamount;


    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getClickamount() {
        return clickamount;
    }

    public void setClickamount(Integer clickamount) {
        this.clickamount = clickamount;
    }

    @Override
    protected Serializable pkVal() {
        return this.topicid;
    }

    @Override
    public String toString() {
        return "Topic{" +
        "topicid=" + topicid +
        ", title=" + title +
        ", content=" + content +
        ", author=" + author +
        ", createdate=" + createdate +
        ", clickamount=" + clickamount +
        "}";
    }
}
