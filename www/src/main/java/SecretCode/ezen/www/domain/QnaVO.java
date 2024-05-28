package SecretCode.ezen.www.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnaVO {


    private int bno;
    private String title;
    private String writer;
    private  String content;
    private String isDel;
    private String regDate;
    private int readCount;
    private int cmtQty;
    private String isSecret; //비밀글 여부








}
