package spms.controls;

import java.util.Map;

import bind.DataBinding;
import spms.dao.MySqlMemberDao;

public class MemberDeleteController implements Controller, DataBinding {
	
	//의존객체 주입(DI) 인스턴스 변수와 셋터 메소드
	MySqlMemberDao memberDao;
	public MemberDeleteController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
				 "no", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//		MemberDao memberDao = (MemberDao)model.get("memberDao");
		Integer no = (Integer)model.get("no");
//		memberDao.delete(Integer.parseInt((String)model.get("no")));
		memberDao.delete(no);
		return "redirect:list.do";
	}

}
