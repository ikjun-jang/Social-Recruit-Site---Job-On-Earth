package kr.co.jie.dao;

import java.util.List;








import kr.co.jie.dto.Cafe_BoardDTO;
import kr.co.jie.dto.Cafe_MemberDTO;
import kr.co.jie.dto.Com_StartEnd;
import kr.co.jie.dto.CommunityDTO;
import kr.co.jie.dto.JobseekerDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunityOracleDAO implements CommunityBoardDao {
	@Autowired
	SqlSession ss;

	//카페 만들기
	@Override
	public void insertCafe(CommunityDTO dto) {
		ss.insert("insertCafe", dto);
		
	}
	//처음 까페 입력글
	@Override
	public void insertCafe_first(Cafe_BoardDTO dto) {
		ss.insert("insertCafe_first", dto);
	}

	
	@Override //오리지날
	public List<Cafe_BoardDTO> selectAll2(Cafe_BoardDTO dto) {
		return ss.selectList("cafe_SelectAll2", dto);
	}
	@Override//페이징처리하기위해서..
	public List<Cafe_BoardDTO> selectAll(int start, int end) {
		
		Com_StartEnd se = new Com_StartEnd();
		System.out.println("시작 :" +se.getStart());;
		System.out.println("끝 :" +se.getEnd());;
		
		return ss.selectList("cafe_SelectAll", se);
	}
	//카페게시물쓰기
	@Override
	public void insertOne(Cafe_BoardDTO dto2) {
		System.out.println("dto커맨드넘어오는지 확인중 :" +dto2);
		ss.insert("board_Insert", dto2);
	}
	//게시물 조회
	@Override
	public Cafe_BoardDTO selectOne(int bno) {
		return ss.selectOne("selectOne", bno);
	}
	//게시물 삭제
	@Override
	public void deleteOne(int bno) {
		ss.delete("deleteOne", bno);
	}
	@Override
	public void updateOne(Cafe_BoardDTO dto) {
		ss.update("updateOne",dto);
	}
	@Override
	public void updateRecom(int bno) {
		ss.update("rasieRecom", bno);
	}
	//총게시물수
	@Override
	public int oneTotal(Cafe_BoardDTO dto2) {
		return ss.selectOne("getOneTotal",dto2);
	}
	public int allTotal(){
		return ss.selectOne("com_getTotal");
	}
	/*//게시물번호 row로 가져오기
	@Override
	public int cafe_b_no(Cafe_BoardDTO dto2) {
		return ss.selectOne("cafe_list_num", dto2);
	}*/
	/*@Override
	public int countList(Cafe_BoardDTO dto2) {
		return ss.selectOne("countList",dto2);
	}*/
	
	//전체_까페조회
	/*@Override //오리지날
	public List<Cafe_BoardDTO> selectAll2(Cafe_BoardDTO dto) {
		return ss.selectList("cafe_SelectAll2", dto);
	}*/
	
	
	@Override
	public List<CommunityDTO> selectAll_CafeList(CommunityDTO dto) {
		// TODO Auto-generated method stub
		return ss.selectList("cafe_selectAll_list", dto);
	}
	@Override
	public void insertMember(Cafe_MemberDTO dto3) {
		ss.insert("insertMember", dto3);
	}
	@Override
	public int memberCount(Cafe_MemberDTO dto3) {
		return ss.selectOne("memberCount", dto3);
	}
	@Override
	public void updateMemberCount(CommunityDTO dto) {
		ss.update("updateMemberCount", dto);
	}
	@Override
	public JobseekerDTO showID(JobseekerDTO dto) {
		return ss.selectOne("jobseekerSelectByNo", dto);
	}
	
	
	
	
	
	

}
