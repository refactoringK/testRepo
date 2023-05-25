package com.example.app.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor @RequiredArgsConstructor
public class ReplyDto {
    private Long replyNumber;
    @NonNull
    private String replyContent;
    @NonNull
    private String replyRegisterDate;
    @NonNull
    private String replyUpdateDate;
    @NonNull
    private Long boardNumber;
    @NonNull
    private Long userNumber;


//    @Builder
//    public ReplyDto( String replyContent,  String replyRegisterDate,  Long boardNumber,  Long userNumber) {
//        this.replyContent = replyContent;
//        this.replyRegisterDate = replyRegisterDate;
//        this.boardNumber = boardNumber;
//        this.userNumber = userNumber;
//    }
}








