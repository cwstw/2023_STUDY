package game.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import utility.Paging;

@Component("myGame")
public class GameDao {
	
	private String namespace = "game.GameBean";
	
	SqlSessionTemplate sst;
	
	public GameDao() {
		System.out.println("持失切");
	}//持失切

	public List<GameBean> getAllGame(Map<String,String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<GameBean> glist = sst.selectList(namespace+".GetAllGame",map,rowBounds);
		return glist;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt=-1;
		cnt = sst.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}

	public int insertGame(GameBean gb) {
		int cnt = -1;
		cnt = sst.insert(namespace+".InsertGame",gb);
		return cnt;
	}

	public int updateGame(GameBean gb) {
		int cnt = sst.update(namespace+".UpdateGame",gb);
		return cnt;
	}

	public int deleteGame(int num) {
		int cnt = sst.update(namespace+".DeleteGame",num);
		return cnt;
	}

	public GameBean getOneGame(int num) {
		GameBean gb = sst.selectOne(namespace+".GetOneGame",num);
		return gb;
	}
	
	
	
}
