package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMovie")
public class MovieDao {
	
	private String namespace = "movie.MovieBean";
	
	@Autowired
	SqlSessionTemplate sst;
	
	public MovieDao() {
		System.out.println("»ý¼ºÀÚ");
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
	
	
	
}
