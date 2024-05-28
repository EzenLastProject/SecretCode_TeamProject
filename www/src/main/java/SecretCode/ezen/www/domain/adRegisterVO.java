package SecretCode.ezen.www.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class adRegisterVO {
    private int rno;
    private String tname;
    private String content;
    private String difficulty;
    private int usingTime;
    private int price;
    private String uuid;






    /*create table theme(
            rno int auto_increment,
            tname varchar(100) not null,
    content varchar(200) not null,
    price int not null,
    difficulty varchar(50) not null,
    usingtime int not null,
    uuid varchar(256),
    primary key(rno),
    foreign key(uuid) references file(uuid));*/

}
