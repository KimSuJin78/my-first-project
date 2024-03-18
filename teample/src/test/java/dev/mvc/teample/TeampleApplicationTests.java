package dev.mvc.teample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import dev.mvc.category.CategoryDAOInter;
import dev.mvc.category.CategoryProcInter;
import dev.mvc.category.CategoryVO;

@SpringBootTest
class TeampleApplicationTests {
  @Autowired
  private CategoryDAOInter categoryDAO;
  
  @Autowired
  @Qualifier("dev.mvc.category.CategoryProc")
  private CategoryProcInter categoryProc;

  @Test
  void contextLoads() { 
  }

//  @Test
//  public void testCreate() {
//    CategoryVO categoryVO = new CategoryVO();
//    categoryVO.setNation("국내");
//    categoryVO.setGenre("-");
//    categoryVO.setTitle("도가니");
//    
//    int cnt = this.categoryDAO.create(categoryVO);
//    System.out.println("-> cnt: " + cnt);
//  }
  
//  @Test
//  public void testCreate() {
//    CategoryVO categoryVO = new CategoryVO();
//    categoryVO.setNation("해외");
//    categoryVO.setGenre("공포");
//    categoryVO.setTitle("*");
//    
//    int cnt = this.categoryProc.create(categoryVO);
//    System.out.println("-> cnt: " + cnt);
//  }
  
//@Test
//public void testList_all() {
//  ArrayList<CategoryVO> list = this.categoryDAO.list_all();
//  for (CategoryVO categoryVO : list) {
//    System.out.println(categoryVO.getNation() + " - " + categoryVO.getGenre() + " - " + categoryVO.getTitle());
//  }     
//}

//@Test
//public void testList_all() {
// ArrayList<CategoryVO> list = this.categoryProc.list_all();
// for (CategoryVO categoryVO : list) {
//    System.out.println(categoryVO.getNation() + " - " + categoryVO.getGenre() + " - " + categoryVO.getTitle());
// }     
//}
  
}