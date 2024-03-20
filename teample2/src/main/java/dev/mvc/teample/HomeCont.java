package dev.mvc.teample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCont {
  public HomeCont() {
    System.out.println("-> HomeCont created.");
  }
  
// http://localhost:9092, http://192.168.45.113:9092/, http://192.168.12.159:9092/
// @GetMapping(value="/192.168.45.113") // 집에서 접속 시
  @GetMapping(value="/192.168.12.159") // 학원에서 접속 시
  public String home() { // 파일명 return
    return "index"; // /templates/index.html
  }
}
