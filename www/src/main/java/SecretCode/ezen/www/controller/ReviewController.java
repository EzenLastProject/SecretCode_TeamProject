package SecretCode.ezen.www.controller;


import SecretCode.ezen.www.domain.PagingVO;
import SecretCode.ezen.www.domain.QnaVO;
import SecretCode.ezen.www.domain.ReviewVO;
import SecretCode.ezen.www.domain.ThemeVO;
import SecretCode.ezen.www.handler.PagingHandler;
import SecretCode.ezen.www.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/review/*")
public class ReviewController {

    private final ReviewService rsv;

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
    public String register(ReviewVO rvo, @RequestParam("themeUuid") String themeUuid) {
        log.info(">>>reviewVO>>{}", rvo);

        // ReviewService를 사용하여 ReviewVO를 저장
        rvo.setUuid(themeUuid); // 선택된 테마의 UUID를 리뷰 객체에 설정
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

    @PostMapping("/like/{bno}")
    public ResponseEntity<?> likeReview(@PathVariable("bno") int bno) {
        try {
            rsv.incrementLikeCount(bno); // 좋아요를 증가시킴
            int readCount = rsv.getReadCount(bno); // 업데이트된 좋아요 수 조회
            return ResponseEntity.ok(Map.of("likes", readCount));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to like review");
        }
    }

    @PostMapping("/dislike/{bno}")
    public ResponseEntity<?> dislikeReview(@PathVariable("bno") int bno) {
        try {
            rsv.decrementLikeCount(bno); // 좋아요를 감소시킴
            int readCount = rsv.getReadCount(bno); // 업데이트된 좋아요 수 조회
            return ResponseEntity.ok(Map.of("likes", readCount));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to dislike review");
        }
    }
    // 리뷰 수정 화면
    @GetMapping("/modify/{bno}")
    public String modifyForm(@PathVariable int bno, Model model) {
        // bno를 이용해 수정할 리뷰 정보를 조회하여 모델에 담습니다.
        ReviewVO rvo = rsv.findById(bno); // 예시 메서드, 실제로는 데이터베이스 조회 등으로 대체해야 합니다.
        model.addAttribute("rvo", rvo);
        return "modifyForm"; // 수정 폼의 Thymeleaf 템플릿 이름
    }

    // 리뷰 수정 처리
    @PostMapping("/modify")
    public String modify(@ModelAttribute ReviewVO rvo) {
        rsv.modify(rvo);
        return "redirect:/review/list";
    }

    // 리뷰 삭제 처리
    @PostMapping("/delete")
    public String delete(@RequestParam("bno") int bno) {
        rsv.delete(bno);
        return "redirect:/review/list";
    }












}










