package dev.mvc.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.mvc.category.CategoryVO;

//@Component("dev.mvc.category.CategoryProc")
@Service("dev.mvc.category.CategoryProc")
public class CategoryProc implements CategoryProcInter {
  @Autowired
  private CategoryDAOInter categoryDAO;
  
  public CategoryProc() {
    System.out.println("-> CategoryProc created.");
  }
  
  @Override
  public int create(CategoryVO categoryVO) {
    int cnt = this.categoryDAO.create(categoryVO);
    return cnt;
  }
  
  @Override
  public ArrayList<CategoryVO> list_all() {
    ArrayList<CategoryVO> list = this.categoryDAO.list_all();
    return list;
  }

  @Override
  public CategoryVO read(int categoryno) {
    CategoryVO categoryVO = this.categoryDAO.read(categoryno);
    return categoryVO;
  }

  @Override
  public int update(CategoryVO categoryVO) {
    int cnt = this.categoryDAO.update(categoryVO);
    return cnt;
  }

  @Override
  public int delete(int categoryno) {
    int cnt = this.categoryDAO.delete(categoryno);
    return cnt;
  }

}
