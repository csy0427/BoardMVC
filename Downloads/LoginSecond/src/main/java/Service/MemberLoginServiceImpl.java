package Service;

import DAO.MemberLoginDao;
import Member.Member;

import java.sql.SQLException;
import java.util.Map;

public class MemberLoginServiceImpl implements MemberService {
    MemberLoginDao memberDao=new MemberLoginDao();

    @Override
    public void add(Map<String, String> member) {
        memberDao.add(member);
    }

    @Override
    public void update(Member member) {

    }
    @Override
    public Map<String, String> get(String id) {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> list() {
        try {
            return memberDao.getUserInfos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
