package dev.mvc.teample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class MsgCont {
  public MsgCont() {
    System.out.println("-> MsgCont created.");
  }
  
//http://localhost:9092/test
  @GetMapping(value={"/test"})
  @ResponseBody
  public String msg() {
    return "<h2>콘트롤러 정상 작동됨.</h2>";
  }
}
