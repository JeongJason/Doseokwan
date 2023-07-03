package Domain.Common.Dto;

import java.util.Date;

public class BoardDto {
	private int board_id;
	private String writer;
	private String title;
	private String content;
	private Date date;
	private Date updatedate;
	private Date deletedate;
	
	public BoardDto(){
		super();
	}
	
	
	public BoardDto(int board_id, String writer, String title, String content, Date date, Date updatedate,
			Date deletedate) {
		super();
		this.board_id = board_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
		this.updatedate = updatedate;
		this.deletedate = deletedate;
	}


	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Date getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}

	@Override
	public String toString() {
		return "BoardDto [board_id=" + board_id + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", updatedate=" + updatedate + ", deletedate=" + deletedate + "]";
	}
	
}
