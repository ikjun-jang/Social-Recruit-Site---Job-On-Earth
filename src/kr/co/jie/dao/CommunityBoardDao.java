package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.Cafe_BoardDTO;
import kr.co.jie.dto.Cafe_MemberDTO;
import kr.co.jie.dto.CommunityDTO;
import kr.co.jie.dto.JobseekerDTO;







public interface CommunityBoardDao {
	/*//카페만들기를 하였을때 카페이름을 가지고 게시판 게시물 출력*/
	 
	public List<Cafe_BoardDTO> selectAll(int start, int end);
	public List<Cafe_BoardDTO> selectAll2(Cafe_BoardDTO dto);
	
	//카페만들기 폼에서 입력한 데이터 DB로 이동
	public void insertCafe(CommunityDTO dto);
	//처음 생성시 카페 게시물 생성
	public void insertCafe_first(Cafe_BoardDTO dto);
	//게시판 글입력
	public void insertOne(Cafe_BoardDTO dto);
	//게시물조회
	public Cafe_BoardDTO selectOne(int bno);
	//게시물삭제
	public void deleteOne(int bno);
	//게시물 수정
	public void updateOne(Cafe_BoardDTO dto);
	//추천하기
	public void updateRecom(int bno);
	//총게시물수
	public int oneTotal(Cafe_BoardDTO dto);
	public int allTotal();
	/*//한까페 게시물수
	public int countList(Cafe_BoardDTO dto);*/
	//----------------------------------------------
	
	//전체까페 조회
	public List<CommunityDTO> selectAll_CafeList(CommunityDTO dto);
	//카페회원가입시 
	public void insertMember(Cafe_MemberDTO dto3);
	public int memberCount(Cafe_MemberDTO dto3);
	public void updateMemberCount(CommunityDTO dto);
	public JobseekerDTO showID(JobseekerDTO dto);
	
}
