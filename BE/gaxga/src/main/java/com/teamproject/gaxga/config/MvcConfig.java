package com.teamproject.gaxga.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*이미지 업로드하여 게시글 생성하면 이미지 바로 출력가능한 설정
 웹에서 정적 파일을 제공하기 위해 서버가 해당 파일의 위치를 알고, 요청받은 url에 따라 적절한 파일 반환이 필요
 여기서는
  1.addResourceHandler에서 /upload/로 시작하는 모든 요청 url(이미지url)을 처리
 2. addResourceLocations를 통해 리소스 위치 지정하여 서버가 파일을 찾을 위치를 알려준다.
 3. 요청처리 -> 사용자가 웹 브라우저를 통해 특정 이미지 파일을 요청하면 웹서버는
 addResourceHandlers 에 설정한 규칙을 사용하여 upload/** 위치에서 파일을 찾는다.
 4. 파일을 반환한다 -> 웹 서버는 이 파일을 읽고 사용자의 브라우저로 전달한다.-*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // 개발 시점에 사용 가능한 코드.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { //정적 파일들의 경로를 잡아주는 메서드
        registry
                .addResourceHandler("/upload/**")
               /*addResourceHandler 메서드에서 설정한 URL 패턴과 실제 이미지 URL이 일치해야한다.
                이 프로젝트에서는 @Value("C:\\Team_Project\\BE\\gaxga\\src\\main\\resources\\static\\upload")
                경로로 주고있기 때문에, handler path에 /upload/** 로 주는것이 맞다.*/
                .addResourceLocations("file:///D:/upload/");
    }
    // 배포 시점에 사용 가능한 코드.
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/files/**")
//                .addResourceLocations("file:/opt/files/");
//
//        // 윈도우라면
//         .addResourceLocations(“file:///C:/opt/files/“);
//    }
}


