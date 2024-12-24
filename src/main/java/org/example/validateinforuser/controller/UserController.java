package org.example.validateinforuser.controller;

import org.example.validateinforuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user,
                                        BindingResult bindingResult) {
        //Lưu giữ thông tin về các lỗi xảy ra trong quá trình ánh xạ dữ liệu hoặc kiểm tra tính hợp lệ.
        if (bindingResult.hasFieldErrors()) {  //kiểm tra xem có lỗi nào liên quan đến trường dữ liệu không
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
