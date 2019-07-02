package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
    public Member findById(@Param("id") long id);
}

// @Mapper
// public interface CityMapper {
//     City findByState(@Param("state") String state);
// }


 


