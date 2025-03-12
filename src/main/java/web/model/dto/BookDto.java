package web.model.dto;

import lombok.*;

@Getter@Setter@Builder@ToString
@AllArgsConstructor@NoArgsConstructor
public class BookDto {

    private int ino;
    private String pwd;
    private String title;
    private String writer;
    private String intro;



}
