package com.example.backend.ajaxbackend;

import com.example.backend.domain.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class HomeController {
	@GetMapping("/home")
	public String corstest() {
		return "CORS 설정을 하지 않았어요ㅜㅜ";
	}
}
