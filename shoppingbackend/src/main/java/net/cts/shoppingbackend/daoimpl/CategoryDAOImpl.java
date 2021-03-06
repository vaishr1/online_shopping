package net.cts.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.cts.shoppingbackend.dao.CategoryDAO;
import net.cts.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("some TV description");
		category.setImageURL("CAT_1");
		// category.setActive(true);
		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("some mobile description");
		category.setImageURL("CAT_2");
		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("some laptop description..my favorite laptop");
		category.setImageURL("CAT_3");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//enhanced for loop
		for(Category category: categories) {
			if(category.getId()==id)return category;
		}
		
		return null;
	}

}
