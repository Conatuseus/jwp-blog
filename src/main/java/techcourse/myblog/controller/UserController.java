package techcourse.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import techcourse.myblog.domain.User;
import techcourse.myblog.dto.UserDto;
import techcourse.myblog.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
// TODO 로그인 / 에러 처리는 아래와 동일
// TODO 로그아웃
// TODO 회원 수정
// TODO 회원 탈퇴
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public String createUser(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.save(userDto);
        return "login";
    }

    @GetMapping("")
    public String findAllUsersForm(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @PostMapping("/login")
    public String login(HttpSession session, UserDto userDto) {
        Optional<User> user = userService.findByEmailAndPassword(userDto);
        if (user.isPresent()) {
            session.setAttribute("user", user.get());
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
