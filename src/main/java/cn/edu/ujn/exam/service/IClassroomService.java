package cn.edu.ujn.exam.service;

import java.util.Map;

import cn.edu.ujn.exam.dao.Classroom;

public interface IClassroomService {
	int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    Classroom findByName(Map<String, Object> queryMap);
    int getTotal(Map<String, Object> queryMap);
    int edit(Classroom record);
    int delete(Long[] ids);
}
