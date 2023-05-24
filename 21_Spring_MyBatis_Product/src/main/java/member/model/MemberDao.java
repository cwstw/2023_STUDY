package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import product.model.ProductBean;
import utility.Paging;

@Component("myMember")
public class MemberDao {

	private String namespace="member.model.Member";
	
	SqlSessionTemplate sst;
	
	public MemberDao(){
		System.out.println("MemberDao() ������");
	}

	public int insertMember(MemberBean mb) {
		int cnt = -1;
		cnt = sst.insert(namespace+".InsertMember",mb);
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sst.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	public List<MemberBean> getMemberList(Paging pageInfo, Map<String, String> map) {
		List<MemberBean> lists = new ArrayList<MemberBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sst.selectList(namespace+".GetAllMember",map,rowBounds);
		return lists;
	}

	public int deleteMember(String id) {
		int cnt = sst.delete(namespace+".DeleteMember",id);
		return cnt;
	}

	public MemberBean getOneMember(String id) {
		MemberBean mb = sst.selectOne(namespace+".GetOneMember",id);
		return mb;
	}

	public int updateMember(MemberBean mb) {
		int cnt = sst.update(namespace+".UpdateMember",mb);
		return cnt;
	}

	public int increasePoint(String mid) {
		int cnt = sst.update(namespace+".IncreasePoint",mid);
		return cnt;
	}

}


