package com.product.dao.impl;

import com.product.constant.ProductCategory;
import com.product.dao.ProductDao;
import com.product.dto.ProductQueryParams;
import com.product.dto.ProductRequest;
import com.product.model.Product;
import com.product.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        String sql = "SELECT count(*) FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

//      共用SQL拼接查詢條件
        addFilteringSql(sql , map , productQueryParams);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql , map , Integer.class);

        return total;
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id ,product_name, category, image_url, price, stock, description, created_date, last_modified_date " +
                "FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();
//      共用SQL拼接查詢條件
        addFilteringSql(sql , map , productQueryParams);
//      排序條件
        sql += " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();
//      分頁條件
        sql += " LIMIT :limit OFFSET :offset";
        map.put("limit",productQueryParams.getLimit());
        map.put("offset",productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id ,product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM" +
                " product WHERE product_id =:productId;";

        Map<String, Object> map = new HashMap<>();

        map.put("productId",productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());

        if(productList.size() > 0){
            return productList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
//        String sql = "INSERT INTO product(product_name , category , image_url , price , stock, " +
//                "description , created_date , last_moodified_date" +
//                "VALUES(:productName, :category , :imageUrl , :price , :stock , :description,)" +
//                ":createDate, :lastModifiedDate";

        String sql = "INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date)" +
                "VALUES (:productName, :category, :imageUrl, :price, :stock, :description, :createDate , :lastModifiedDate);";

        Map<String , Object> map = new HashMap<>();
        map.put("productName" , productRequest.getProduct_name());
        map.put("category" , productRequest.getCategory().toString());
        map.put("imageUrl" , productRequest.getImage_url());
        map.put("price" , productRequest.getPrice());
        map.put("stock" , productRequest.getStock());
        map.put("description" , productRequest.getDescription());

        Date now = new Date();
        map.put("createDate" , now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;

    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName , category = :category , image_url =:imageUrl," +
                "price = :price , stock = :stock , description = :description , last_modified_date = :lastModifiedDate " +
                "WHERE product_id = :productId";

        Map<String , Object> map = new HashMap<>();
        map.put("productId" , productId);

        map.put("productName" , productRequest.getProduct_name());
        map.put("category" , productRequest.getCategory().toString());
        map.put("imageUrl" , productRequest.getImage_url());
        map.put("price" , productRequest.getPrice());
        map.put("stock" , productRequest.getStock());
        map.put("description" , productRequest.getDescription());

        map.put("lastModifiedDate" , new Date());

        namedParameterJdbcTemplate.update(sql,map);
    }
//  共用SQL拼接查詢條件
    private String addFilteringSql(String sql , Map<String,Object> map , ProductQueryParams productQueryParams){

        if (productQueryParams.getCategory() != null) {
            sql += " AND category = :category";
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch() != null){
            sql += " AND product_name LIKE :search";
            map.put("search" , "%" + productQueryParams.getSearch() + "%");
        }
        return sql;
    }
}
