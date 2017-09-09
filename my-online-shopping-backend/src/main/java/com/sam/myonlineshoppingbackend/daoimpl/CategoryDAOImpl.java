package com.sam.myonlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sam.myonlineshoppingbackend.dao.CategoryDAO;
import com.sam.myonlineshoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		category.setId(1);
		category.setName("Television");
		category.setDescription("this is some decription for TV ");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		Category category2 = new Category();

		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("this is some decription for Mobile ");
		category2.setImageURL("CAT_2.png");

		categories.add(category2);

		Category category3 = new Category();

		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("this is some decription for laptop ");
		category3.setImageURL("CAT_3.png");

		categories.add(category3);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		for(Category category : categories){
			
			if(category.getId() == id) return category;
		}
		
		
		return null;
	}

}
