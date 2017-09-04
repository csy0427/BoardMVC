package Service;

import DAO.MemberBoardDao;
import Member.Member;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MemberBoardServiceImpl implements MemberService{
    MemberBoardDao memberBoardDao= new MemberBoardDao();

    @Override
    public void add(Map<String, String> member) {
        memberBoardDao.add(member);
    }

    @Override
    public Map<String, String> get(String boardNumber) {
        return memberBoardDao.get(boardNumber);
    }

    @Override
    public Map<String, Map<String, String>> list() {
        try {
            return memberBoardDao.getUserInfos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public void delete(String boardNumber) {
        memberBoardDao.delete(boardNumber);
    }

    @Override
    public void update(Member member) {

    }

    public void update(String index, Map<String, String> board) {
        memberBoardDao.update(index,board);
    }
}
