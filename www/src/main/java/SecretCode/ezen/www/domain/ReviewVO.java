package SecretCode.ezen.www.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewVO {

    private int bno;
    private int rno;
    private String title;
    private String writer;
    private  String content;
    private String isDel;
    private String regDate;
    private int readCount;
    private int cmtQty;
}
