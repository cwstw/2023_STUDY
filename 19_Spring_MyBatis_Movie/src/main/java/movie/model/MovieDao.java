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
	
	public boolean searchTitle(String inputtitle) {
		boolean flag = false;
		int cnt = sst.selectOne(namespace + ".CheckTitle", inputtitle);
		if(cnt > 0) {
			flag = true; // 이미 존재함 
		}
		return flag;
	}

	public MovieBean getOneMovie(int num) {
		MovieBean mv = new MovieBean();
		mv = sst.selectOne(namespace+".GetOneMovie",num);
		return mv;
	}

	public int deleteMovie(int num) {
		int cnt = -1;
		try {
		cnt = sst.delete(namespace+".DeleteMovie",num);
		} catch(DataAccessException e){
			System.out.println("데이터 삭제 오류");
		}
		return cnt;
	}
}
