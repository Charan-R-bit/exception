package com.artistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artistry.entity.Cart;

@Repository("CartDao")
public interface CartRepository extends JpaRepository<Cart,Integer>
{

}
