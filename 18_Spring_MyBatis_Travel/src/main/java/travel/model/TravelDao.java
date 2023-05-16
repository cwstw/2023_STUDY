package travel.model;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {
	
	
	//mapper namespece
	private String namespace = "travel.TravelBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//mapper와 config 경로, DB 연결 정보 등이 담긴 객체
	
	public TravelDao() {
		System.out.println("TravelDao() 생성자");
	}

	public List<TravelBean> getAllTravel(Map<String,String> map, Paging pageInfo) {
		List<TravelBean> lists = new ArrayList<TravelBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		//offset :  건너뛸 갯수, limits  : 보여줄 갯수
		lists = sqlSessionTemplate.selectList(namespace+".GetAllTravel",map,rowbounds);
		System.out.println("lists.size() : "+lists.size());
		
		return lists;
	}

	public int insertTravel(TravelBean tb) {
		int cnt = -1;
		try {
		cnt = sqlSessionTemplate.insert(namespace+".InsertTravel",tb);
		} catch(DataAccessException e){
			System.out.println("데이터 삽입 오류");
		}
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	public TravelBean getOneTravel(int num) {
		TravelBean tb = new TravelBean();
		tb = sqlSessionTemplate.selectOne(namespace+".GetOneTravel",num);
		return tb;
	}

	public int updateTravel(TravelBean tb) {
		int cnt = -1;
		try {
		cnt = sqlSessionTemplate.update(namespace+".UpdateTravel",tb);
		} catch(DataAccessException e){
			System.out.println("데이터 수정 오류");
		}
		return cnt;
	}

	public int deleteTravel(int num) {
		int cnt = -1;
		try {
		cnt = sqlSessionTemplate.delete(namespace+".DeleteTravel",num);
		} catch(DataAccessException e){
			System.out.println("데이터 삭제 오류");
		}
		return cnt;
	}
	
}
