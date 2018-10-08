package cn.test.domain;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
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
@TableName("t_reply")
public class Reply extends Model<Reply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "replyid", type = IdType.AUTO)
    private Integer replyid;
    private Integer topicid;
    private String author;
    private String content;
    private Date createdate;


    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    protected Serializable pkVal() {
        return this.replyid;
    }

    @Override
    public String toString() {
        return "Reply{" +
        "replyid=" + replyid +
        ", topicid=" + topicid +
        ", author=" + author +
        ", content=" + content +
        ", createdate=" + createdate +
        "}";
    }
}
