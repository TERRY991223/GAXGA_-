package com.teamproject.gaxga.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class JoinMembershipForm {
    private Long userCode;
    private String gaId;
    private String gaPass;
    private String gaNick;
    private String gaPhone;
    private String gaAddress;
    private String gaDetailAddress;
    private String gaEmail;
    private String gaP_Image;
}
