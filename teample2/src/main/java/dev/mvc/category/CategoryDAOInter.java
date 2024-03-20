package dev.mvc.category;

import java.util.ArrayList;

import dev.mvc.category.CategoryVO;

public interface CategoryDAOInter {
  /**
   * 등록
   * insert id="create" parameterType="dev.mvc.category.CategoryVO"
   * @param cateVO
   * @return 등록한 레코드 갯수
   */
  public int create(CategoryVO categoryVO);
  
  /**
   * 전체 목록
   * select id="list_all" resultType="dev.mvc.category.CategoryVO"     
   * @return 레코드 목록
   */
  public ArrayList<CategoryVO> list_all();
  
  /**
   * 조회
   * select id="read" resultType="dev.mvc.category.CategoryVO" parameterType="int"
   * @param categoryno
   * @return
   */
  public CategoryVO read(int categoryno);
  
  /**
   * 수정
   * update id="update" parameterType="dev.mvc.category.CategoryVO"    
   * @param categoryVO
   * @return 수정된 레코드 갯수
   */
  public int update(CategoryVO categoryVO);
  
  /**
   * delete
   * delete id="delete" parameterType="Integer"
   * @param categoryno
   * @return
   */
  public int delete(int categoryno);
}
