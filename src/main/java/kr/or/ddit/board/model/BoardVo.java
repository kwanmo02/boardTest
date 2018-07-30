package kr.or.ddit.board.model;

public class BoardVo {
	private int board_no;
	private String board_name;
	private String board_yn;
	
	
	public BoardVo() {

	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_yn() {
		return board_yn;
	}
	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}
	
	public BoardVo(int board_no, String board_name, String board_yn) {
		super();
		this.board_no = board_no;
		this.board_name = board_name;
		this.board_yn = board_yn;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_name=" + board_name
				+ ", board_yn=" + board_yn + "]";
	}
	
	
}
