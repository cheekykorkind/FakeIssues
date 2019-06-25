package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CityMapper {
    City findByState(@Param("state") String state);
}
