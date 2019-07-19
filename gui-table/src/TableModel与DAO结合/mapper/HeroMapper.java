package TableModel与DAO结合.mapper;

import TableModel与DAO结合.pojo.Hero;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HeroMapper {
    @Insert(" insert into hero_ ( name ) values (#{name}) ")
    public int add(Hero hero);

    @Delete(" delete from hero_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from hero_ where id= #{id} ")
    public Hero get(int id);

    @Update("update hero_ set name=#{name} where id=#{id} ")
    public int update(Hero hero);

    @Select(" select * from hero_ ")
    public List<Hero> list();
}
