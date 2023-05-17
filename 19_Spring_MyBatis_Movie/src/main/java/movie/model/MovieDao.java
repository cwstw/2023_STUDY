package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMovie")
public class MovieDao {
	
	private String namespace = "movie.MovieBean";
	
	@Autowired
	SqlSessionTemplate sst;
	
	public MovieDao() {
		System.out.println("생성자");
	}

	public int getTotalCount(Map<String, String> map) {
		int totalCount = -1;
		totalCount = sst.selectOne(namespace+".GetTotalCount",map);
		return totalCount;
	}

	public List<MovieBean> getAllMovie(Map<String, String> map, Paging pageInfo) {
		List<MovieBean> lists = new ArrayList<MovieBean>();
		RowBounds rb = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());;
		lists = sst.selectList(namespace+".GetAllMovie",map,rb);
		return lists;
	}
	
	public int insertMovie(MovieBean mb) {
		int cnt = -1;
		try {
		cnt = sst.insert(namespace+".InsertMovie",mb);
		} catch(DataAccessException e){
			System.out.println("데이터 삽입 오류");
		}
		return cnt;
	}
	
}
