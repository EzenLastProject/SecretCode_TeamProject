package SecretCode.ezen.www.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnaCommentVO {


    private  int bno;
    private  int cno;
    private String writer;
    private String content;
    private String regDate;
    private String modDate;


}