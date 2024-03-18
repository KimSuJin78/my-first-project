package dev.mvc.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.mvc.category.CategoryVO;
import jakarta.validation.Valid;

@RequestMapping("/category")
@Controller
public class CategoryCont {
  @Autowired
  @Qualifier("dev.mvc.category.CategoryProc")
  private CategoryProcInter categoryProc;
  
  public CategoryCont() {
    System.out.println("-> CategoryCont created.");
  }
  
//  @GetMapping(value="/create") // http://localhost:9092/category/create
//  @ResponseBody
//  public String create() {
//    return "<h2>Create test.</h2>";
//  }
  
  // create 폼 출력
  @GetMapping(value="/create") // http://localhost:9092/category/create
  public String create() {
    return "/category/create"; // /templates/category/create.html
  }
  
  // create 폼 데이터 처리
  @PostMapping(value="/create") // http://localhost:9092/category/create
  public String create(Model model, @Valid CategoryVO categoryVO, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "/category/create"; // /templates/category/msg.html
    }
    
    int cnt = this.categoryProc.create(categoryVO);
    System.out.println("-> cnt: " + cnt);
    
    if(cnt==1) {
      model.addAttribute("code", "create_success");
      model.addAttribute("nation", categoryVO.getNation());
      model.addAttribute("genre", categoryVO.getGenre());
      model.addAttribute("title", categoryVO.getTitle());     
    } else {
      model.addAttribute("code", "create_fail");
    }

    model.addAttribute("cnt", cnt);
    return "/category/msg"; // /templates/category/msg.html
    }
  
    @GetMapping(value="/list_all")
    public String list_all(Model model) {
      ArrayList<CategoryVO> list = this.categoryProc.list_all();
      model.addAttribute("list", list);
      
      return "/category/list_all"; // /category/list_all.html
    }
    
    /**
     * 조회
     * @param model
     * @param categoryno 조회할 카테고리 번호
     * @return
     */
    @GetMapping(value="/read/{categoryno}")
    public String read(Model model, @PathVariable("categoryno") Integer categoryno) {
      CategoryVO cateVO = this.categoryProc.read(categoryno);
      model.addAttribute("categoryVO", cateVO);
      
      return "/category/read";  // /templates/category/read.html
      
    }
    
    /**
     * 수정폼
     * @param model
     * @param categoryno 조회할 카테고리 번호
     * @return
     */
    @GetMapping(value="/update/{categoryno}")
    public String update(Model model, @PathVariable("categoryno") Integer categoryno) {
      CategoryVO cateVO = this.categoryProc.read(categoryno);
      model.addAttribute("cateVO", cateVO);
      
      return "/category/update";  // /templates/category/update.html
      
    }
    
    /**
     * 수정 처리
     * @param model
     * @param categoryVO
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/update") // http://localhost:9092/category/update
    public String update(Model model, @Valid CategoryVO categoryVO, BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
        return "/category/update";  // /templates/category/update.html
      }
      
      int cnt = this.categoryProc.update(categoryVO);
      System.out.println("-> cnt: " + cnt);
      
      if (cnt == 1) {
        model.addAttribute("code", "update_success");
        model.addAttribute("nation", categoryVO.getNation());
        model.addAttribute("genre", categoryVO.getGenre());
        model.addAttribute("title", categoryVO.getTitle());
      } else {
        model.addAttribute("code", "update_fail");
      }
      
      model.addAttribute("cnt", cnt);
      return "/category/msg"; // /templates/category/msg.html
    }
    
    /**
     * Delete form
     * http://localhost:9092/category/delete/
     * @param model
     * @param categoryno Category number to delete.
     * @return
     */
    @GetMapping(value="/delete/{categoryno}")
    public String delete(Model model, @PathVariable("categoryno") Integer categoryno) {
      CategoryVO categoryVO = this.categoryProc.read(categoryno);
      model.addAttribute("categoryVO", categoryVO);
      
      return "/category/delete";  // /templates/category/delete.html
      
    }
    
    /**
     * Delete process
     * @param model
     * @param categoryno 삭제할 레코드 번호
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/delete")
    public String delete_process(Model model, Integer categoryno) {
      CategoryVO categoryVO = this.categoryProc.read(categoryno); // 삭제 정보 출력용 객체
      // model.addAttribute("categoryVO", categoryVO);
      
      int cnt = this.categoryProc.delete(categoryno); // 삭제
      System.out.println("-> cnt: " + cnt);
      
      if (cnt == 1) {
        model.addAttribute("code", "delete_success");
        model.addAttribute("nation", categoryVO.getNation());
        model.addAttribute("genre", categoryVO.getGenre());
        model.addAttribute("title", categoryVO.getTitle());
      } else {
        model.addAttribute("code", "delete_fail");
      }
      
      model.addAttribute("cnt", cnt);
      return "/category/msg"; // /templates/category/msg.html
    }
  }
