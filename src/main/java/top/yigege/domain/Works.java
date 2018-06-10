package top.yigege.domain;

import java.util.Date;
/**
 * 作品实体
 * @author yigege
 *
 */
public class Works {
	private int worksId;
	private String name;
	private Date time;
	private String imagepath;
	private String remark;
	public Works(int worksId, String name, Date time, String imagepath, String remark, int star, int comment,
			int reply) {
		super();
		this.worksId = worksId;
		this.name = name;
		this.time = time;
		this.imagepath = imagepath;
		this.remark = remark;
		this.star = star;
		this.comment = comment;
		this.reply = reply;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private int star;
	private int comment;
	private int reply;
	public int getWorksId() {
		return worksId;
	}
	public void setWorksId(int worksId) {
		this.worksId = worksId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public Works() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comment;
		result = prime * result + ((imagepath == null) ? 0 : imagepath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + reply;
		result = prime * result + star;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + worksId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Works other = (Works) obj;
		if (comment != other.comment)
			return false;
		if (imagepath == null) {
			if (other.imagepath != null)
				return false;
		} else if (!imagepath.equals(other.imagepath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (reply != other.reply)
			return false;
		if (star != other.star)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (worksId != other.worksId)
			return false;
		return true;
	}
	
	
	
}
