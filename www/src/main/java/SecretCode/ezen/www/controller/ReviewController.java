package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.ReviewVO;
import SecretCode.ezen.www.domain.ThemeVO;
import SecretCode.ezen.www.handler.PagingHandler;
import SecretCode.ezen.www.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {

    private final ReviewService rsv;
    private final ReviewCommentService rcsv;
    private final ThemeService themeService; // ThemeService 주입



    @GetMapping("/list")
    public String list(Model model, PagingVO pgvo) {
        log.info(">>>pgvo>>{}", pgvo);

        // Q&A 목록을 가져오는 서비스 호출
        List<ReviewVO> reviewList = rsv.getList(pgvo);


        // totalCount를 DB에서 가져오기
        int totalCount = rsv.getTotalCount(pgvo); // 검색어도 함께 고려

        // PagingHandler 객체 생성
        PagingHandler ph = new PagingHandler(pgvo, totalCount);

        // 모델에 Q&A 목록과 페이징 정보를 추가하여 뷰로 전달
        model.addAttribute("list", reviewList);
        model.addAttribute("ph", ph);


        return "review/list"; // 뷰 이름 반환
    }



    @GetMapping("/register")
    public String registerForm(Model model) {
        List<ThemeVO> themeList = themeService.getAllThemes();
        model.addAttribute("themeList", themeList);
        model.addAttribute("theme", "");
        model.addAttribute("themeText", "");

        return "review/register";
    }
    @PostMapping("/register")
    public String register(ReviewVO rvo) {
        log.info(">>>reviewVO>>{}", rvo);

        // UUID 설정
        UUID uuid = UUID.randomUUID(); // 랜덤 UUID 생성
        rvo.setUuid(uuid.toString()); // UUID 문자열로 설정

        // ReviewService를 사용하여 ReviewVO를 저장
        rsv.register(rvo);

        return "redirect:/review/list"; // 등록 후 Review 목록 페이지로 리다이렉트
    }

    @GetMapping("/getThemeDetails")
    public ResponseEntity<?> getThemeDetails(@RequestParam("themeNum") Long themeNum) {
        ThemeVO theme = themeService.getThemeDetails(themeNum);
        if (theme != null) {
            return ResponseEntity.ok(theme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}




