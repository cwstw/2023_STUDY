package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class BoardDao {
	
	private String namespace="board.BoardBean";
	
	@Autowired
	SqlSessionTemplate sst;
	
	public BoardDao(){
		System.out.println("BoardDao() »ý¼ºÀÚ");
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sst.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	public List<BoardBean> getBoardList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<BoardBean> lists = new ArrayList<BoardBean>();
		lists = sst.selectList(namespace+".GetBoardList",map,rowBounds);
		return lists;
	}

	public int insertBoard(BoardBean bb) {
		int cnt = -1;
		cnt = sst.insert(namespace+".InsertBoard",bb);
		return cnt;
	}

	public BoardBean getBoardByNum(int num) {
		 BoardBean bb = sst.selectOne(namespace+".GetTotalCount",num);
		return bb;
	}

	public BoardBean checkByPasswd(BoardBean check) {
		BoardBean bb = sst.selectOne(namespace+".CheckByPasswd",check);
		return bb;
	}

	public int updateBoard(BoardBean bb) {
		int cnt = -1;
		cnt = sst.update(namespace+".UpdateBoard",bb);
		return cnt;
	}

	public int deleteBoard(int num) {
		int cnt = -1;
		cnt = sst.delete(namespace+".DeleteBoard",num);
		return cnt;
	}

	public int UpdateReplyCount(BoardBean bb) {
		int cnt = -1; 
		cnt = sst.update(namespace+".UpdateReplyCount",bb);
		return cnt;
	}

	public int insertReply(BoardBean bb) {
		int cnt = -1;
		cnt = sst.insert(namespace+".InsertReply",bb);
		return cnt;
	}

	
	
	
}
