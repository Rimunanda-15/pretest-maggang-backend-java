package com.testFullStack.rimunanda.dao;

import com.testFullStack.rimunanda.dto.UserProductDto;
import com.testFullStack.rimunanda.entity.UserProduct;
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
public class UserProductDao {
    private final NamedParameterJdbcTemplate jdbcTemplate ;

    public void save(UserProductDto.Save inputData){
        String query = "INSERT INTO public.user_product(\n" +
                "\tuser_id, product_id, quantity)\n" +
                "\tVALUES (:userId, :productId, :quantity);";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("userId",inputData.getUserId());
        map.addValue("productId",inputData.getProductId());
        map.addValue("quantity",inputData.getQuantity());

        this.jdbcTemplate.update(query,map);
    }

    public void update(Integer id, UserProductDto.Update inputData){
        String query = "UPDATE public.user_product\n" +
                "\tSET user_id=:userId, product_id=:productId, quantity=:quantity\n" +
                "\tWHERE id=:id ;";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",id);
        map.addValue("userId",inputData.getUserId());
        map.addValue("productId", inputData.getProductId());
        map.addValue("quantity",inputData.getQuantity());

        this.jdbcTemplate.update(query,map);
    }

    public List<UserProduct> findAll(){


        String query = "SELECT id, user_id as userId, product_id as productId, quantity\n" +
                "\tFROM public.user_product;";

        return this.jdbcTemplate.query(query, new RowMapper<UserProduct>() {
            @Override
            public UserProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserProduct userProduct = new UserProduct();
                userProduct.setId(rs.getInt("id"));
                userProduct.setUserId(rs.getInt("userId"));
                userProduct.setProductId(rs.getInt("productId"));
                userProduct.setQuantity(rs.getInt("quantity"));
                return userProduct;
            }
        });
    }
    public Optional<UserProduct> findById(Integer id){
        String query = "SELECT id, user_id as userId, product_id as productId, quantity\n" +
                "\tFROM public.user_product WHERE id=:id;";
        MapSqlParameterSource map = new MapSqlParameterSource("id",id);

        try {
            return this.jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<UserProduct>>() {
                @Override
                public Optional<UserProduct> mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserProduct userProduct = new UserProduct();
                    userProduct.setId(rs.getInt("id"));
                    userProduct.setUserId(rs.getInt("userId"));
                    userProduct.setProductId(rs.getInt("productId"));
                    userProduct.setQuantity(rs.getInt("quantity"));
                    return Optional.of(userProduct);
                }
            });
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    public void delete(Integer id){
        String query = "DELETE FROM public.user_product WHERE id=:id ;";
        MapSqlParameterSource map = new MapSqlParameterSource("id",id);
        this.jdbcTemplate.update(query,map);
    }

    public void deleteByUser(Integer id) {
        String query = """
               DELETE FROM public.user_product WHERE user_id=:id
                """;

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        this.jdbcTemplate.update(query,map);
    }
}
