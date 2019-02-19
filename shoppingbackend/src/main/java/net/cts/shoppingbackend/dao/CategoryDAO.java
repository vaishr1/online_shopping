package net.cts.shoppingbackend.dao;

import java.util.List;

import net.cts.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);

}
