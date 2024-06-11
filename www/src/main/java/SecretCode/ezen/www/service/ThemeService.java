package SecretCode.ezen.www.service;

import SecretCode.ezen.www.domain.ThemeVO;
import org.springframework.ui.context.Theme;

import java.util.List;

public interface ThemeService {

    List<ThemeVO> getAllThemes();


    ThemeVO getThemeDetails(Long themeNum);
}
