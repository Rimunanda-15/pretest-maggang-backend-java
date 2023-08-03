package com.testFullStack.rimunanda.dao;

import com.testFullStack.rimunanda.dto.CategoriesDto;
import com.testFullStack.rimunanda.entity.Categories;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryDao {
    private final NamedParameterJdbcTemplate jdbcTemplate ;

    public void save(CategoriesDto.Save inputData){
        String query ="INSERT INTO public.category(\n" +
                "\tname)\n" +
                "\tVALUES (:name);";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name",inputData.getName());
        this.jdbcTemplate.update(query,map);

    }
    public void  update(int id, CategoriesDto.Update inputData){
        String query="UPDATE public.category\n" +
                "\tSET name=:name\n" +
                "\tWHERE id=:id ;";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",id);
        map.addValue("name",inputData.getName());
        this.jdbcTemplate.update(query,map);
    }

    public List<Categories> findAll(){
        String query = "SELECT id, name\n" +
                "\tFROM public.category;";

        return this.jdbcTemplate.query(query, new RowMapper<Categories>() {
            @Override
            public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                return category;
            }
        });
    }
    public Optional<Categories> findById(Integer id){
        String query = "SELECT id, name\n" +
                "\tFROM public.category where id=:id ;";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",id);
        try {
            return  this.jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<Categories>>() {
                @Override
                public Optional<Categories> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Categories category = new Categories();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("name"));
                    return Optional.of(category);
                }
            });
        }catch (EmptyResultDataAccessException e){
            return  Optional.empty();
        }
    }

    public void delete(Integer id){
        String query ="DELETE FROM public.category WHERE id=:id ;";
        MapSqlParameterSource map = new MapSqlParameterSource("id",id);
        this.jdbcTemplate.update(query,map);
    }
}
