package cn.edu.ujn.exam.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.ujn.exam.dao.Classroom;
import cn.edu.ujn.exam.dao.ClassroomMapper;
@Service("classroomService")
public class ClassroomServiceImpl implements IClassroomService {
@Autowired 
private ClassroomMapper classroomDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classroomDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.insert(record);
	}

	@Override
	public int insertSelective(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.insertSelective(record);
	}

	@Override
	public Classroom selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classroomDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public Classroom findByName(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return classroomDao.findByName(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return classroomDao.getTotal(queryMap);
	}

	@Override
	public int edit(Classroom record) {
		// TODO Auto-generated method stub
		return classroomDao.edit(record);
	}

	@Override
	public int delete(Long[] ids) {
		// TODO Auto-generated method stub
		return classroomDao.delete(ids);
	}

}
