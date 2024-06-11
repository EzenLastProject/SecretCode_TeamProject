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
        // 테마 목록을 가져와서 모델에 추가
        List<ThemeVO> themeList = themeService.getAllThemes();
        model.addAttribute("themeList", themeList);

        // 선택된 테마와 테마 텍스트를 기본값으로 설정
        model.addAttribute("theme", ""); // 선택된 테마가 없는 경우 기본값은 빈 문자열로 설정
        model.addAttribute("themeText", ""); // 테마 텍스트도 마찬가지로 기본값 설정

        return "review/register"; // Review 등록 페이지로 이동
    }
    @GetMapping("/getThemeDetails")
    public ResponseEntity<?> getThemeDetails(@RequestParam("themeNum") Long themeNum) {
        ThemeVO theme = themeService.getThemeDetails(themeNum);
        if (theme != null) {
            return ResponseEntity.ok(theme); // 테마 정보가 있다면 200 OK 응답으로 테마 정보 반환
        } else {
            return ResponseEntity.notFound().build(); // 테마 정보가 없다면 404 Not Found 응답 반환
        }
    }

    @PostMapping("/register")
    public String register(ReviewVO reviewVO) {
        log.info(">>>reviewVO>>{}", reviewVO);

        rsv.register(reviewVO);

        return "redirect:/review/list"; // 등록 후 Review 목록 페이지로 리다이렉트
    }


}
