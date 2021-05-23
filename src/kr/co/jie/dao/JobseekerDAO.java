package kr.co.jie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.jie.dto.JobseekerDTO;
import kr.co.jie.dao.StartEnd;

public class JobseekerDAO{
	@Autowired
	SqlSession ss;
	
	//loginOk
	public JobseekerDTO loginOk(JobseekerDTO dto){
		JobseekerDTO jdto = ss.selectOne("kr.co.jie.jobLoginOk",dto);
		System.out.println(jdto.getMember_type());
		System.out.println("job login Ok");
		return jdto;		
	}
	
	//signUp(join) Ok
	public void signUpOk(JobseekerDTO dto){
		ss.insert("kr.co.jie.jobSignUp",dto);
		System.out.println("job signUp Ok");
	}
	
	public void modifyJobInfo(JobseekerDTO dto){
		ss.update("kr.co.jie.Profile.modifyJobProfile",dto);
	}
	
	// 태영 파트
	// jobseeker_no를 이용한 jobseeker 한 명의 정보 출력
	public JobseekerDTO selectByNo(int jobseeker_no) {
		
		return ss.selectOne("kr.co.jie.jobseeker.jobseekerSelectByNo", jobseeker_no);
	}
	
	// 키워드를 이용한 전체 리스트 출력 ( 키워드가 null이면 전체 )
	public List<JobseekerDTO> selectAll(int start, int end, String keyword) {
		StartEnd se = new StartEnd(start, end, keyword);
		
		return ss.selectList("kr.co.jie.jobseeker.jobseekerSelectByKeyword", se);
	}
	
	// 검색 게시물 숫자 구하기
	public int getTotal(String keyword) {
		
		return ss.selectOne("kr.co.jie.jobseeker.getTotal", keyword);
	}
	// 태영 파트
	
	// 성진 파트
	// 전체 목록 보기
	public List<JobseekerDTO> selectAllJobseeker(int start, int end, String keyword){
		StartEnd se = new StartEnd(start, end, keyword);
		return ss.selectList("kr.co.jie.jobseeker.selectJobseeker",se);
	}

	public int getTotalJobseeker(String keyword) {
		
		return ss.selectOne("kr.co.jie.jobseeker.getTotalJobseeker", keyword);
	}
	
	
	// 목록 삭제
	public void deleteOne(int jobseeker_no){
		ss.delete("kr.co.jie.jobseeker.jobseekerDeleteOne", jobseeker_no);
	}
}
