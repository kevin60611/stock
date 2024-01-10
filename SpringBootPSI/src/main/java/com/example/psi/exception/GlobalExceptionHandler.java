package com.example.psi.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller 全局 AOP 
/**
 * @ControllerAdvice 是 Spring 框架中的一個非常有用的註解，它允許你通過一個集中的方式處理整個應用程序的異常、綁定數據以及在控制器（Controllers）上進行前置處理。
 * @ControllerAdvice 可以被視為針對 Spring 控制器（Controllers）的一種面向切面編程（AOP）機制。
 * 它提供了一種集中式的方式來處理跨多個控制器的橫切關注點（cross-cutting concerns），如異常處理、數據綁定和預設模型屬性。
 * 
 * 這個註解的主要功能包括：
 * 全局異常處理：通過 @ExceptionHandler 註解在 @ControllerAdvice 註解的類中處理異常。這意味著你可以在一個地方定義所有控制器的異常處理邏輯，而不需要在每個控制器中個別定義。
 * 數據綁定：可以使用 @InitBinder 註解來自定義請求參數的綁定和格式化規則。這在處理日期和時間格式時特別有用。
 * Model屬性設置：使用 @ModelAttribute 註解，你可以為所有控制器方法定義默認的模型屬性。這在需要在多個控制器之間共享數據時非常有用。
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 捕捉所有類型的 Exception
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    // 您可以添加更多的異常處理方法來處理不同類型的異常
}

