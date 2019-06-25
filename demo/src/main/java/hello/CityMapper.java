package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CityMapper {
    City findByState(@Param("state") String state);
}

// 자바 어노테이션 방식
// import org.apache.ibatis.annotations.Select;
// @Mapper
// public interface CityMapper {
//     @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
//     City findByState(@Param("state") String state);
// }