package Domain.Common.Dto;

import java.util.Date;

public class ReplyDto {
	private int board_id;
	private int replay_id;
	private String writer;
	private String content;
	private Date regdate;
	
	public ReplyDto() {
		super();
	}

	public ReplyDto(int board_id, int replay_id, String writer, String content, Date regdate) {
		super();
		this.board_id = board_id;
		this.replay_id = replay_id;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getReplay_id() {
		return replay_id;
	}

	public void setReplay_id(int replay_id) {
		this.replay_id = replay_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReplyDto [board_id=" + board_id + ", replay_id=" + replay_id + ", writer=" + writer + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
}
