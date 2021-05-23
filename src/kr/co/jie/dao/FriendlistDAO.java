package kr.co.jie.dao;


import java.util.List;

import kr.co.jie.dto.FriendlistDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class FriendlistDAO {
	
	@Autowired
	SqlSession ss;
	
	// 친구 추가
	public void addFriend(FriendlistDTO dto){
		ss.insert("kr.co.jie.friendlist.addFriend", dto);
	}
	
	// 내 친구 목록 보기
	public List<FriendlistDTO> viewAllFriend(int friendlist_subno){
		System.out.println("friendlist_subno" +friendlist_subno);
		return ss.selectList("kr.co.jie.friendlist.viewmyfriend", friendlist_subno);
	}
	
	// 친구 삭제
	public void deleteFriend(int friendlist_subno){
		ss.delete("kr.co.jie.friendlist.deleteFriend", friendlist_subno);
	}
}
