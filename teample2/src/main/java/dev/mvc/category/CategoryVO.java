package dev.mvc.category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE CATEGORY(
//    CATEGORYNO                        NUMBER(10)     NOT NULL,
//    NATION                            VARCHAR2(30)     NOT NULL,
//    GENRE                             VARCHAR2(30)     DEFAULT '-'     NOT NULL,
//    TITLE                             VARCHAR2(30)     DEFAULT '*'     NOT NULL,
//    CNT                               NUMBER(10)     DEFAULT 0     NOT NULL,
//    RDATE                             DATE     NOT NULL,
//    SEQNO                             NUMBER(5)    NOT NULL,
//    VISIBLE                           CHAR(1)    DEFAULT 'N'     NOT NULL,
//    PEOPLE                            NUMBER(10)     DEFAULT 0     NOT NULL
//);

@Setter @Getter
public class CategoryVO {
  /** 카테고리 번호 */
  private Integer categoryno=0;
  
  /** 국가 */
  @NotEmpty(message="국가 입력은 필수입니다.")
  @Size(min=2, max=10, message="국가 입력 글자 수는 최소 2자에서 10자 이내이어야합니다.")
  private String nation;
  
  /** 장르 */
  @NotEmpty(message="장르 입력은 필수입니다.")
  @Size(min=2, max=10, message="장르 입력 글자 수는 최소 2자에서 10자 이내이어야합니다.")
  private String genre;
  
  /** 제목 */
  @NotEmpty(message="제목 입력은 필수입니다.")
  @Size(min=2, max=10, message="제목 입력 글자 수는 최소 2자에서 10자 이내이어야합니다.")
  private String title;
  
  /** 관련 자료 수 */
  @NotNull(message="관련 자료 수는 필수 입력 항목입니다.")
  @Min(value=0)
  @Max(value=1000000)
  private Integer cnt=0;
  
  /** 등록일 */
  private String rdate;
  
  /** 출력 순서 */
  @NotNull(message="출력 순서는 필수 입력 항목입니다.")
  @Min(value=1)
  @Max(value=1000000)
  private Integer seqno=1;
  
  /** 출력 모드 */
  @NotEmpty(message="출력 모드는 필수 입력 항목입니다.")
  @Pattern(regexp="^[YN]$", message="Y 또는 N 만 입력 가능합니다!")
  private String visible="N";
  
  /** 조회수 */
  @Min(value=1)
  @Max(value=1000000)
  private Integer people=1;
  
}
